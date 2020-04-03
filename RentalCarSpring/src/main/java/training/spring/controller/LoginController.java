package training.spring.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import training.spring.service.UtenteService;

@Controller
@RequestMapping("/login/form")
@SessionAttributes("utente")
public class LoginController {
	
	@Autowired
	UtenteService service;
	@GetMapping
	//@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	
	/*@PostMapping
	//@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String controlloLogin(@RequestParam("username") String username,@RequestParam("cognome") String cognome, ModelMap model) {
		if(username != null && cognome != null) {
			try {
				Utente u = service.findByUsername(username);
				System.out.println(u);
				model.addAttribute("utente", u);
				if (u.getRuolo().equalsIgnoreCase("admin")) {
					System.out.println("admin");
					return "admin";		
				}else if(u.getRuolo().equalsIgnoreCase("utente")) {
					System.out.println("utente");
					return "utente";
				}else{
					System.out.println("ruolo non valido");
					return "login";
				}
			} catch (Exception e) {
				System.out.println("utente non presente");
				return "login";
			}
		}else {
			System.out.println("compilare entrambi i campi");
			return "login";
		}
	}
	
	
	@RequestMapping(value = {"/home"}, method = RequestMethod.GET )
	public String home(ModelMap model) {
		Utente utente = (Utente) model.get("utente");
		if (utente.getRuolo().equalsIgnoreCase("admin")) {
			return "admin";
		}else if (utente.getRuolo().equalsIgnoreCase("utente")) {
			return "utente";
		}else {
			return login();
		}
	}
	
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET )
	public String logout(ModelMap model) {
		model.remove("utente");
		return login();
		
	}*/
	
}
