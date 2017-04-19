package by.kanarski.gksolutions.config;

import by.kanarski.gksolutions.utils.CustomNamingStrategy;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("by.kanarski.gksolutions")
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class DaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoApplication.class, args);
    }

    @Bean
    @Primary
    public DataSource dataSource() throws PropertyVetoException {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost/gksolutions?autoReconnect=true&useSSL=false");
        config.setUsername("root");
        config.setPassword("17021993");
        return new HikariDataSource(config);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setNamingStrategy(new CustomNamingStrategy());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setPackagesToScan("by.kanarski.gksolutions.entities");
        return sessionFactoryBean;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("debug", "true");
                setProperty("hibernate.show_sql", "true");
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                setProperty("hibernate.cglib.use_reflection_optimizer", "true");
                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.hikari.autocommit", "true");
                setProperty("hibernate.hikari.minimumIdle", "5");
                setProperty("hibernate.hikari.maximumPoolSize", "20");
                setProperty("hibernate.hikari.connectionTimeout", "30000");
                setProperty("hibernate.hikari.idleTimeout", "60000");
                setProperty("hibernate.hbm2ddl.auto", "create");
            }
        };
    }


}
