package com.nt.jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Wrapper;


public class DatabaseMetaData {

	public static void main(String[] args) throws SQLException {
		
	 	try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"system","manager");){
	        // create DatabaseMetaData object
	 		java.sql.DatabaseMetaData dbmd =  con.getMetaData();
	 	//	DatabaseMetaData dbmd = con.getMetaData();
	 		if(dbmd!=null) {
	 			System.out.println("db s/w name::"  +dbmd.getDatabaseProductName());
	 			System.out.println("Db version::" +dbmd.getDatabaseProductName());
	 			System.out.println("jdbc driver name::" +dbmd.getDriverName());
	 			System.out.println();
	 			System.out.println("jdbc driver version::" +dbmd.getSQLKeywords());
	 			System.out.println("All sql Keyword::" +dbmd.getNumericFunctions());
	 			System.out.println("All System Functions::" +dbmd.getSystemFunctions());
	 			System.out.println();
	 			System.out.println("All String Functions::" +dbmd.getStringFunctions());
	 			System.out.println("Max chars in table Name::" +dbmd.getMaxTableNameLength());
	 			System.out.println("Max table in select query::" +dbmd.getMaxColumnsInSelect());
	 			System.out.println("Max row size::" +dbmd.getMaxRowSize());
	 			System.out.println("support pl sql procedure ?::" +dbmd.supportsStoredProcedures());
	 		}
	 	
	 	}
	 
		

	}

}
