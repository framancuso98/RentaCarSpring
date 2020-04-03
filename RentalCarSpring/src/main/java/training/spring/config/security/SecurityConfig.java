package training.spring.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import training.spring.service.CustomUserDetailsService;



@Configuration
@ComponentScan("training.spring.service")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	 
	
	@Autowired
	//@Qualifier("customUserDetailsService")
	private CustomUserDetailsService userDetailsService;
	
	
	@Autowired
	DataSource dataSource;

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                
	                .authorizeRequests()
	                .antMatchers("/login*").permitAll()
	                .antMatchers("/register*").permitAll()
	                .antMatchers("/resources/css/**").permitAll()
	                .antMatchers("/resources/js/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .formLogin()
	                	.loginPage("/login/form")
	                	.loginProcessingUrl("/login")
	                	.failureUrl("/login/form?error")
	                		.usernameParameter("userId")
	                		.passwordParameter("password")
	                .and()
	                	.exceptionHandling()
	                	.accessDeniedPage("/login/form?forbidden")
	                .and()
	                	.logout()
	                	.logoutUrl("/login/form?logout")
	                .deleteCookies("JSESSIONID");
	    }
	 
	 
	 @Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	        auth.authenticationProvider(authenticationProvider());
	    }
	 
	 @Bean
	    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
	        return new AuthenticationTrustResolverImpl();
	    }
	 
	 @Bean
		public HttpFirewall allowUrlEncodedSlashHttpFirewall() 
		{
		    StrictHttpFirewall firewall = new StrictHttpFirewall();
		    firewall.setAllowUrlEncodedSlash(true);
		    firewall.setAllowSemicolon(true);
		    
		    return firewall;
		}

	    
	    @Override
	    protected void configure(final AuthenticationManagerBuilder auth) throws Exception { 
	    	auth.authenticationProvider(authenticationProvider());
	    }
	    
	    
	    @Bean 
	    public DaoAuthenticationProvider authenticationProvider() {
	    	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
			authenticationProvider().setUserDetailsService(userDetailsService);
			authenticationProvider().setPasswordEncoder(bCryptPasswordEncoder());
	    	
	    	return authenticationProvider;
	    }
	    
	   

	    @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    };
	    
	    
}
