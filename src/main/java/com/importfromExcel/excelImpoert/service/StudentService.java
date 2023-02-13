package com.importfromExcel.excelImpoert.service;


import com.importfromExcel.excelImpoert.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    public void save(MultipartFile file);
    public List<Student> getAllStudent();
}
