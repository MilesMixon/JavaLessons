package com.skillstorm;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.skillstorm.beans.Owner;
import com.skillstorm.services.OwnerService;

@Configuration
@ComponentScan("com.skillstorm")
@PropertySource("classpath:owner.properties")
@EnableJpaRepositories //allows it to scan for our repositories
@EnableTransactionManagement //need this to be able to use transactions
public class SpringDataJpaConfig {

	//@Value("${dbUrl}")
	String url = "jdbc:mysql://localhost:3306/zulmak";
	//@Value("${dbUser}")
	String user = "root";
	//@Value("${dbPw}")
	String password = "root";
	//@Value("${dbDriver}")
	String driver = "com.mysql.cj.jdbc.Driver";
	/*
	 * Data Source
	 * Transaction Manager
	 * Exception Translation Post Processor
	 * Entity Manager Factory
	 */
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataJpaConfig.class);
		OwnerService service = context.getBean(OwnerService.class);
		//System.out.println(service.findAll());
		//System.out.println(service.findByNameSimilar("%Ma%"));
		//System.out.println(service.findByAge(26));
		
		System.out.println(service.add(new Owner("Jane Pickles", "Grey", "Hot Dogs", 38)));
		System.out.println(service.findAll());
		//System.out.println(service.findByCarPrice(15000));
	}
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}
	
	//needs these bean names
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(datasource());
	}
	
	//entity manager - SessionFactory
	//essentially setting up everything we setupo for your hibernate session factory but in Java vs xml
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		emfBean.setDataSource(datasource());
		emfBean.setPackagesToScan("com.skillstorm.beans"); //where does it look for my @Entity classes
		
		//need to tell it what the underlying ORM provider is
		JpaVendorAdapter hibernate = new HibernateJpaVendorAdapter();
		emfBean.setJpaVendorAdapter(hibernate);
		
		//hibernate properties
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		emfBean.setJpaProperties(props);
		
		return emfBean;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		//need those so exceptions can be processed properly
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
