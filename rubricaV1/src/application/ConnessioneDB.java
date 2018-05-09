package application;

import java.sql.*;

public class ConnessioneDB {
	
	public static Connection connessione(String user, String PW, String host, String porta)
	{
		
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/rubrica?autoReconnect=true&useSSL=false", user, PW);
			
			/*Statement myStmt = myConn.createStatement();
			
			ResultSet myRs = myStmt.executeQuery("select * from utente");
			
			while (myRs.next())
			{
				System.out.println(myRs.getString("username") + " " + myRs.getString("password") + " " + myRs.getString("id"));
			}*/
			return myConn;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
