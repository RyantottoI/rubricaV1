package application;

public class Credenziali {
	private String username;
	private String password;
	private String host;
	private String Porta;
	
	public Credenziali (String username, String password, String host, String Porta)
	{
		setUsername(username);
		setPassword(password);
		setHost(host);
		setPorta(Porta);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPorta() {
		return Porta;
	}
	public void setPorta(String porta) {
		Porta = porta;
	}
}
