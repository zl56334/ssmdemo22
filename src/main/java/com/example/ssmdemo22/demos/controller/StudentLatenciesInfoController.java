package com.example.ssmdemo22.demos.controller;

import com.example.ssmdemo22.demos.form.AddStudentLatenciesInfoForm;
import com.example.ssmdemo22.demos.service.StudentLatenciesInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/studentLatenciesInfo")
public class StudentLatenciesInfoController {

    @Autowired
    private StudentLatenciesInfoService studentLatenciesInfoService;

    @RequestMapping("/index")
    public String getStudentLatenciesInfo(Model model) {
        model.addAttribute("studentLatenciesInfoList", studentLatenciesInfoService.getStudentLatenciesInfo());
        return "studentLatenciesInfo/index";
    }

    @PostMapping("/addStudentLatenciesInfo")
    @ResponseBody
    public String addStudentLatenciesInfo(@Valid AddStudentLatenciesInfoForm addStudentLatenciesInfoForm){
        Integer reInt = studentLatenciesInfoService.addStudentLatenciesInfo(addStudentLatenciesInfoForm);
        if(reInt == 1){
            return "success";
        }
        return "error";
    }

    @PostMapping("/updateStudentLatenciesInfo")
    @ResponseBody
    public String updateStudentLatenciesInfo(@RequestParam("id") Integer id, @RequestParam("numberLatencies") Integer numberLatencies){
        if (id == null || numberLatencies == null){
            return "error";
        }
        if (Integer.valueOf(numberLatencies) < 0){
            return "error";
        }
        Integer reInt = studentLatenciesInfoService.updateStudentLatenciesInfo(id, numberLatencies);
        if(reInt == 1){
            return "success";
        }
        return "error";
    }

    @PostMapping("/deleteStudentLatenciesInfo")
    @ResponseBody
    public String deleteStudentLatenciesInfo(@RequestParam("id") Integer id){
        Integer reInt = studentLatenciesInfoService.deleteStudentLatenciesInfo(id);
        if(reInt == 1){
            return "success";
        }
        return "error";
    }

}
