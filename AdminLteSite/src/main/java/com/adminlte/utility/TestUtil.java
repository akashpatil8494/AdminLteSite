package com.adminlte.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

	public static long page_load_timeout = 40;
	public static long implicit_wait = 30;

	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {

		FileInputStream fis = null;

		try {
			fis = new FileInputStream("D:\\JavaProgramming\\AdminLteSite\\src\\main\\java\\com\\adminlte\\TestData\\adminlte Data provider sheet.xlsx");

			book = WorkbookFactory.create(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		int row = sheet.getLastRowNum();

		int col = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[row][col];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}

		}

		return data;
	}

}
