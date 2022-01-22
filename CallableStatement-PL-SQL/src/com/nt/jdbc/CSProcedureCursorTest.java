


/*CREATE OR REPLACE PROCEDURE P_GET_EMP_BYNAME_INITAL
  (  
      INITCHARS IN VARCHAR2,
      DETAILS OUT SYS_REFCURSOR
 )
 AS 
     BEGIN 
        OPEN DETAILS FOR
               SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE INITCHARS;
  END P_GET_EMP_BYNAME_INITAL;
/
 */
package com.nt.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CSProcedureCursorTest {
	private static final String CALL_PROCEDURE_QUERY="{ CALL  P_GET_EMP_BYNAME_INITAL(?,?)}";
	public static void main(String[] args) {
		//READ INPUT
		String initChars=null;

		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter INTIALS CHAR of emp name::");
			if(sc!=null) {
				System.out.println("Enter username::");
				initChars=sc.next()+"%";

			}
			//establish the connection
			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system","manager");
					//create callable statement obj having the query to call a PL/SQL procedure as a precompiled query

					CallableStatement cs=con.prepareCall(CALL_PROCEDURE_QUERY);){
				//register OUT pram with Jdbc data type
				if(cs!=null) {
					cs.registerOutParameter(2, OracleTypes.CURSOR);  //NAME

				}
				//set values to IN param
				if(cs!=null) {
					cs.setString(1, initChars);

				}
				//execute /call PLSQL procedure
				if(cs!=null) 
					cs.execute();

				//gather result from out param
                      if(cs!=null) {
					//ResultSet rs = (ResultSet)cs.getObject(2);
					ResultSet rs = (ResultSet)cs.getObject(2);

					System.out.println("output is::");
					boolean flag=false;
					  while(rs.next()) {
						flag=true;
						System.out.println(rs.getString(1)+ " " +rs.getString(2)+ " " +rs.getString(3)+ " "+rs.getString(4)+ " "+rs.getString(5));
					    }//while
						if(flag==false)
							System.out.println("record not found");
					}//if
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
