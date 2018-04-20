package ca.com.skip.api.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ca.com.skip.api.repository")
@PropertySource(value = { "classpath:database.properties" })
public class DataConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() throws IllegalStateException, PropertyVetoException {
		
		final ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty("server.driver"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("server.url"));
		dataSource.setUser(environment.getRequiredProperty("server.user"));
		dataSource.setPassword(environment.getRequiredProperty("server.password"));
		
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws IllegalStateException, PropertyVetoException {
		
		final LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource());
		entityManager.setPackagesToScan("ca.com.skip.api.model");
		entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManager.setJpaDialect(new HibernateJpaDialect());
		entityManager.setJpaProperties(hibernateProperties());
		
		return entityManager;
	}
	
	public Properties hibernateProperties() {
		
		final Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		
		return properties;
	}
	
	@Bean
	@Autowired
	public JpaTransactionManager transactionManager() throws IllegalStateException, PropertyVetoException {
		
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
	
}
