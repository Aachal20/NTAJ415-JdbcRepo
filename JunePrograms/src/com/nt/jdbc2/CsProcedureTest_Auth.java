package com.nt.jdbc2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsProcedureTest_Auth {
      private  static final String  CALL_PROCEDURE_QUERY =  "{CALL P_AUTHENTIC(?,?,?)}";
 	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			String username=null;
			String password = null;
			if(sc!=null) {
				System.out.println("Enter username");
				username = sc.next();
				System.out.println("EnterPASSWORD");
				password = sc.next();
			}
			//establish thre connection
			try(Connection  con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system" , "aachal");
					//create CallableStatment obj having query to call a pl/sql procedure as precompiled sql query   
					CallableStatement cs = con.prepareCall(CALL_PROCEDURE_QUERY);)	
			{
				if(cs!=null)
					cs.registerOutParameter(3,Types.VARCHAR);
			    //	cs.registerOutParameter(3,Types.VARCHAR);
				//set values to in param
				if(cs!=null)
				{
					cs.setString(1,username);
					cs.setString(2,password);
							
				}
				//call pl/sql procedure
				if(cs!=null)
					cs.execute();
				//get result from out paramater
			    String  result = null;
				if(cs!=null)
					result = cs.getString(3);
				  System.out.println(result);
			}//try
		}//try 	
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}//MAIN

}//CLASS
