package by.kanarski.gksolutions.config;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Properties;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@SpringBootApplication
@ComponentScan("by.kanarski.gksolutions")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportAutoConfiguration(ServicesApplication.class)
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class WebApplication {

	public static void main(String[] args) {
	    SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(
	            ExternalServletInitializer.class,
                ServletInitializer.class,
                WebApplication.class);
	    applicationBuilder
                .properties(getProperties())
                .run(args);
	}

    private static Properties getProperties() {
        Properties props = new Properties();
        props.put("spring.config.location", "classpath:");
        return props;
    }

}
