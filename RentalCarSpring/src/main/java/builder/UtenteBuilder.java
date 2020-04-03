package builder;

import java.util.ArrayList;
import java.util.List;

import dto.UtenteDto;
import training.spring.entity.Utente;

public class UtenteBuilder {

	public static UtenteDto dtoBuilder(Utente utente) {
		UtenteDto dto = new UtenteDto();
		dto.setNome(utente.getNome());
		dto.setCognome(utente.getCognome());
		dto.setNascita(utente.getData_nascita());
		dto.setRuolo(utente.getRuolo());
		return dto;
	}
	
	public static List<UtenteDto> dtosBuilder(List<Utente> utenti){
		List<UtenteDto> dtos = new ArrayList<>();
		for(Utente utente:utenti) {
			dtos.add(dtoBuilder(utente));
		}
		return dtos;
	}
}
