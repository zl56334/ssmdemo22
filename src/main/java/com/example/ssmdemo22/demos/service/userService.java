package com.example.ssmdemo22.demos.service;

import com.example.ssmdemo22.demos.entity.User;

import java.util.List;

public interface userService {
    public User getUser(Integer id);

    List<User> selectAll();
}
