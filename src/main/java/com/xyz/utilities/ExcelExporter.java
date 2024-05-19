package com.xyz.utilities;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExporter {

	public static void main(String[] args) {
		Object[][] data = {
				{"Name","Age","City"},
				{"Ram",30, "DDN"},
				{"Sita",45, "MZP"}
		};
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet();
			int rowNum = 0;
			for(Object[] rowData: data) {
				Row row = sheet.createRow(rowNum++);
				int colNum = 0;
				for(Object field: rowData) {
					Cell cell = row.createCell(colNum++);
					if(field instanceof String) {
						cell.setCellValue((String)field);
					}else if(field instanceof Integer) {
						cell.setCellValue((Integer)field);
					}
				}
			}
			try(FileOutputStream opStream = new FileOutputStream("output.xlsx") ) {
				workbook.write(opStream);
				System.out.println("Excel file exported successfully!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
