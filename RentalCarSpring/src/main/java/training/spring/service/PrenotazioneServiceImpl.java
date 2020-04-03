package training.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.spring.dao.PrenotazioneDAO;
import training.spring.entity.Auto;
import training.spring.entity.Prenotazione;
import training.spring.entity.Utente;
@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	PrenotazioneDAO prenotazioneDAO;
	
	@Override
	public void aggiungiPrenotazione(Prenotazione p) {
		String stato = "IN SOSPESO";
		p.setStato(stato);
		prenotazioneDAO.aggiungiPrenotazione(p);
	}

	@Override
	public void rimuoviPrenotazione(int id) {
		prenotazioneDAO.rimuoviPrenotazione(id);
	}

	@Override
	public void accettaPrenotazione(Prenotazione p) {
		String stato = "ACCETTATA";
		p.setStato(stato);
		prenotazioneDAO.accettaPrenotazione(p);
	}

	@Override
	public void rifiutaPrenotazione(Prenotazione p) {
		String stato = "RIFIUTATA";
		p.setStato(stato);
		prenotazioneDAO.rifiutaPrenotazione(p);
	}

	@Override
	public List<Prenotazione> findAllPrenotazioni() {
		return prenotazioneDAO.findAllPrenotazioni();
	}

	@Override
	public Prenotazione findById(int id) {
		return prenotazioneDAO.findById(id);
	}

	@Override
	public Prenotazione findByUtente(Utente utente) {
		return prenotazioneDAO.findByUtente(utente);
	}

	@Override
	public Prenotazione findByAuto(Auto auto) {
		return prenotazioneDAO.findByAuto(auto);
	}

}
