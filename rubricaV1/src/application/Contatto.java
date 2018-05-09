package application;

public class Contatto {
	private Integer id;
	private Integer utente;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private Integer eta;
	
	
	public Contatto (Integer idd, Integer u, String n, String c,String i, String t, Integer e)
	{
		setId(idd);
		setUtente(u);
		setNome(n);
		setCognome(c);
		setIndirizzo(i);
		setTelefono(t);
		setEta(e);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUtente() {
		return utente;
	}

	public void setUtente(Integer utente) {
		this.utente = utente;
	}
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Integer getEta() {
		return eta;
	}
	public void setEta(Integer eta) {
		this.eta = eta;
	}
	
	

}
