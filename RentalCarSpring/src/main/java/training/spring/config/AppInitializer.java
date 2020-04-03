package training.spring.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import training.spring.config.security.SecurityConfig;



/**
	 * @author Ramesh Fadatare
	 */
	
	public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	    @Override
	   
	    protected Class <?> [] getRootConfigClasses() {
	        return new Class[] {
	           AppContext.class, SecurityConfig.class
	        };
	        //return null;
	    }

	    @Override
	    protected Class <?> [] getServletConfigClasses() {
	        return new Class[] {
	            WebMvcConfig.class
	        };
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[] {
	            "/"
	        };
	    }
}

/*public class AppInitializer implements WebApplicationInitializer {
	 
    @Override
    public void onStartup(ServletContext container) {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppContext.class, SecurityConfig.class);
 
        // Manage the lifecycle of the root application context
        container. addListener (new ContextLoaderListener(rootContext));
 
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(WebMvcConfig.class);
             
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
         
    }
 
 }*/
