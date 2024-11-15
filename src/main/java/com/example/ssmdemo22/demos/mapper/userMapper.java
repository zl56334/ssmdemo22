package com.example.ssmdemo22.demos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ssmdemo22.demos.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface userMapper extends BaseMapper<User> {
    public List<User> selectAll();
}