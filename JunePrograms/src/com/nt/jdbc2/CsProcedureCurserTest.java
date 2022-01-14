package com.nt.jdbc2;
/*
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CsProcedureCurserTest {
      private static final String PROCEDURE_CALL_QUERY= " { CALL P_GET_EMPS_BYNAME_INTIAL(?,?)}";
	       public static void main(String[] args) {
		 try(Scanner sc = new Scanner(System.in)){
				 String initchars = null;
				 if(sc!=null) {
					 System.out.println("Enter intial  characters  of emp name");
					 initchars = sc.next()+"%" ;
				 }
				 try(
						
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system " ,"aachal");
						 CallableStatement cs  =  con.prepareCall(PROCEDURE_CALL_QUERY);
						 
						 ){
					 //register out oparm with jdbc type
					 if(cs!=null)
						 cs.execute();
					 //gather result from out paramater
					 if(cs!=null) {
						 //ResultSet rs = ResultSet(cs.getObject(2));
						 System.out.println(" ");
						 	boolean flag = false;
						 //	while(rs.next()) {
						 	 flag = true;
						 	//  System.out.println(rs.getInt(1) +" " +rs.getString(2)+" " +rs.getString(3)+ " " +rs.getFloat(4)+" " +rs.getInt(5));

						 	}//while
						// 	if(flag==false)
						 		System.out.println("RECORD NOT FOUND");
						 	
						 	}//IF
						 	
					 }//try
				 
				 }//try1
		     //  catch(SQLException se) {
		    	 //  se.printStackTrace();
		  //     }
			//	 catch(Exception e  ) {
			//		 e.printStackTrace();
			//	 }
		
	}//main

}//class*/
