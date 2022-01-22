package com.nt.jdbc;

/*create or replace procedure first_pro(x in number ,y in number, z out number) as
begin
  z:=x+y;
end;
/*/
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CSProcedureTest {
	private static final String CALL_PROCEDURE="{ CALL FIRST_PRO(?,?,?)}";
	public static void main(String[] args) {
		//READ INPUT
		int ss=0;
		int bb=0;
		try(Scanner sc = new Scanner(System.in)){
			if(sc!=null) {
				System.out.println("Enter first no::");
				ss=sc.nextInt();
				System.out.println("Enter second no::");
				bb=sc.nextInt();
			}
			//establish the connection
			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system","manager");
					//create callable statement obj having the query to call a PL/SQL procedure as a precompiled query

					CallableStatement cs=con.prepareCall(CALL_PROCEDURE);){
				//register OUT pram with Jdbc data type
				if(cs!=null)
					cs.registerOutParameter(3, Types.INTEGER);
				//set values to IN param
				if(cs!=null) {
					cs.setInt(1, ss);
					cs.setInt(2, bb);
				}
				//execute /call PLSQL procedure
				cs.execute();
				//gather result from out param
				int result=0;
				result=cs.getInt(3);
				System.out.println("sum is:::"+result);
			}//try2 
		}//try1
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main
}//class
