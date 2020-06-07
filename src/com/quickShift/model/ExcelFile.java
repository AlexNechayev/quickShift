package com.quickShift.model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelFile {

    private String fileName;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    static int rowCount = 1;
    private Cell cell;
    private Row row;

    public ExcelFile(String fileName){
        this.fileName = fileName;
    }

    public void generateFile() throws IOException {

        File file = new File("./"+fileName+".xlsx");

        if(!(file.exists())){

            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(fileName);

            row = sheet.createRow(0);
            int columnCount = 1;

            cell =row.createCell(columnCount++);
            cell.setCellValue("Start Hour");
            cell =row.createCell(columnCount++);
            cell.setCellValue("End Hour");
            cell =row.createCell(columnCount);
            cell.setCellValue("Full Name");

            try (FileOutputStream outputStream = new FileOutputStream(fileName+".xlsx")) {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

            FileInputStream fip = new FileInputStream(file);
            workbook = new XSSFWorkbook(fip);

            if (file.isFile() && file.exists()) {

                sheet = workbook.getSheet("Employee");
                Iterator<Row> rows = sheet.rowIterator();

                while(rows.hasNext()){
                    rowCount++;
                    rows.next();
                }
                rowCount--;

            }
            else {
                System.out.println("file either not exist or can't open");
            }
        }
    }

    public void updateFile(String firstName,String lastName,String fullName){

        row = sheet.createRow(rowCount++);
        int columnCount = 1;

        cell =row.createCell(columnCount++);
        cell.setCellValue(firstName);
        cell =row.createCell(columnCount++);
        cell.setCellValue(lastName);
        cell =row.createCell(columnCount);
        cell.setCellValue(fullName);

        try (FileOutputStream outputStream = new FileOutputStream(fileName+".xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

