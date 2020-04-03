package training.spring.service;

import java.util.List;

import training.spring.entity.Utente;

public interface UtenteService {
public List<Utente> findAllUtente();
	
	public void addUtente(Utente utente);
	
	public Utente findById(int id);
	
	public void deleteUtente(int id);
	
	//public Utente login(String nome, String cognome);
	public Utente findByUsername(String username);
	
	public void update(Utente utente);
}
