package com.ssafy.enjoytrip.jwt.model.dao;

import com.ssafy.enjoytrip.jwt.model.dto.RefreshTokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Repository
public class JwtRepository {

    @Value("${refreshtoken.timeout.second}")
    private long TIME_OUT_SECOND;
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public JwtRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(final RefreshTokenDto refreshTokenDto) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(
                refreshTokenDto.getRefreshToken(),
                refreshTokenDto.getUserId(),
                TIME_OUT_SECOND,
                TimeUnit.SECONDS
                );
    }

    public Optional<RefreshTokenDto> findByRefreshToken(final String refreshToken) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String userId = valueOperations.get(refreshToken);

        if (Objects.isNull(userId)) {
            return Optional.empty();
        }

        return Optional.of(new RefreshTokenDto(
                refreshToken,userId));
    }
}
