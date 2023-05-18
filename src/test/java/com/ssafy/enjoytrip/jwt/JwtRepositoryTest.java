package com.ssafy.enjoytrip.jwt;

import com.ssafy.enjoytrip.jwt.model.dao.JwtRepository;
import com.ssafy.enjoytrip.jwt.model.dto.RefreshTokenDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JwtRepositoryTest {

    @Autowired
    JwtRepository jwtRepository;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    void testLoadBean(){
        System.out.println(jwtRepository);
        assertNotNull(jwtRepository);
    }

    @Test
    void testSaveRefreshToken(){
        //given
        RefreshTokenDto refreshTokenDto = createRefreshTokenDto();

        //when
        jwtRepository.save(refreshTokenDto);

        //then
        assertNotNull(redisTemplate.opsForValue().get(refreshTokenDto.getRefreshToken()));
    }

    @Test
    void testFind(){
        //given
        RefreshTokenDto refreshTokenDto = createRefreshTokenDto();
        jwtRepository.save(refreshTokenDto);

        //when
        RefreshTokenDto findTokenDto = jwtRepository.findByRefreshToken(refreshTokenDto.getRefreshToken()).get();

        //then
        assertEquals(refreshTokenDto.getRefreshToken(),findTokenDto.getRefreshToken());
    }


    RefreshTokenDto createRefreshTokenDto(){
        String refreshToken = "TestToken";
        String userId = "test";

        RefreshTokenDto refreshTokenDto = RefreshTokenDto
                .builder()
                .refreshToken(refreshToken)
                .userId(userId)
                .build();

        return refreshTokenDto;
    }
}
