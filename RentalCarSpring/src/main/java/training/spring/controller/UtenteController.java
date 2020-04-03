package training.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import training.spring.entity.Utente;
import training.spring.service.PrenotazioneService;
import training.spring.service.UtenteService;

@Controller
@RequestMapping("/utente")
public class UtenteController {
	
	@Autowired
	UtenteService utenteService;
	@Autowired
	PrenotazioneService prenotazioneService;
	
	@RequestMapping(value = {"/all"}, method = RequestMethod.GET)
	public String listaUtenti(ModelMap model) {
		List<Utente> lista = utenteService.findAllUtente();
		model.addAttribute("lista",lista);
		return "listautenti";	
	}
	
	@RequestMapping(value = {"/all"}, method = RequestMethod.POST)
	public String eliminaUtente(@RequestParam("id") String id,ModelMap model) {
		int id_utente = Integer.parseInt(id);
		System.out.println(id_utente);
		Utente utente = utenteService.findById(id_utente);
		if(prenotazioneService.findByUtente(utente) == null){
		utenteService.deleteUtente(id_utente);
		}else {
			return listaUtenti(model);
		}
		return listaUtenti(model);
	}
	
	
	@RequestMapping(value= {"/addUtente"}, method = RequestMethod.GET)
	public String addUtente(@ModelAttribute Utente utente, ModelMap model) {
		model.addAttribute("utente", utente);
		return "aggiungiutente";
	}
	
	
	@RequestMapping(value= {"/addUtente"}, method = RequestMethod.POST)
	public String salvaUtente(@Valid @ModelAttribute Utente utente,BindingResult bindingResult , ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "aggiungiutente";
		}
		utenteService.addUtente(utente);
		return listaUtenti(model);
	}
	
	
	@RequestMapping(value= {"/profilo"}, method = RequestMethod.GET)
	public static String profilo(ModelMap model) {
		return "profilo";
	}
	
	@RequestMapping(value = {"/updateProfilo"}, method = RequestMethod.GET)
	public String updateProfilo(ModelMap model) {
		//Utente updateUser = new Utente();
		//model.addAttribute("newUser", updateUser);
		return "modificaprofilo";
	}
	
	
	@RequestMapping(value= {"/updateProfilo"}, method = RequestMethod.POST)
	public String updateProfilo(@ModelAttribute Utente updateUser, ModelMap model) {
		utenteService.update(updateUser);
		model.remove("utente");
		model.addAttribute("utente", updateUser);
		return "profilo";
	}


}
