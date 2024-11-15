package com.example.ssmdemo22.demos.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;


/**
 * className:StudentLatenciesInfo
 * description:56334@163.com
 * createTime:2024/11/07 19:03
 */
@Data
@TableName("student_latencies_info")
public class StudentLatenciesInfo {

    @TableId(type = AUTO)
    private Integer id;
    private String studentNo;
    private String studentName;
    private Integer classId;
    private Integer numberLatencies;
    private Date createTime;
    private Date updateTime;

    @TableLogic
    private Integer isDeleted;

}
