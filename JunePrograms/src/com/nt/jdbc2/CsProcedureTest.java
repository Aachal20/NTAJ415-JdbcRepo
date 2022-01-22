package com.nt.jdbc2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


public class CsProcedureTest {
	
	private static  final String CALL_PROCEDURE= " {CALL FIRST_PRO(?,?,?)}";

	public static void main(String[] args) {
	    //read input
		int first =0, second = 0;
		try(Scanner sc =  new Scanner(System.in)){
			if(sc!=null) {
				System.out.println("Enter first no::");
				first=sc.nextInt();
				System.out.println("Enter second no::");
				second = sc.nextInt();
			}
			try(Connection  con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system" , "manager");
			
			//try(Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system ", "manager");
					//create CallableStatment obj having query to call a pl/sql procedure as precompiled sql query
					
			CallableStatement cs = con.prepareCall(CALL_PROCEDURE);){
				//REGISTER OUT PARAM WITH JDBC  DATA TYPE
					if(cs!= null) {
					 //	cs.registerOutParameter(3,Types.INTEGER);
						cs.registerOutParameter(3,Types.INTEGER);
						//set values to in param
						if(cs!=null) {
							cs.setInt(1, first);
							cs.setInt(2, second);
						}
						//call  the pl/sql procedure
						if(cs!=null)
							cs.execute();
						//Gather Result from out parm
						int result = 0;
						if(cs!=null)
							result=cs.getInt(3);
						System.out.println(" Result is:: "  +result);
					}//try2
			}//try1
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}	
	}//main

}//class
