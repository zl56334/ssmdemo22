package com.example.ssmdemo22.demos.form;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddStudentLatenciesInfoForm {

    @NotNull
    @Pattern(regexp = "[0-9]{1,10}")
    private String studentNo;

    @NotNull
    @Pattern(regexp = "[\\u4e00-\\u9fa5]")
    private String studentName;

    private Integer numberLatencies;
}
