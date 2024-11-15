package com.example.ssmdemo22.demos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_department")
public class SysDepartment {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String departmentName;
    private Integer parentId;
    private Integer deleteFlag;

}
