package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTest {
	private static final String STUDENT_INSERT_QUERY="INSERT INTO IRCTC_AACHAL VALUES(? ,? ,? ,?)";

	public static void main(String[] args) {
		
		Scanner sc =null;
		Connection con=null;
		PreparedStatement ps =null;
		try {
			//read  inputs
			sc = new Scanner(System.in);
			int count=0;
			if(sc!=null)
				System.out.println("Enter student counts");
			   count=sc.nextInt();
			
			//Load jdbc Driver class
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system" , "manager");
			//create PreparedStatement obj having precompiled sql query
			if(con!=null)
		     ps= con.prepareStatement(STUDENT_INSERT_QUERY);
			
			//read input values from enduser , set them to query param values and execute the precompiled 
			//query for multiple times
			
			if(ps!=null&&sc!=null) {
				for(int i =0;i<count;++i) {
					//read each input student values
					System.out.println(" Enter  +i+ Student Details ::");
				
					System.out.println(" Enter  Student EMAIL ::");
					 String  email=sc.next();
					System.out.println(" Enter  password::");
					String pass =sc.next();
					System.out.println(" Enter  Student dob :: ");
					String dob =sc.next();
					System.out.println(" Enter   Student address ::");
					String  addr=sc.next();
					
					//set each student details as pre-compiled sql qquery
					ps.setString(1, email);
					ps.setString(2, pass);
				    ps.setString(3, dob);
				    ps.setString(4, addr);
				    
				    //execute precompiled sql query each
				    int result= ps.executeUpdate();
				    
				    //process the resul 
				    if(result==0)
				    	System.out.println("student details not inserted");
				    else
				    	System.out.println("student details are inserted");
					
					}//for
			}//try
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			//close jdbc obj
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
}//close
	
			
		
		

	


