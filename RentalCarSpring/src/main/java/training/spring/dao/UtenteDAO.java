package training.spring.dao;

import java.util.List;

import training.spring.entity.Utente;

public interface UtenteDAO {
	
	public List<Utente> findAllUtente();
	
	public void addUtente(Utente utente);
	
	public Utente findById(int id);
	
	public void deleteUtente(int id);
	
	public Utente findByUsername(String username);
	
	public void update(Utente utente);
}
