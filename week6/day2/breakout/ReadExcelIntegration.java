package week6.day2.breakout;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelIntegration {

	public static String[][] readExcel(String fileName) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook("./data/" + fileName + ".xlsx");

		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();

		int columnCount = sheet.getRow(rowCount).getLastCellNum();

		String[][] excelData = new String[rowCount][columnCount];

		for (Row row : sheet) {
			if (row.getRowNum() == 0)
				continue;
			for (Cell cell : row) {
				excelData[cell.getRowIndex() - 1][cell.getColumnIndex()] = cell.getStringCellValue();
			}

		}
		workbook.close();
		return excelData;

	}

}
