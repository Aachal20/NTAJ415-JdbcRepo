
/*create or replace procedure p_authenticate
(
                 username in varchar2, password in varchar2 , result out varchar2
)As 
   cnt number(5);
 begin 
  select count(*) into cnt from irctc_tab where     uname=username and pwd = password;                                                                                                           uname=username and pwd = password; 
if(cnt<>0) then
     result:='valid crdentials';
else 
    result:='Invalid crdentials';
end if ;
end p_authenticate;
/
 */

package com.nt.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CSProcedureAuthenticateTest3 {
	private static final String CALL_PROCEDURE_QUERY="{ CALL  P_AUTHENTICATE(?,?,?)}";
	public static void main(String[] args) {
		//READ INPUT
		String username=null;
		String password=null;
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter Authentication::");
			if(sc!=null) {
				System.out.println("Enter username::");
				username=sc.next();
				System.out.println("Enter password::");
				password=sc.next();
			}
			//establish the connection
			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system","manager");
					//create callable statement obj having the query to call a PL/SQL procedure as a precompiled query

					CallableStatement cs=con.prepareCall(CALL_PROCEDURE_QUERY);){
				//register OUT pram with Jdbc data type
				if(cs!=null) {
					cs.registerOutParameter(3, Types.VARCHAR);  //NAME

				}
				//set values to IN param
				if(cs!=null) {
					cs.setString(1, username);
					cs.setString(2, password);
				}
				//execute /call PLSQL procedure
				if(cs!=null) 
					cs.execute();

				//gather result from out param
				String result=null;
				if(cs!=null) 
					result=cs.getString(3);
				System.out.println(result);

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
