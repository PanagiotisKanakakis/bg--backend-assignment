package com.blueground.assignment;

import com.blueground.assignment.exception.CustomException;
import com.blueground.assignment.service.UnitServiceApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitServiceTests {

    @Autowired
    UnitServiceApi unitServiceApi;

    public UnitServiceTests() {
    }

    @Test(expected = CustomException.class)
    public void getAllUnitsWithInvalidPageNumber() {
        unitServiceApi.getByPage(0,10);
    }

    @Test(expected = CustomException.class)
    public void getAllUnitsWithInvalidPageSize() {
        /*create review with invalid rate range*/
        unitServiceApi.getByPage(1,0);
    }

    @Test
    public void validGetAllUnits() {
        assertNotNull(unitServiceApi.getByPage(1, 10));
    }

    @Test(expected = CustomException.class)
    public void reviewWithInvalidUsername() {
        /*create review with invalid username*/
        unitServiceApi.review("nonValidUser", 1, 3, "test");
    }

    @Test(expected = CustomException.class)
    public void reviewWithInvalidUnit() {
        /*create review with invalid unit id*/
        unitServiceApi.review("pk", 222, 3, "test");
    }

    @Test(expected = CustomException.class)
    public void reviewWithInvalidRateRange() {
        /*create review with invalid rate range*/
        unitServiceApi.review("pk", 1, 6, "test");
    }

    @Test
    public void validReview() {
//        assertNotNull(unitServiceApi.review("pk",1,3, "test"));
    }

    @Test(expected = CustomException.class)
    public void invalidSearch() {
        unitServiceApi.search(1,10,null,null);
    }

    @Test
    public void searchByRegion() {
        assertEquals(unitServiceApi.search(1,10,"paris",null).getTotalElements(),4);
    }

    @Test
    public void searchByTitile() {
        assertEquals(unitServiceApi.search(1,10,null,"one").getTotalElements(),5);
    }


}
