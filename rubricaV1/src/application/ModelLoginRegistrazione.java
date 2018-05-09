package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelLoginRegistrazione {
	
	private Credenziali credenziali;
	private Scanner scanner;
	private Connection connection;
	public ModelLoginRegistrazione(){
		scanner = new Scanner();
		credenziali = scanner.getCredenziali();
		connection = ConnessioneDB.connessione(credenziali.getUsername(), credenziali.getPassword(), credenziali.getHost(), credenziali.getPorta());
		if(connection == null)
		{
			System.out.println("connection not successful");
			System.exit(1);
		}
	}
	
	public boolean utentePresente(String username, String password) {
		// TODO Auto-generated method stub
		
		Statement myStmt;
		try {
			myStmt = connection.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM rubrica.utente WHERE utente.username = '" + username + "' AND utente.password = '" + password + "'");
			
			if (myRs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean utenteDoppione(String username) {
		// TODO Auto-generated method stub
		
		Statement myStmt;
		try {
			myStmt = connection.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM rubrica.utente WHERE utente.username = '" + username + "'");
			
			if (myRs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public void inserisciUtente(String username, String password) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement("INSERT INTO rubrica.utente (username,password) VALUES (?,?)");
			preparedStmt.setString (1, username);
		    preparedStmt.setString (2, password);
		     
		    preparedStmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer idUtente(Utente utente) {
		// TODO Auto-generated method stub
		Statement myStmt;
		try {
			myStmt = connection.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM rubrica.utente WHERE utente.username = '" + utente.getUsername() + "' AND password = '" + utente.getPassword() + "'");
			
			if (myRs.next())
			{
				return myRs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
