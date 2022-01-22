package com.nt.jdbc;
/*create or replace procedure p_get_emp_details_by_id 
( 
   no in number , name out varchar2, desg out varchar2, salary out varchar2
)
as
 begin
   select ename , job ,sal into name , desg, salary from  emp where empno=no;
 end;
/ */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CSProcedureTest2 {
	private static final String CALL_PROCEDURE="{ CALL  P_GET_EMP_DETAILS_BY_ID(?,?,?,?)}";
	public static void main(String[] args) {
		//READ INPUT
		int eno=0;
		try(Scanner sc = new Scanner(System.in)){
				System.out.println("Enter Employee Details::");
				if(sc!=null) {
				System.out.println("Enter Emp No::");
				eno=sc.nextInt();
			}
			//establish the connection
			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system","manager");
					//create callable statement obj having the query to call a PL/SQL procedure as a precompiled query

					CallableStatement cs=con.prepareCall(CALL_PROCEDURE);){
				//register OUT pram with Jdbc data type
				if(cs!=null) {
					cs.registerOutParameter(2, Types.VARCHAR);  //NAME
					cs.registerOutParameter(3,Types.VARCHAR);     //DESG
					cs.registerOutParameter(4,Types.FLOAT);            //SALARY
				}
				//set values to IN param
				if(cs!=null) {
					cs.setInt(1, eno);
				}
				//execute /call PLSQL procedure
				if(cs!=null) 
				   cs.execute();
				
				//gather result from out param
				if(cs!=null) {
					String name=cs.getString(2);
					String desg=cs.getString(3);
					float salary=cs.getFloat(4);
					System.out.println("name:::"+name+"desg::" +desg+ "salary:" +salary);
				}

			}//try2 
		}//try1
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("emp not found");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
