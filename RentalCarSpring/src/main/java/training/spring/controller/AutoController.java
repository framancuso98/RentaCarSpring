package training.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import training.spring.entity.Auto;
import training.spring.entity.Categoria;
import training.spring.service.AutoService;
import training.spring.service.CategoriaService;
import training.spring.service.PrenotazioneService;
import training.spring.utility.rentalUtil;

@Controller
@RequestMapping("/auto")
public class AutoController {

	@Autowired
	AutoService autoService;
	@Autowired
	CategoriaService categoriaService;
	@Autowired
	PrenotazioneService prenotazioneService;
	
	
	@RequestMapping(value = {"/all"}, method = RequestMethod.GET)
	public String listaAuto(ModelMap model) {
		List<Auto> lista = autoService.findAllAuto();
		model.addAttribute("listaAuto", lista);
		return "listauto";
	}
	
	@RequestMapping(value = {"/all"}, method = RequestMethod.POST)
	public String eliminaAuto(@RequestParam("id") String id,ModelMap model) {
		int id_auto = Integer.parseInt(id);
		Auto auto = autoService.findById(id_auto);
		if (prenotazioneService.findByAuto(auto) == null) {
			autoService.deleteAuto(id_auto);
		}
		
		return listaAuto(model);
	}
	
	@RequestMapping(value = {"/addAuto"}, method = RequestMethod.GET)
	public String aggiungiAuto( @ModelAttribute Auto auto, ModelMap model) {
		List<Categoria> categorie = categoriaService.findAllCategoria();
		model.addAttribute("categorie", categorie);
		return "aggiungiauto";
	}
	
	@RequestMapping(value = {"/addAuto"}, method = RequestMethod.POST)
	public String validaAuto(@Valid @ModelAttribute Auto auto, BindingResult bindingResult,@RequestParam("id_categoria")String id_categoria, ModelMap model) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors()); 
			return aggiungiAuto(auto, model);
		}
		int id = Integer.parseInt(id_categoria);
		Categoria categoria = categoriaService.findById(id);
		auto.setCategoria(categoria);
		if(rentalUtil.validaAuto(auto)) {
			autoService.addAuto(auto);
			return listaAuto(model);
		}
		return aggiungiAuto(auto, model);
		
	}
	
	
	@RequestMapping(value = {"/updateAuto"}, method = RequestMethod.GET)
	public String updateAuto(@RequestParam("id")String id_auto,ModelMap model) {
		int id = Integer.parseInt(id_auto);
		Auto auto = autoService.findById(id);
		List<Categoria> categorie = categoriaService.findAllCategoria();
		model.addAttribute("categorie", categorie);
		model.addAttribute("auto", auto);
		return "modificauto";
	}
	
	
	@RequestMapping(value = {"/updateAuto"}, method = RequestMethod.POST)
	public String updateAuto(@ModelAttribute Auto updateAuto, ModelMap model, @RequestParam String id_categoria) {
		int id = Integer.parseInt(id_categoria);
		Categoria categoria = categoriaService.findById(id);
		updateAuto.setCategoria(categoria);
		if(rentalUtil.validaAuto(updateAuto)) {
			autoService.update(updateAuto);
			return listaAuto(model);
		}
			return listaAuto(model);
	}
	
	
	@RequestMapping(value= {"/addPrenotazione"}, method = RequestMethod.POST)
	public ModelAndView Prenotazione(HttpServletRequest request, ModelMap model) {
		request.setAttribute(View. RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
		return new ModelAndView("redirect:/prenotazione/addPrenotazione", model);
	}
	

}
