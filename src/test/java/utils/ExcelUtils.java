package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    /**
     * Sets the Excel file and sheet for reading.
     *
     * @param excelPath Path to the Excel file.
     * @param sheetName Name of the sheet to read.
     * @throws Exception if there is an issue with file handling or sheet retrieval.
     */
    public static void setExcelFile(String excelPath, String sheetName) throws Exception {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(excelPath));
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: ", e);
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    throw new RuntimeException("Error closing Excel file stream: ", e);
                }
            }
        }
    }

    /**
     * Retrieves data from the currently set sheet.
     *
     * @return A 2D array of data from the sheet.
     * @throws RuntimeException if the sheet is not set or an error occurs during data retrieval.
     */
    public static Object[][] getData() {
        if (sheet == null) {
            throw new RuntimeException("Sheet is null. Ensure that setExcelFile() was called.");
        }

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    String cellValue = (cell != null) ? cell.toString().trim() : "";
                    data[i - 1][j] = cellValue;
                }
            }
        }
        return data;
    }
}
