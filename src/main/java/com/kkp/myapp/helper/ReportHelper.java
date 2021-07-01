/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class ReportHelper {

    public void test() {
        try {
            // create a new SXSSFWorkbook
            SXSSFWorkbook wb = new SXSSFWorkbook(100);
            Sheet sh = wb.createSheet();

            for (int rownum = 0; rownum < 2000; rownum++) {
                Row row = sh.createRow(rownum);
                // insert data in 20000 cells
                for (int cellnum = 0; cellnum < 10; cellnum++) {
                    Cell cell = row.createCell(cellnum);
                    cell.setCellValue("Row Number: " + rownum + " Cell Number: " + cellnum);
                }
            }
            try (FileOutputStream out = new FileOutputStream("LargeDcument.xlsx")) {
                wb.write(out);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
