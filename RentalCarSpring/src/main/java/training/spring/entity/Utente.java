package training.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.UniqueElements;





@Entity
@Table(name="utente")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@NotEmpty
	@Min(value = 3)
	@Column(name="nome")
	private String nome;
	
	@NotEmpty
	@Column(name = "username")
	@UniqueElements
	private String username;
	
	@NotEmpty
	@Column(name = "password")
	private String password;
	
	@NotEmpty
	@Min(value = 3)
	@Column(name="cognome")
	private String cognome;
	
	@NotEmpty
	@Column(name="data_nascita")
	private String data_nascita;
	
	@NotEmpty
	@Column(name="ruolo")
	private String ruolo;

	public Utente() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(String data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", username=" + username + ", password=" + password
				+ ", cognome=" + cognome + ", data_nascita=" + data_nascita + ", ruolo=" + ruolo + "]";
	}
	


	
	
}
