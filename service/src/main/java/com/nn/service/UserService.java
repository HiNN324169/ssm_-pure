package com.nn.service;

import com.nn.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public interface UserService {

    public List<User> queryAll();
}
