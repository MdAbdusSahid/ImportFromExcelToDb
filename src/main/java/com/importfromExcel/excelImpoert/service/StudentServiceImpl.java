package com.importfromExcel.excelImpoert.service;



import com.importfromExcel.excelImpoert.entity.Student;
import com.importfromExcel.excelImpoert.helper.Helper;
import com.importfromExcel.excelImpoert.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentrepo;

    public void save(MultipartFile file){
        try {
            List<Student> students = Helper.convertExcelToListOfEmployee(file.getInputStream());
            this.studentrepo.saveAll(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Student> getAllStudent(){
        logger.info("GetAll Student method Invoked");
        return this.studentrepo.findAll();
    }
}
