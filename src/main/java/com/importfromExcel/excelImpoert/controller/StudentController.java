package com.importfromExcel.excelImpoert.controller;


import com.importfromExcel.excelImpoert.entity.Student;
import com.importfromExcel.excelImpoert.helper.Helper;
import com.importfromExcel.excelImpoert.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @PostMapping("/upload")
    public ResponseEntity<?>upload(@RequestParam("file")MultipartFile file){
        if(Helper.checkExcelFormat(file)){
        this.studentServiceImpl.save(file);
        return ResponseEntity.ok(Map.of("message","File is uploaded and data is saved to db"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel file only");
    }
    @GetMapping("/students")
    public List<Student>getAllStudents(){
    return studentServiceImpl.getAllStudent();
    }
}
