package com.nt.jdbc;
//26 th may

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SelectTestUsingWhereClause {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
	    Statement st=null;
	    ResultSet rs=null;
	    
	    try {
	    	//Take Inputs
	    	sc= new Scanner(System.in);
	    	int dno=0;
	    	if(sc!=null) {
	    	System.out.println("Enter dept number");
	    	dno = sc.nextInt();
	    }
	     
	    //Register driver by loading jdbc driver class
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
	    	con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" , "manager");
		
			//create statement object
	    if(con!=null)
	    	st=con.createStatement();
	    	
	    	//prepare sql query
	    	String query= "SELECT DEPTNO,DNAME,LOC  FROM DEPT WHERE DEPTNO= " +dno;
		    System.out.println(query);
		    
		    //send and execute the query
		    if(st!=null) 
		    	rs=st.executeQuery(query);
		    
		    //process the resultset
		
		    if(rs!=null) {
		    	if(rs.next())
		    		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		    	else
		    		System.out.println("Record Not Found");
		    		
	    }//if
		    
	}//try
	catch(SQLException se) {
		se.printStackTrace();
		System.out.println("which");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(rs!=null)
				rs.close();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		
		try {
			if(st!=null)
				st.close();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		
		try {
			if(sc!=null)
				sc.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//finalyy
		
	}//main
}//class
	    
		
	



