package training.spring.utility;

import training.spring.entity.Auto;

public class rentalUtil {
	
	public static boolean validaAuto(Auto auto) {
		if(auto != null) {
			System.out.println("auto presente");
			if(auto.getCostruttore() != null && auto.getCostruttore().length() >= 3) {
				if(auto.getModello() != null && auto.getModello().length() >= 2) {
					if (auto.getTarga().length() == 7 && auto.getTarga() != null && auto.getTarga().matches("^[a-zA-Z]{2}[0-9]{3,4}[a-zA-Z]{2}$")) {
						auto.setTarga(auto.getTarga().toUpperCase());
					}else{
						System.out.println("targa non corretta");
						return false;
					}  
				}else {
					System.out.println("modello non valido");
					return false;
				}
			}else {
				System.out.println("costruttore non valido");
				return false;
			}
		}else {
			System.out.println("auto nulla");
			return false;
		}
		
		return true;
	}

}
