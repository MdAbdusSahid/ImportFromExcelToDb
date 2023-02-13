package com.importfromExcel.excelImpoert.repository;
import com.importfromExcel.excelImpoert.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface StudentRepository extends JpaRepository<Student, Serializable> {

}
