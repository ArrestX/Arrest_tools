package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class ExcelColumnCrawler {
    public static void main(String[] args) {
        String inputFilePath = "/Users/arrest_document/Documents/Hero404not_tools/spiderExcelcolum/file/files.xlsx";
        String outputFilePath = "/Users/arrest_document/Documents/Hero404not_tools/spiderExcelcolum/file/output.csv";

        try {
            FileInputStream fis = new FileInputStream(inputFilePath);
            Workbook workbook = new XSSFWorkbook(fis);

            System.out.println("Available Sheets:");
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                System.out.println(i + ": " + workbook.getSheetAt(i).getSheetName());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the index of the sheet you want to extract (0-" + (workbook.getNumberOfSheets() - 1) + "): ");
            int selectedSheetIndex = scanner.nextInt();

            if (selectedSheetIndex < 0 || selectedSheetIndex >= workbook.getNumberOfSheets()) {
                System.out.println("Invalid sheet index.");
                return;
            }

            Sheet sheet = workbook.getSheetAt(selectedSheetIndex);
            Iterator<Row> rowIterator = sheet.iterator();

            // Print column names
            Row headerRow = rowIterator.next();
            Iterator<Cell> headerCellIterator = headerRow.cellIterator();
            System.out.println("Available Columns:");
            while (headerCellIterator.hasNext()) {
                Cell headerCell = headerCellIterator.next();
                System.out.println(headerCell.getColumnIndex() + ": " + headerCell.getStringCellValue());
            }

            System.out.print("Enter the index of the column you want to extract (0-" + (headerRow.getLastCellNum() - 1) + "): ");
            int selectedColumnIndex = scanner.nextInt();

            if (selectedColumnIndex < 0 || selectedColumnIndex >= headerRow.getLastCellNum()) {
                System.out.println("Invalid column index.");
                return;
            }

            FileWriter csvWriter = new FileWriter(outputFilePath);
            csvWriter.append("SheetName,");
            csvWriter.append(headerRow.getCell(selectedColumnIndex).getStringCellValue());
            csvWriter.append("\n");

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell cell = row.getCell(selectedColumnIndex);
                if (cell != null) {
                    String cellValue = cell.toString();
                    csvWriter.append(sheet.getSheetName() + ",");
                    csvWriter.append(cellValue);
                    csvWriter.append("\n");
                }
            }

            csvWriter.flush();
            csvWriter.close();
            fis.close();
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
