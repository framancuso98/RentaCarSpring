package training.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import training.spring.dao.UtenteDAO;

import training.spring.entity.Utente;

@Service
@ComponentScan("training.spring.dao")
@EnableTransactionManagement
public class UtenteServiceImpl implements UtenteService{

	@Autowired
	UtenteDAO utenteDAO;
	
	

	public List<Utente> findAllUtente() {
		return utenteDAO.findAllUtente();
	}

	

	public void addUtente(Utente utente) {
		utenteDAO.addUtente(utente);
	}

	

	public Utente findById(int id) {
		return utenteDAO.findById(id);
	}



	public void deleteUtente(int id) {
		utenteDAO.deleteUtente(id);
	}

	
	/*public Utente login(String nome, String cognome) {
		return utenteDAO.login(nome, cognome);
		
	}*/

	
	public void update(Utente utente) {
		utenteDAO.update(utente);
	}



	@Override
	public Utente findByUsername(String username) {
		return utenteDAO.findByUsername(username);
	}

}
