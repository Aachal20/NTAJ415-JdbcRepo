package com.nt.basics;


import java.sql.DriverManager;
import java.text.SimpleDateFormat;

public class DateValuesConversion {

	public static void main(String[] args) throws Exception {
		
		//Converting string date values to java.util.Date class obj
		String s1 ="20-8-1999";  //dd-mm-yyyy
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date ud1 =sdf.parse(s1);
		
		System.out.println("String date values:: " +s1);
		System.out.println("util date:: " +ud1);
		System.out.println();
		
		
		// Converting java.util.Date class obj to java.sql.Date class obj 
		long ms = ud1.getTime();
		java.sql.Date sd1 =  new java.sql.Date(ms);
	   
		System.out.println("util date:: " +ud1);
		 System.out.println("sql date:: " +sd1);
		 
		 //Converting java.util.Date class obj to java.sql.Date class obj
			String s2  ="1999-08-20";  //yyyy-MM-dd
			//SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");
			java.sql.Date sd2 =java.sql.Date.valueOf(s2);
			
			System.out.println("String date values:: " +s2);
			System.out.println("sql date:: " +sd2);
		 
		 
		 
			}

}
