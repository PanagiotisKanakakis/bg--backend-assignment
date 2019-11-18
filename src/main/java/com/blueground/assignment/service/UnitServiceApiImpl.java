package com.blueground.assignment.service;

import com.blueground.assignment.dao.UnitRepository;
import com.blueground.assignment.dao.UserRepository;
import com.blueground.assignment.dto.UnitResponseDto;
import com.blueground.assignment.entity.ReviewEntity;
import com.blueground.assignment.entity.UnitEntity;
import com.blueground.assignment.exception.CustomException;
import com.blueground.assignment.mapper.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UnitServiceApiImpl implements UnitServiceApi {

    @Autowired
    UnitRepository unitRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UnitMapper unitMapper;

    @Override
    public Page<UnitResponseDto> getByPage(Integer page, Integer size) {
        Pageable pageRequest = createPageRequest(page, size);
        return unitRepository.findAll(pageRequest).map(x -> unitMapper.toUnitResponseDTO(x));
    }

    private Pageable createPageRequest(Integer page, Integer size) {
        validateInputParams(page, size);
        return new PageRequest(
                ((page == null) ? 0 : (page - 1)),
                ((size == null) ? 10 : size), Sort.Direction.DESC, "averageScore");
    }

    private void validateInputParams(Integer page, Integer size) {
        if (page == 0)
            throw new CustomException("Page number should be greater than zero!", HttpStatus.BAD_REQUEST);
        if (size == 0)
            throw new CustomException("Page size should be greater than zero!", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Page<UnitResponseDto> search(Integer page, Integer size, String region, String title) {
        validateSearchInputParams(title, region);
        Pageable pageRequest = createPageRequest(page, size);
        return unitRepository.findAllByTitleOrRegion(title, region, pageRequest)
                .map(x -> unitMapper.toUnitResponseDTO(x));
    }

    private void validateSearchInputParams(String title, String region) {
        if (title == null && region == null)
            throw new CustomException("One of title or region should not be null", HttpStatus.BAD_REQUEST);
    }

    @Override
    public UnitResponseDto review(String username, Integer unitId, Integer rate, String comment) {
        validateInputParams(username, unitId, rate);
        ReviewEntity reviewEntity = createReviewEntity(username, unitId, rate, comment);
        UnitEntity unitEntity = unitRepository.findOne(unitId);
        unitEntity.getReviews().add(reviewEntity);
        unitEntity.setAverageScore(calculateAverageScore(unitEntity));
        unitRepository.save(unitEntity);
        return unitMapper.toUnitResponseDTO(unitEntity);
    }

    private Double calculateAverageScore(UnitEntity unitEntity) {
        return unitEntity.getReviews().stream().mapToInt(ReviewEntity::getScore).summaryStatistics().getAverage();
    }

    private ReviewEntity createReviewEntity(String username, Integer unitId, Integer rate, String comment) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setScore(rate);
        reviewEntity.setReview(comment);
        reviewEntity.getReviewEntityPK().setUnitEntity(unitRepository.findOne(unitId));
        reviewEntity.getReviewEntityPK().setUserEntity(userRepository.findOne(username));
        return reviewEntity;
    }

    private void validateInputParams(String username, Integer unitId, Integer rate) {
        if (userRepository.findOne(username) == null)
            throw new CustomException("User does not exist!", HttpStatus.BAD_REQUEST);
        if (unitRepository.findOne(unitId) == null)
            throw new CustomException("Unit does not exist!", HttpStatus.BAD_REQUEST);
        if (rate <= 1 || rate >= 5)
            throw new CustomException("Rate value should be between 1 to 5!", HttpStatus.BAD_REQUEST);
    }
}
