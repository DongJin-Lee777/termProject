package com.termproject.dongjin.service;

import com.termproject.dongjin.domain.Users;
import com.termproject.dongjin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    public Users login(Users users) {
        return userMapper.login(users);
    }
}
