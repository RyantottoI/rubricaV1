package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Scanner {

	public Credenziali getCredenziali() {
		// TODO Auto-generated method stub
		
		Credenziali c;
		
		InputStream input = null;
		try {
			
			
			Properties prop = new Properties();
			input = new FileInputStream("credenziali_database.properties");

			// load a properties file
			prop.load(input);
			
			c = new Credenziali(prop.getProperty("Username"), prop.getProperty("Password"), prop.getProperty("Host"), prop.getProperty("Porta"));
			
			return c;
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return null;
	}
}
