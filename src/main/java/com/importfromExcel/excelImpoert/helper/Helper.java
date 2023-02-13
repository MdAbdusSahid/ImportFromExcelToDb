package com.importfromExcel.excelImpoert.helper;


import com.importfromExcel.excelImpoert.entity.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    public static boolean checkExcelFormat(MultipartFile file){
        String contentType= file.getContentType();
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return  false;
        }
    }
    public static List<Student> convertExcelToListOfEmployee(InputStream is){
        List<Student> list=new ArrayList<>();
        try {
            XSSFWorkbook wb=new XSSFWorkbook(is);
            XSSFSheet sheet = wb.getSheet("Student Info");
            int rowNumber=0;
            Iterator<Row> iterator = sheet.iterator();
            while(iterator.hasNext()){
                Row row= iterator.next();
                if (rowNumber==0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid=0;
                Student e=new Student();
                while (cells.hasNext()){
                    Cell cell = cells.next();
                    switch (cid){
                        case 0:{
                            e.setStudent_id(cell.getNumericCellValue());
                            break;
                        }
                        case 1:{
                            e.setAbout(cell.getStringCellValue());
                            break;
                        }
                        case 2: {
                            e.setStudent_name(cell.getStringCellValue());
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    cid++;
                    list.add(e);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
