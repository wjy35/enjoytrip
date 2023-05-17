package com.ssafy.enjoytrip.jwt;

import com.ssafy.enjoytrip.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JwtUtilTest {

    @Autowired
    JwtUtil jwtUtil;

    @Test
    public void testLoadJwtUtil(){

        // then
        assertNotNull(jwtUtil);
    }

    @Test
    public void testTokenGenerate(){
        // given
        String id = "ssafy";

        // when
        String token = jwtUtil.createAccessToken("id","ssafy");

        // then
        assertNotNull(token);
    }

    @Test
    public void testCheckTokenReturnTrue(){
        // given
        String token = jwtUtil.createAccessToken("id","ssafy");

        // when-then
        assertEquals(jwtUtil.checkToken(token),true);
    }

    @Test
    public void testCheckTokenReturnFalse(){
        // given
        String fakeToken = "GeniusWangJunYoung";

        // when-then
        assertEquals(jwtUtil.checkToken(fakeToken),false);
    }

}
