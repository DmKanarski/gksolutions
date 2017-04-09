package by.kanarski.gksolutions.config;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Configuration
public class ExternalServletInitializer extends SpringBootServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(WebApplication.class, SecurityConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        servletContext.addFilter("springSecurityFilterChain",
                new DelegatingFilterProxy("springSecurityFilterChain"))
                .addMappingForUrlPatterns(null, false, "/*");
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/", "/index.html", "*.html");
    }
}
