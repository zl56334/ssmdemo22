package com.example.ssmdemo22.demos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ssmdemo22.demos.entity.StudentLatenciesInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentLatenciesInfoMapper extends BaseMapper<StudentLatenciesInfo> {

    @Insert("insert into student_latencies_info (student_id,latencies,latencies_time) values (#{studentId},#{latencies},#{latenciesTime})")
    public int insertStudentLatenciesInfo(StudentLatenciesInfo studentLatenciesInfo);

    public List<StudentLatenciesInfo> getStudentLatenciesInfoByStudentLatenciesInfo(StudentLatenciesInfo studentLatenciesInfo);
}
