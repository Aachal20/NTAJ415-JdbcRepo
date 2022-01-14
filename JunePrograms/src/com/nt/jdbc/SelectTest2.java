package com.nt.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
public class SelectTest2 {

	public static void main(String[] args) {
		Scanner sc= null;
		String desg1=null, desg2=null,desg3=null;
		Connection con = null;
		Statement  st = null;
		ResultSet rs = null;

		try{
			sc = new Scanner(System.in);

			if(sc!=null){
				System.out.println("enter desg1:::");
				desg1=sc.next().toUpperCase();//gives CLEARK
				System.out.println("enter desg2:::");
				desg2=sc.next().toUpperCase();//gives MANAGER
				System.out.println("enter desg3:::");
				desg3=sc.next().toUpperCase();//gives SALESMAN
			}//if

			//convert input values required as sql query
			desg1="'"+desg1+"'";   //gives CLEARK
			desg2="'"+desg2+"'";   //gives MANAGER
			desg3="'"+desg3+"'";    //gives SALESMAN

			//Load jdbc driver class
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"system" , "manager");

			//create statement object
			if(con!=null)
				st=con.createStatement();
			
             //prepare sql query
            //SELECT ENO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN('CLERK' ,'MANAGER','SALESMAN')ORDER BY JOB";

			String query="SELECT EmpNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN('CLERK' ,'MANAGER','SALESMAN')ORDER BY JOB";
			System.out.println(query); //ctrl+u for uppercase  ctrl+L for lowercase

			//send and execute sql query in db s/w
			if(st!=null)
				rs=st.executeQuery(query);

			if(rs!=null)
				System.out.println("The Employee Details  Are");	
			while(rs.next()!=false){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4)+" "+rs.getInt(5));

			}//while
		}//if


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

			try {
				if(sc!=null)
					sc.close();                  //sc
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}


		}//finally

	}//main
}//class





