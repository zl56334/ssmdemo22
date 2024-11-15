package com.example.ssmdemo22.demos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ssmdemo22.demos.entity.SysDepartment;
import com.example.ssmdemo22.demos.mapper.SysDepartmentMapper;
import com.example.ssmdemo22.demos.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Override
    public List<SysDepartment> findAll() {
//        //创建list对象
//        List<SysDepartment> sysDepartments = new ArrayList<SysDepartment>();
//        //创建查询条件对象 “where ”
//        QueryWrapper<SysDepartment> queryWrapper = new QueryWrapper<SysDepartment>();
//        //设置查询条件 “where 0 = 0”
//        queryWrapper.eq("0","0");
//        //赋值查询结果 “select * from sysDepartments where 0 = 0”
//        sysDepartments = sysDepartmentMapper.selectList(queryWrapper);
//        return sysDepartments;

        return sysDepartmentMapper.selectList(
                new QueryWrapper<SysDepartment>().eq("0","0")
        );
    }

    @Override
    public SysDepartment findById(int id) {
        return sysDepartmentMapper.selectById(id);
    }

    @Override
    public List<SysDepartment> findByParentId(int parent_id) {
        return sysDepartmentMapper.selectList(
                new QueryWrapper<SysDepartment>().eq("parent_id", parent_id)
        );
    }

    @Override
    public List<SysDepartment> findByName(String name) {
        return sysDepartmentMapper.selectList(
                new QueryWrapper<SysDepartment>().like("name", "%"+name+"%")
        );
    }

    @Override
    public Integer save(SysDepartment sysDepartment) {
//        if(sysDepartment.getId() == 0){
//            return sysDepartmentMapper.insert(sysDepartment);
//        } else {
//            Integer inputId = sysDepartment.getId();
//            Long reSysDepartmentCount = sysDepartmentMapper.selectCount(new QueryWrapper<SysDepartment>().eq("id", inputId));
//
//            if(reSysDepartmentCount == 0){
//                return 0;
//            } else {
//                return sysDepartmentMapper.updateById(sysDepartment);
//            }
//        }
        return sysDepartmentMapper.insertOrUpdate(sysDepartment)? 1 : 0;
    }

    @Override
    public Integer deleteById(int id) {
        SysDepartment sysDepartment = sysDepartmentMapper.selectById(id);
        sysDepartment.setDeleteFlag(1);
        return sysDepartmentMapper.updateById(sysDepartment);
    }

    @Override
    public String getRandomName(Integer randomNUM) {
        List<SysDepartment> reSysDepartmentList = sysDepartmentMapper.selectList(new QueryWrapper<SysDepartment>().eq("0", "0"));
        String result = "";
        for (int i = 0; i < randomNUM; i++) {
            Random random = new Random();
            int randomNum = random.nextInt(reSysDepartmentList.size());
            SysDepartment sysDepartment = reSysDepartmentList.get(randomNum);
            if (sysDepartment.getDeleteFlag() == 0){
                sysDepartment.setDeleteFlag(1);
                sysDepartmentMapper.updateById(sysDepartment);
                result = result + sysDepartment.getDepartmentName() + " ";
            } else {
                i--;
            }
        }
        SysDepartment updateSysDepartment = new SysDepartment();
        updateSysDepartment.setDeleteFlag(0);
        sysDepartmentMapper.update(updateSysDepartment, new QueryWrapper<SysDepartment>().eq("delete_flag", "1"));
        return result;
    }
}
