package com.example.ssmdemo22.demos.controller;

import com.example.ssmdemo22.demos.entity.SysDepartment;
import com.example.ssmdemo22.demos.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysDepartmentsController {

    @Autowired
    private SysDepartmentService sysDepartmentService;

    @RequestMapping("/getRandomName")
    @ResponseBody
    public String getRandomName(@RequestParam("randomNUM") Integer randomNUM) {
        return sysDepartmentService.getRandomName(randomNUM);
    }

    @GetMapping("/listAllStudentsPage")
    public String listAllStudentsPage(Model model) {
        List<SysDepartment> sysDepartmentList = sysDepartmentService.findAll();
        model.addAttribute("msg", "hello world");
        model.addAttribute("sysDepartmentList", sysDepartmentList);
        return "listAllStudentsPage";
    }
}
