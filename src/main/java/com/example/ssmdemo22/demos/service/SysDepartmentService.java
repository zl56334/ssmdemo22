package com.example.ssmdemo22.demos.service;

import com.example.ssmdemo22.demos.entity.SysDepartment;

import java.util.List;

public interface SysDepartmentService {

    public List<SysDepartment> findAll();
    public SysDepartment findById(int id);
    public List<SysDepartment> findByParentId(int parent_id);
    public List<SysDepartment> findByName(String name);
    public Integer save(SysDepartment sysDepartment);
    public Integer deleteById(int id);

    String getRandomName(Integer randomNUM);
}
