package com.kkp.myapp.helper;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ExcelFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {
        return true;
    }

    @Override
    public String getDescription() {
        return "Excel file only";
    }
    
}
