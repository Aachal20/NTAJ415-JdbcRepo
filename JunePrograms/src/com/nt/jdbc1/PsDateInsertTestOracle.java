package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class PsDateInsertTestOracle {
     private static final String INSERT_DATE_QUERY = "INSERT INTO PERSON_INFO_DATES VALUES (PID_SEQ.NEXTVAL)values(?,?,?,?)";
	 public static void main(String[] args) {                        
		Scanner sc= null;
		Connection con = null;
		PreparedStatement ps=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String name=null ,sdob=null,sdoj=null,sdom=null;
		
			if(sc!=null) {
				System.out.println("Enter person Name::");
				name=sc.next();
				System.out.println("Enter DOB(dd-MM-yyyy)::");
				sdob=sc.next();
				System.out.println("Enter DOJ(yyyy-MM-dd::");
				sdoj=sc.next();
				System.out.println("Enter DOM(MMM-dd-yyyy::");
				sdom=sc.next();
			}
			
			//For DOB                      [string-->util--->sql]
			//Converting string date values to java.util.Date class obj
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date udob = sdf1.parse(sdob) ;
			
		   //Converting java.util.Date class obj to java.sql.Date class obj
			long ms=udob.getTime();
	     	java.sql.Date sqdob =new java.sql.Date(ms);
	     	
	     	
			//For DOJ(Direct conversion )  yyyy-MM-dd           [string----->sql]
	     	//Converting string date values to java.sql.Date class obj
	            java.sql.Date sqdoj =  java.sql.Date.valueOf(sdoj);
	     	
	     
			
			//For5 DOM  MMM-dd-yyyy
	     	//Converting string date values to java.util.Date class obj     [string---------->util]
	     	SimpleDateFormat sdf2 = new SimpleDateFormat("MMM-dd-yyyy");
			java.util.Date udom= sdf2.parse(sdom) ;
			
			//Converting java.util.Date class obj to  java.sql.Date class obj
			
	     	ms=udom.getTime();
	     	java.sql.Date sqdom= new  java.sql.Date(ms);
	     			
	     	
	     //Load jdbc Driver class
		//	Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system","manager");
			
			//create PreparedStatement obj having precompiled sql query
			if(con!=null)
		   ps=con.prepareStatement("INSERT_DATE_QUERY");
			
			//SET VALUES TO PARAM
			if(ps!=null) {
				ps.setString(2, name);
			    ps.setDate(3, sqdob);
			    ps.setDate(4, sqdoj);
			    ps.setDate(5, sqdom);
			
			}
			
			int count=0;
			if(ps!=null)
			count=ps.executeUpdate();
			if(count==0)
				System.out.println("Recort is Not Inserted");
			else
				System.out.println("Record is Inserted");
			
			
		}//try
		
		 catch(SQLException se) {
		    	se.printStackTrace();
		    }
	    catch(Exception e) {
		    	e.printStackTrace();
		    }
	  finally {
		    	//close jdbc object
		    	try {
		    		if(ps!=null)
		    			ps.close();
		    	}
		    	catch(SQLException se) {
		    		se.printStackTrace();
		    	}
		    	
		    	try {
		    		if(con!=null)
		    			con.close();
		    	}
		    	catch(SQLException se) {
		    		se.printStackTrace();
		    	}
		    	
		    	try {
		    		if(sc!=null)
		    			sc.close();
		    	}
		    	catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    }//finally
	    
		
	}//main

}//class
