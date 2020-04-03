package training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import training.spring.entity.Utente;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.spring.entity.Utente;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UtenteService utenteService;
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utente utente = utenteService.findByUsername(username);
		if (utente == null) {
            throw new UsernameNotFoundException("utente non trovato");
        }
		
		UserBuilder builder = null;
		
		builder = User.withUsername(utente.getUsername());
		builder.password(utente.getPassword());
		
		
        return builder.build();
	}

}*/
@Service
public class CustomUserDetailsService implements UserDetailsService {
 
    
    @Autowired
	private UtenteService utenteService;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        Utente user = utenteService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}