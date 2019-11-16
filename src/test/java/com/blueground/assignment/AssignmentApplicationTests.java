package com.blueground.assignment;

import com.blueground.assignment.service.UnitServiceApi;
import com.blueground.assignment.service.UserServiceApi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignmentApplicationTests {

    @Autowired
    UserServiceApi userServiceApi;
    @Autowired
    UnitServiceApi unitServiceApi;

    public AssignmentApplicationTests() {
    }

    @Test
    public void contextLoads() { }

    @Before
    public void login() {

    }

    @Test
    public void getAllUnits(){
        assertNotNull(unitServiceApi.getByPage(1,10));
    }

}
