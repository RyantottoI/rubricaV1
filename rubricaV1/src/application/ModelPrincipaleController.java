package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelPrincipaleController {
	
	public ObservableList<Contatto> list=  FXCollections.observableArrayList();
	private Connection connection;
	private Credenziali credenziali;
	private Scanner scanner;
	
	public ModelPrincipaleController(){
		scanner = new Scanner();
		credenziali = scanner.getCredenziali();
		connection = ConnessioneDB.connessione(credenziali.getUsername(), credenziali.getPassword(), credenziali.getHost(), credenziali.getPorta());
		if(connection == null)
		{
			System.out.println("connection not successful");
			System.exit(1);
		}
	}

	public ObservableList<Contatto> creaLista(Utente utente) {
		// TODO Auto-generated method stub
		Statement myStmt;
		try {
			myStmt = connection.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM rubrica.contatto WHERE contatto.utente = '" + utente.getId() + "'");
			while (myRs.next())
			{
				
				list.add(new Contatto(myRs.getInt("id"), myRs.getInt("utente"), myRs.getString("nome"), myRs.getString("cognome"), myRs.getString("indirizzo"), myRs.getString("telefono"), myRs.getInt("eta")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	public void nuovoContatto(Contatto temp) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement("INSERT INTO rubrica.contatto (utente,nome,cognome,indirizzo,telefono,eta) VALUES (?,?,?,?,?,?)");
			preparedStmt.setInt (1, temp.getUtente());
		    preparedStmt.setString (2, temp.getNome());
		    preparedStmt.setString (3, temp.getCognome());
		    preparedStmt.setString (4, temp.getIndirizzo());
		    preparedStmt.setString (5, temp.getTelefono());
		    preparedStmt.setInt (6, temp.getEta());
		     
		    preparedStmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificaContatto(Contatto c) {
		// TODO Auto-generated method stub
		String query = "update rubrica.contatto set nome = ?, cognome = ?, indirizzo = ?, telefono = ?, eta = ? where id = ? AND utente = ?";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, c.getNome());
			preparedStmt.setString(2, c.getCognome());
			preparedStmt.setString(3, c.getIndirizzo());
			preparedStmt.setString(4, c.getTelefono());
			preparedStmt.setInt(5, c.getEta());
			preparedStmt.setInt(6, c.getId());
			preparedStmt.setInt(7, c.getUtente());
			
			// execute the java preparedstatement
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void eliminaContatto(Contatto c) {
		// TODO Auto-generated method stub
		String query = "delete from rubrica.contatto where id = ?";
	      PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, c.getId());
			
			// execute the preparedstatement
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}

	public boolean utentePresente(Contatto temp) {
		// TODO Auto-generated method stubStatement myStmt;
		Statement myStmt;
		try {
			myStmt = connection.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM rubrica.contatto WHERE contatto.utente = '" + temp.getUtente() + "' AND contatto.nome = '" + temp.getNome() + "' AND contatto.cognome = '" + temp.getCognome() + "'");
			
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

}
