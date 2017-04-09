package by.kanarski.gksolutions.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Configuration
public class ServletInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
//        AnnotationConfigWebApplicationContext rootContext =
//                new AnnotationConfigWebApplicationContext();
//        rootContext.register(WebConfig.class, SecurityConfig.class);

        // Manage the lifecycle of the root application context
//        servletContext.addListener(new ContextLoaderListener(rootContext));

        FilterRegistration charEncodingfilterReg = servletContext.addFilter("CharacterEncodingFilter",
                CharacterEncodingFilter.class);
        charEncodingfilterReg.setInitParameter("encoding", "UTF-8");
        charEncodingfilterReg.setInitParameter("forceEncoding", "true");
        charEncodingfilterReg.addMappingForUrlPatterns(null, false, "/*");
//
//        servletContext.addFilter("OpenSessionInViewFilter", OpenSessionInViewFilter.class)
//                .addMappingForUrlPatterns(null, false, "/*");

        servletContext.addFilter("HttpMethodFilter", HiddenHttpMethodFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");
//        servletContext.addFilter("springSecurityFilterChain",
//                new DelegatingFilterProxy("springSecurityFilterChain"))
//                .addMappingForUrlPatterns(null, false, "/*");
//         Register and map the dispatcher servlet
//        ServletRegistration.Dynamic dispatcher =
//                servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/", "/index.html", "*.html");
    }

}
