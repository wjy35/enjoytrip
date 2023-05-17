package com.ssafy.enjoytrip.user.service;

import com.ssafy.enjoytrip.user.model.dto.User;
import com.ssafy.enjoytrip.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public int join(User user) {
        return userMapper.insertByUser(user);
    }

    @Override
    public int modify(User user) {
        return 0;
    }

    @Override
    public int leave(String userId) {
        return 0;
    }
}

