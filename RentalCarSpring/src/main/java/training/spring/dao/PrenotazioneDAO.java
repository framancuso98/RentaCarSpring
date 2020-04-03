package training.spring.dao;

import java.util.List;

import training.spring.entity.Auto;
import training.spring.entity.Prenotazione;
import training.spring.entity.Utente;

public interface PrenotazioneDAO {
	
	public void aggiungiPrenotazione(Prenotazione p);
	//aggiunge una prenotazione prendendo in ingresso un id utente ed auto ed aggiunge in automatico allo stato "IN SOSPESO"
	
	public void rimuoviPrenotazione(int id);
	
	public void accettaPrenotazione(Prenotazione p);
	//cambia lo stato da "IN SOSPESO" ad "ACCETTATA" prendeno in ingresso l'id della prenotazione 
	
	public void rifiutaPrenotazione(Prenotazione p);
	//cambia lo stato da "IN SOSPESO" ad "RIFIUTATA" prendendo in ingresso l'id della prenotazione
	
	public List<Prenotazione> findAllPrenotazioni();
	//ritorna una lista di prenotazioni

	public Prenotazione findById(int id);
	
	public Prenotazione findByUtente(Utente utente);
	
	public Prenotazione findByAuto(Auto auto);
}
