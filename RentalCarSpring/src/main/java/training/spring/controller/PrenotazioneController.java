package training.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import training.spring.entity.Auto;
import training.spring.entity.Prenotazione;
import training.spring.entity.Utente;
import training.spring.service.AutoService;
import training.spring.service.PrenotazioneService;
import training.spring.service.UtenteService;

@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController {
	
	@Autowired
	PrenotazioneService prenotazioneService;
	@Autowired 
	UtenteService utenteService;
	@Autowired
	AutoService autoService;
	
	@RequestMapping(value = {"/all"}, method = RequestMethod.GET )
	public String listaPrenotazioni(ModelMap model) {
		List<Prenotazione> prenotazioni = prenotazioneService.findAllPrenotazioni();
		model.addAttribute("prenotazioni", prenotazioni);
		return "listaprenotazioni";
	}
	
	@RequestMapping(value = {"/accetta"}, method = RequestMethod.POST )
	public String accettaPrenotazione(ModelMap model,@RequestParam("id") String id_prenotazione) {
		int id = Integer.parseInt(id_prenotazione);
		Prenotazione prenotazione = prenotazioneService.findById(id);
		prenotazioneService.accettaPrenotazione(prenotazione);
		return listaPrenotazioni(model);
	}
	
	@RequestMapping(value = {"/rifiuta"}, method = RequestMethod.POST )
	public String rifiutaPrenotazione(ModelMap model,@RequestParam("id") String id_prenotazione) {
		int id = Integer.parseInt(id_prenotazione);
		Prenotazione prenotazione = prenotazioneService.findById(id);
		prenotazioneService.rifiutaPrenotazione(prenotazione);
		return listaPrenotazioni(model);
	}
	
	@RequestMapping(value = {"/addPrenotazione"}, method = RequestMethod.POST )
	public String addPrenotazione(@RequestParam("idAuto")String idAuto, @RequestParam("idUtente")String idUtente,ModelMap model) {
		int id_auto = Integer.parseInt(idAuto);
		int id_utente = Integer.parseInt(idUtente);
		Utente utente =utenteService.findById(id_utente);
		Auto auto = autoService.findById(id_auto);
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setAuto(auto);
		prenotazione.setUtente(utente);
		prenotazioneService.aggiungiPrenotazione(prenotazione);
		return UtenteController.profilo(model);	
	}
	
}
