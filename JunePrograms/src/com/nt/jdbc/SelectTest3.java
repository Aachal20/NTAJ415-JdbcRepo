package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest3 {

	public static void main(String[] args) {
		System.out.println(" SelectTest3 .main");
		Scanner sc=null;
		Connection con = null;
		Statement st=null;
		ResultSet rs = null;
		try {
			//Take input values
			sc = new Scanner(System.in);
			String initchars = null;
			
			if(sc!=null) {
				System.out.println("Enter Intial Charters of Employee Name::");
				initchars= sc .next();
			}
			
			//Convert input values as required for sql query
			initchars = " ' "+initchars+"%' ";
			
			//Register driver by loading jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
	    	con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" , "aachal");
		
			//create statement object
	    	if(con!=null)
	    		st = con.createStatement();
	    	
	    	//prepare sql query
	    	String query= "SELECT EMPNO, ENAME , JOB,  SAL FROM EMP WHERE ENAME LIKE " +initchars;
		    System.out.println(query);
		    
		    //send and excute the sql query to Db s/w
		      if(st!=null)
		    	rs=st.executeQuery(query);
		    
		    //processs the ResultSet object
		    boolean flag=false;
		    while(rs.next()) {
		    	flag=true;
		    	System.out.println(rs.getInt(1)+" " +rs.getString(2)+"  "+rs.getString(3)+" "+rs.getFloat(4));
		    }//while
		    
		    if(flag==false) 
		    	System.out.println("No Record Found::");
		    	
		//if
       }//try
       catch(SQLException se) {
    	se.printStackTrace();
      }catch(Exception e) {
    	e.printStackTrace();
      }

		finally {
			//close the jdbc object
			try {
				  if(rs!=null) {
					rs.close();
				  }
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			//st close
			try {
				  if(st!=null) {
					st.close();
				  }
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
				
			
			try {
				  if(con!=null) {
					con.close();
				  }
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				  if(sc!=null) {
					sc.close();
				  }
			}
			catch(Exception e) {
			      e.printStackTrace();
			}
		}//finally
			
	}//main
}//class
	


