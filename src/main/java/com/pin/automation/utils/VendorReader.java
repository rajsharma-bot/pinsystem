package com.pin.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VendorReader {

    public static List<String> getVendorsForEnv(String env) {
        List<String> vendors = new ArrayList<>();
        String excelPath = "src/main/resources/vendor-data.xlsx";

        try (FileInputStream fis = new FileInputStream(new File(excelPath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(env.toLowerCase());
            if (sheet == null) throw new IllegalArgumentException("No sheet found for env: " + env);

            for (int i = 1; i <= 7; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(1);
                    if (cell != null) {
                        vendors.add(cell.getStringCellValue());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendors;
    }
}
