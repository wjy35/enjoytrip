package com.ssafy.enjoytrip.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class UserEncoder {

    public String hashPassword(String raw) {
        return BCrypt.hashpw(raw, BCrypt.gensalt());
    }

    public boolean isMatch(String raw, String hashed) {
        return BCrypt.checkpw(raw, hashed);
    }
}
