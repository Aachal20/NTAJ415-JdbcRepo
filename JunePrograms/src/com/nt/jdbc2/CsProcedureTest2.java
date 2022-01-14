package com.nt.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import java.sql.CallableStatement;

public class CsProcedureTest2 {
 private static final String CALL_PROCEDURE="{ (CALL  P_GET_EMP_DETAILS_BY_ID(?,?,?,?))}";
 
	public static void main(String[] args) {
	//Read Inputs	
	int eno = 0;
	try(Scanner sc = new Scanner(System.in)){
			 System.out.println("Enter Employe Details");
			 if(sc!=null) {
				 System.out.println("Enter EmpNo");
				 eno = sc.nextInt(); 
			 }
	 //establish the connection
			 try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","aachal");
	// create callableStatement obj having query to call PL/SQL procedure as the precompiled  sql query
		CallableStatement cs = con.prepareCall(CALL_PROCEDURE);)
			 {
			 //Register OUT param with jdbc driver
			 if(cs!=null) {
			    cs.registerOutParameter(2,Types.VARCHAR);
				 cs.registerOutParameter(3,Types.VARCHAR);
				 cs.registerOutParameter(3,Types.FLOAT);
			 }
			//set values to IN param
			 if(cs!=null) {
				 cs.setInt(1, eno);
			 }
			//call the pl/sql function
			 if(cs!=null) {
				 cs.execute();
			 }
			 //gather result from out param
			 if(cs!=null) {
				 String name = cs.getString(2);
				 String desg=	cs.getString(3);
				 float  salary = cs.getFloat(4);
				 System.out.println("name:" +name+  "desg ::"  +desg+   "salary::" +salary) ;
			 }
			  
	  }//try2

   }//try1
	catch(SQLException se) {
		se.printStackTrace();
	}
   catch(Exception e) {
	   e.printStackTrace();
   }
}//main
}//class