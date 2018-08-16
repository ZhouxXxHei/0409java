package com.offcn.controller;


import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Buffer;
import com.offcn.po.Mobile;
import com.offcn.service.TelService;



public class uploadExcel {
	
/*增加注释*/
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
				
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		
		TelService service = context.getBean(TelService.class);
		
		try {
			Workbook workbook = WorkbookFactory.create(new File("D:\\char\\Mobile.xls"));
			
			int sheetnum = workbook.getNumberOfSheets();
			
			
			
			for (int i = 0; i < sheetnum; i++) {
				            
				Sheet sheet = workbook.getSheetAt(i);
				
				int rows = sheet.getPhysicalNumberOfRows();
				
				for (int j = 1; j < rows; j++) {
					
					Row row = sheet.getRow(j);
					
					int cells = row.getPhysicalNumberOfCells();
					
					StringBuffer b = new StringBuffer();
					
					for (int k = 0; k < cells; k++) {
						
						Cell cell = row.getCell(k);
						
						if(cell.getCellTypeEnum() == CellType.STRING){
							/*System.out.print(cell.getStringCellValue()+"\t");*/
							b.append(cell.getStringCellValue()+"/");
						}else if(cell.getCellTypeEnum()== CellType.NUMERIC){
							DecimalFormat df = new DecimalFormat("####");
							/*System.out.print(df.format(cell.getNumericCellValue())+"\t");*/
							b.append(df.format(cell.getNumericCellValue())+"/");
							
						}else if(cell.getCellTypeEnum()== CellType.BOOLEAN){
							/*System.out.print(cell.getBooleanCellValue()+"\t");*/
							b.append(cell.getBooleanCellValue()+"/");
						}else if(cell.getCellTypeEnum()==CellType.BLANK){
							/*System.out.println("null"+"\t");*/
							b.append("null"+"/");
							
						}else{
							/*System.out.print(cell.getDateCellValue()+"\t");*/
							b.append(cell.getDateCellValue()+"/");
						}
					}
					
					String str = b.toString();
					String[] rows1 = str.split("/");
					Mobile mobile = new Mobile();
										
					mobile.setMobileNumber(rows1[1]);
					mobile.setMobileArea(rows1[2]);
					mobile.setMobileType(rows1[3]);
					mobile.setAreaCode(rows1[4]);
					mobile.setPostCode(rows1[5]);
					
					
					service.save(mobile);
					System.out.println("");
				}
			}
			workbook.close();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
