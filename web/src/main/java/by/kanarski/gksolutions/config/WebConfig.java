package by.kanarski.gksolutions.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.ArrayList;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Configuration
@ComponentScan("by.kanarski.gksolutions")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportAutoConfiguration(ServicesApplication.class)
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class WebConfig {

    @Autowired
    private ApplicationContext applicationContext;

//    @Bean
//    public ContentNegotiationManagerFactoryBean cnManager() {
//        ContentNegotiationManagerFactoryBean contentNegotiationManagerFactoryBean =
//                new ContentNegotiationManagerFactoryBean();
//        contentNegotiationManagerFactoryBean.addMediaTypes(
//                new HashMap<String, MediaType>() {
//                    {
//                        put("json", MediaType.APPLICATION_JSON);
//                        put("xml", MediaType.TEXT_XML);
//                    }
//                }
//        );
//        return contentNegotiationManagerFactoryBean;
//    }

    @Bean
    @Autowired
    public ContentNegotiatingViewResolver restViewResolver(ContentNegotiationManager cnManager) {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setContentNegotiationManager(cnManager);
        viewResolver.setViewResolvers(
                new ArrayList<ViewResolver>() {
                    {
                        add(viewResolver());
                    }
                }
        );
        return viewResolver;
    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

//    @Bean
//    public Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder() {
//        Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder = new Jackson2ObjectMapperBuilder();
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.
//        jackson2ObjectMapperBuilder.configure();
//    }

    private ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        return resolver;
    }

}
