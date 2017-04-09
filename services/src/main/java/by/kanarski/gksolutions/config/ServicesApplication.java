package by.kanarski.gksolutions.config;

import by.kanarski.gksolutions.utils.convert.service.CustomConversionServiceFactoryBean;
import by.kanarski.gksolutions.utils.convert.service.IEntityConversionService;
import by.kanarski.gksolutions.utils.convert.support.EntityConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@SpringBootApplication
@ComponentScan("by.kanarski.gksolutions")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportAutoConfiguration(DaoApplication.class)
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class ServicesApplication {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(ServicesApplication.class, args);
    }

    @Bean
    public FactoryBean<IEntityConversionService> entityConversionService() {
        CustomConversionServiceFactoryBean factoryBean = new CustomConversionServiceFactoryBean();
        factoryBean.setConverters(converterSet());
        return factoryBean;
    }

    @Bean
    public EntityConverter entityConverter() {
        return new EntityConverter();
    }

    private Set<Converter> converterSet() {
        Map<String, Converter> converterMap = applicationContext.getBeansOfType(Converter.class);
        return new HashSet<>(converterMap.values());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
