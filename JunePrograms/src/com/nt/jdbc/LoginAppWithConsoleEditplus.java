package com.nt.jdbc;
import java.sql.Statement;
import java.util.*;
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//console login application with editplus
	public class LoginAppWithConsoleEditplus {
		
		public static void main(String[] args) {
			
			Scanner sc =null;
			Connection con=null;
			Statement st = null;
			ResultSet rs = null;
			String user=null,pass=null;
			try {
				    Console cons = System.console();
					
					System.out.println("enter login name");
	                 user= cons.readLine();   //gives raja rao


			      	System.out.println("enter login name");
					pass=new String(cons.readPassword());
				 
				 
					
				//convert input values as required for sql query
				user="'"+user+"'";  
				pass="'"+pass+"'";    
				
				//Load jdbc driver class
			     Class.forName("oracle.jdbc.driver.OracleDriver");
	             //establishb the connection
			     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system","aachal");
			     
			     
				//Create statement object
			     st=con.createStatement();
			     
			     //prepare sql query
			     //select count(*) from IRCTC_TAB where uname=raja and pwd=rani
			     //String query="SELECT COUNT(*) FROM IRCTC_TAB WHERE UNAME="+user+ "AND PWD ="+pass;
			     String query="select count(*) from IRCTC_TAB where uname="+user+"and  pwd="+pass;
			     System.out.println(query);
			     
			     //send and execute sql query to db s/w
			     if(st!=null)
			       rs = st.executeQuery(query);
			     
			     //process the resultset object
			     
			     if(rs!=null)
			    	 rs.next();
			     int count=rs.getInt(1);
			     
			     //process the result
			     
			     if(count==0)
			    	 System.out.println("INVALID CREDENTIALS");
			     else
			    	 System.out.println("VALID CREDENTIALS");
			    	 
			     
		
			}//try
			
		   catch(SQLException se){
			     se.printStackTrace();
	     	}
	     	catch(Exception e) {
			     e.printStackTrace();
		    }
			
			finally{
				
			   try {
				if(rs!=null)
					rs.close();
				 
			   }
			   catch(SQLException se) {
				se.printStackTrace();
			   }
			
			try {
				if(st!=null)
					st.close();
				 
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
		}//class
	}	

			
			


