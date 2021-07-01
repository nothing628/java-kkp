/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class ReportHelper {

    String[] headers;

    ArrayList<ArrayList<Object>> rows;

    public ReportHelper() {
        headers = new String[]{};
        rows = new ArrayList<>();
    }

    public void setHeader(String[] headers) {
        this.headers = headers;
    }

    public void addRow(ArrayList<Object> row) {
        this.rows.add(row);
    }

    private void writeContent(Sheet sh) {
        var row_start = 2;
        for (int row_counter = 0; row_counter < rows.size(); row_counter++) {
            var row = rows.get(row_counter);
            var row_num = row_start + row_counter;
            Row row_sh = sh.createRow(row_num);

            for (int cell_counter = 0; cell_counter < row.size(); cell_counter++) {
                Cell cell = row_sh.createCell(cell_counter);
                Object cell_value = row.get(cell_counter);
                
                if (cell_value == null) {
                    continue;
                }
                
                if (cell_value.getClass() == Integer.class) {
                    cell.setCellValue((int)cell_value);
                }

                if (cell_value.getClass() == String.class) {
                    cell.setCellValue((String)cell_value);
                }
            }
        }
    }

    private void writeHeader(Sheet sh) {
        // Create at row index number 1
        Row row_sh = sh.createRow(1);
        for (int header_counter = 0; header_counter < headers.length; header_counter++) {
            Cell cell = row_sh.createCell(header_counter);

            cell.setCellValue(headers[header_counter]);
        }
    }

    public void save(File file) throws FileNotFoundException, IOException {
        // create a new SXSSFWorkbook
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sh = wb.createSheet();

        writeHeader(sh);
        writeContent(sh);

        try (FileOutputStream out = new FileOutputStream(file)) {
            wb.write(out);
        }
    }

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
