package com.xyz.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelImporter {

	public static void main(String[] args) {
		String filePath = "output.xlsx";
		try(FileInputStream fis = new FileInputStream(new File(filePath));
				Workbook workbook = WorkbookFactory.create(fis)){
			Sheet sheet = workbook.getSheetAt(0);
			for(Row row : sheet) {
				for(Cell cell : row) {
					switch(cell.getCellType()) {
					case STRING : System.out.print(cell.getStringCellValue()+"\t");
								break;
					case NUMERIC : System.out.print(cell.getNumericCellValue()+"\t");
					break;
					case BOOLEAN : System.out.print(cell.getBooleanCellValue()+"\t");
					break;
					case BLANK : System.out.print("[BLANK]\t");
					break;
					default : System.out.print("[UNKNOWN]\t");
					break;
					}
				}
				System.out.println();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
