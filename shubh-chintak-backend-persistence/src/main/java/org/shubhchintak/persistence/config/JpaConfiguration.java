package org.shubhchintak.persistence.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

//import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "org.shubhchintak.persistence.repository" })
@PropertySource(value = { "classpath:persistence.properties" })
public class JpaConfiguration {
	
	@Autowired
	private Environment env;

	@Value("${subhchintak.entity.package}")
	private String entityPackage;

	
//	@Bean
//	public JpaTransactionManager getJpaTransactionManager() {
//		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//		jpaTransactionManager.setEntityManagerFactory((EntityManagerFactory) getEntityManagerFactory());
//		return jpaTransactionManager;
//	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("org.shubhchintak.persistence.entity");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaProperties(additionalProperties());
		return emf;
	}

	private DriverManagerDataSource getDataSource() {
		
		//String driverClassName = env.getProperty("subhchintak.database.datasource.driverclassname");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("subhchintak.database.datasource.driverclassname"));
		dataSource.setUrl(env.getProperty("subhchintak.database.datasource.url"));
		dataSource.setUsername(env.getProperty("subhchintak.database.datasource.username"));
		dataSource.setPassword(env.getProperty("subhchintak.database.datasource.password"));

		return dataSource;
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", env.getProperty("subhchintak.database.datasource.hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", env.getProperty("subhchintak.database.datasource.hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", env.getProperty("subhchintak.database.datasource.hibernate.format_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("subhchintak.database.datasource.hibernate.hbm2ddl.auto"));
		return properties;
	}
	//
	//
	// @Bean
	// public PlatformTransactionManager transactionManager(EntityManagerFactory
	// emf){
	// JpaTransactionManager transactionManager = new JpaTransactionManager();
	// transactionManager.setEntityManagerFactory(emf);
	//
	// return transactionManager;
	// }
	//
	// @Bean
	// public PersistenceExceptionTranslationPostProcessor
	// exceptionTranslation(){
	// return new PersistenceExceptionTranslationPostProcessor();
	// }
}
