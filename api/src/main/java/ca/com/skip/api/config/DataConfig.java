package ca.com.skip.api.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ca.com.skip.api.repository")
@PropertySource("classpath:database.properties")
public class DataConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		final LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
		lfb.setDataSource(dataSource());
		lfb.setPersistenceProviderClass(HibernatePersistence.class);
		lfb.setPackagesToScan("ca.com.skip.api.model");
		lfb.setJpaProperties(hibernateProps());
		return lfb;
	}
	
	@Bean
	DataSource dataSource() {
		
		final DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(environment.getProperty("server.url"));
		ds.setUsername(environment.getProperty("server.user"));
		ds.setPassword(environment.getProperty("server.password"));
		ds.setDriverClassName(environment.getProperty("server.driver"));
		return ds;
	}
	
	Properties hibernateProps() {
		
		final Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		return properties;
	}
	
	@Bean
	JpaTransactionManager transactionManager() {
		
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
