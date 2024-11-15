package com.example.ssmdemo22.demos.service.impl;

import com.example.ssmdemo22.demos.entity.User;
import com.example.ssmdemo22.demos.service.userService;
import com.example.ssmdemo22.demos.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
