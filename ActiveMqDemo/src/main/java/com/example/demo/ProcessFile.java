package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProcessFile {

	public void processFile() {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		File excelFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\record.xlsx");
		try {
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = null;
			try {
				workbook = new XSSFWorkbook(fis);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// we get first sheet
			XSSFSheet sheet = workbook.getSheetAt(0);

			// we iterate on rows
			Iterator<Row> rowIt = sheet.iterator();
			List<FileMapper> fmList = new ArrayList<>();

			while (rowIt.hasNext()) {
				Row row = rowIt.next();
				System.out.println("Sending row value:" + row.getCell(1));
				if (row.getRowNum() > 1)
					fmList.add(fileMapperProcess(row));
				// iterate on cells for the current row
			}

			System.out.println("List size:" + fmList.size());

			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public FileMapper fileMapperProcess(Row row) {
		FileMapper fm = new FileMapper();
		System.out.println("Val:->" + row.getCell(1).toString());
		fm.setFirstName(row.getCell(1).toString());
		return fm;
	}

}
