package com.nt.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;
import java.sql.Connection;

public class SelectTest6{

	public static void main(String[] args) {

		Connection con = null;
		Statement  st = null;
		ResultSet rs = null;
		
		try{
		
		   
			//Load jdbc driver class
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"system" , "aachal");
			
			//create statement object
			if(con!=null)
				st=con.createStatement();
			
			//prepare sql query
			
			
			
			String query="SELECT EmpNO,ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MAX (SAL) FROM EMP)";
			System.out.println(query); 
			
			//send and execute sql query in db s/w
			if(st!=null)
			   rs=st.executeQuery(query);
			//process   hgh
			if(rs!=null) {
				//boolean flag=false;
				while(rs.next()) {
					//flag=true;
					 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				}//while
			}//if
		}//try	      
		catch(SQLException se){
            System.out.println(se.toString());		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//finally
		finally {
			//close jdbc object and stream object 
			     try {
				         if(rs!=null)
					            rs.close();         //rs
		           }//try
			       catch(SQLException se) {
				           se.printStackTrace();
			        }
			
			    try {
				 if(st!=null)
					  st.close();                //st
		          }//try
			     catch(SQLException se) {
				   se.printStackTrace();
			     }
			      
			
			try {
				if(con!=null)
					con.close();               //con
		     }//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			
			
		
		}//finally
		
	 }//main
}//class





