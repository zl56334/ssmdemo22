package com.example.ssmdemo22.demos.service;

import com.example.ssmdemo22.demos.entity.StudentLatenciesInfo;
import com.example.ssmdemo22.demos.form.AddStudentLatenciesInfoForm;

import java.util.List;


public interface StudentLatenciesInfoService {
    List<StudentLatenciesInfo> getStudentLatenciesInfo();

    Integer deleteStudentLatenciesInfo(Integer id);

    Integer updateStudentLatenciesInfo(Integer id, Integer latencies);

    Integer addStudentLatenciesInfo(AddStudentLatenciesInfoForm addStudentLatenciesInfoForm);
}
