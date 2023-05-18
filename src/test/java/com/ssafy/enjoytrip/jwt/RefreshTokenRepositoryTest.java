package com.ssafy.enjoytrip.jwt;

import com.ssafy.enjoytrip.jwt.model.dao.RefreshTokenRepository;
import com.ssafy.enjoytrip.jwt.model.dto.RefreshTokenDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RefreshTokenRepositoryTest {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    void testLoadBean(){
        System.out.println(refreshTokenRepository);
        assertNotNull(refreshTokenRepository);
    }

    @Test
    void testSaveRefreshToken(){
        //given
        RefreshTokenDto refreshTokenDto = createRefreshTokenDto();

        //when
        refreshTokenRepository.save(refreshTokenDto);

        //then
        assertNotNull(redisTemplate.opsForValue().get(refreshTokenDto.getRefreshToken()));
    }

    @Test
    void testFind(){
        //given
        RefreshTokenDto refreshTokenDto = createRefreshTokenDto();
        refreshTokenRepository.save(refreshTokenDto);

        //when
        RefreshTokenDto findTokenDto = refreshTokenRepository.findByRefreshToken(refreshTokenDto.getRefreshToken()).get();

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
