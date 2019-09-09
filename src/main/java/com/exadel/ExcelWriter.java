package com.exadel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import static com.exadel.MainClass.log;

class ExcelWriter {

    private XSSFWorkbook workbook;

    public ExcelWriter(){
        workbook = new XSSFWorkbook();
    }

    public void writeMapToExcel(Map<String, Double> map, String filePath) {
        FileOutputStream fos = getOutputStream(filePath);
        XSSFSheet sheet = workbook.createSheet("Test tab");
        setTableHeader(sheet);
        Iterator it = map.entrySet().iterator();
        int rowNum = 1;

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Row row = sheet.createRow(rowNum++);
            setRow(pair, row);
        }
        try {
            workbook.write(fos);
        } catch (IOException e) {
            log.error("Can not write to excel. Message : " + e.getMessage());
        }
        log.info("Excel recorded.");
    }

    private void setRow(Map.Entry pair, Row row){
        Cell aCell = row.createCell(0);
        aCell.setCellValue(pair.getKey().toString());
        Cell bCell = row.createCell(1);
        bCell.setCellValue(Double.parseDouble(pair.getValue().toString()));
        bCell.setCellStyle(getAlignmentStyle(HorizontalAlignment.LEFT));
    }

    private FileOutputStream getOutputStream(String filePath) {
        File file = new File(filePath);
        if (file.exists())
            file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            log.error("Error when create new file.");
        }

        try {
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            log.error("Can not create output stream.");
            return null;
        }
    }

    private void setTableHeader(XSSFSheet sheet){
        Row row = sheet.createRow(0);

        Cell aCell = row.createCell(0);
        aCell.setCellValue("Chanel Name");
        aCell.setCellStyle(getAlignmentStyle(HorizontalAlignment.CENTER));

        Cell bCell = row.createCell(1);
        bCell.setCellValue("Reach percentage");
        bCell.setCellStyle(getAlignmentStyle(HorizontalAlignment.LEFT));

        sheet.setColumnWidth(0, 8000);
        sheet.setColumnWidth(1, 5000);
    }

    private XSSFCellStyle getAlignmentStyle(HorizontalAlignment alignment){
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(alignment);
        return cellStyle;
    }
}
