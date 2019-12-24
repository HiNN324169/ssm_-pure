package com.nn.service.imp;

import com.nn.entity.User;
import com.nn.mapper.UserMapper;
import com.nn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userServiceImp")
public class UserServiceImp implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    public List<User> queryAll() {
        return userMapper.queryAll();
    }
}
