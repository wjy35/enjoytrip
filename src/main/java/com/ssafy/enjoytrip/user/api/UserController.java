package com.ssafy.enjoytrip.user.api;


import com.ssafy.enjoytrip.jwt.model.service.JwtService;
import com.ssafy.enjoytrip.user.model.dto.User;
import com.ssafy.enjoytrip.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String userId, @RequestBody String password){
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            User user = userService.login(userId,password);
            if (user != null) {
                String accessToken = jwtService.generateAccessToken(userId);
                String refreshToken = jwtService.generateRefreshToken(userId);

                resultMap.put("access-token", accessToken);
                resultMap.put("refresh-token", refreshToken);
                resultMap.put("success", true);
            } else {
                resultMap.put("success", false);
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            resultMap.put("success",false);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(resultMap, status);
    }
}
