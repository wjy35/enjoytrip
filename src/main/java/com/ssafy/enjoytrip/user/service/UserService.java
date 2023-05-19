package com.ssafy.enjoytrip.user.service;

import com.ssafy.enjoytrip.user.model.dto.User;

public interface UserService {
    User login(String userId,String password);

    int join(User user);

    int modify(User user);

    int leave(String userId);
}
