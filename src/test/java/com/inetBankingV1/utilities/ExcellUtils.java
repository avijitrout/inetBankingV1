package com.inetBankingV1.utilities;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowcount(String Xlfile,String Xlsheet) throws IOException
	
	{
		fi=new FileInputStream(Xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(Xlsheet);
		return ws.getLastRowNum();
		
	}
	
    public static int getcolCount(String Xlfile,String Xlsheet,int rownum) throws IOException
	
	{
		fi=new FileInputStream(Xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(Xlsheet);
		return ws.getRow(rownum).getLastCellNum();
		
	}
    
    
    public static String getCelldata (String Xlfile,String Xlsheet,int rownum,int colnum) throws IOException
    
    {
    	fi=new FileInputStream(Xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(Xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
		DataFormatter formatter=new DataFormatter();
		String celldata=formatter.formatCellValue(cell);
		return celldata;
		
		}
		catch(Exception e)
		{
			data="";			
		}
		
		wb.close();
		fi.close();
		return data;
    }
    
    
   public static void  setCelldata (String Xlfile,String Xlsheet,int rownum,int colnum,String data) throws IOException
    
    {
    	fi=new FileInputStream(Xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(Xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		cell.setCellValue(data);
		
    }
    
	

}
