package com.blueground.assignment;

import com.blueground.assignment.config.JwtTokenProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.TestCase.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenAuthenticationServiceTest {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/unit/get")).andExpect(status().isForbidden());
    }

    @Test
    public void shouldAllowAccessToAuthenticatedUsers() throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("pk", "1234"));
        String token = jwtTokenProvider.createToken("pk");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders.get("/unit/getAll?page=1&size=10").header("Authorization", token))
                .andExpect(status().isOk());
    }

}
