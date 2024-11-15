package com.example.ssmdemo22.demos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ssmdemo22.demos.entity.StudentLatenciesInfo;
import com.example.ssmdemo22.demos.form.AddStudentLatenciesInfoForm;
import com.example.ssmdemo22.demos.mapper.StudentLatenciesInfoMapper;
import com.example.ssmdemo22.demos.service.StudentLatenciesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentLatenciesInfoServiceImpl implements StudentLatenciesInfoService {

    @Autowired
    private StudentLatenciesInfoMapper studentLatenciesInfoMapper;

    @Override
    public List<StudentLatenciesInfo> getStudentLatenciesInfo() {
        return studentLatenciesInfoMapper.selectList(
                new QueryWrapper<StudentLatenciesInfo>().orderByDesc("number_latencies")
        );
    }

    @Override
    public Integer deleteStudentLatenciesInfo(Integer id) {
        return studentLatenciesInfoMapper.deleteById(id);
    }

    @Override
    public Integer updateStudentLatenciesInfo(Integer id, Integer latencies) {

        StudentLatenciesInfo studentLatenciesInfo = new StudentLatenciesInfo();
        studentLatenciesInfo.setId(id);
        studentLatenciesInfo.setNumberLatencies(latencies);
        studentLatenciesInfo.setUpdateTime(new Date());

        return studentLatenciesInfoMapper.updateById(studentLatenciesInfo);
    }

    @Override
    public Integer addStudentLatenciesInfo(AddStudentLatenciesInfoForm addStudentLatenciesInfoForm) {
        StudentLatenciesInfo studentLatenciesInfo = new StudentLatenciesInfo();
        studentLatenciesInfo.setStudentNo(addStudentLatenciesInfoForm.getStudentNo());
        studentLatenciesInfo.setStudentName(addStudentLatenciesInfoForm.getStudentName());
        studentLatenciesInfo.setNumberLatencies(addStudentLatenciesInfoForm.getNumberLatencies());
        studentLatenciesInfo.setUpdateTime(new Date());
        studentLatenciesInfo.setCreateTime(new Date());

        if(studentLatenciesInfoMapper.insert(studentLatenciesInfo) == 1){
            return 1;
        }
        return 0;
    }

}
