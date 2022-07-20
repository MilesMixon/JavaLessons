package com.skillstorm;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.skillstorm.security.SpringSecurityConfig;

@Configuration
@EnableWebMvc
@EnableJpaRepositories
@EnableTransactionManagement
//@ComponentScan("com.skillstorm") wont work
//need WebMvcConfigurer to be able to map static resources
@Import(SpringSecurityConfig.class)
public class SpringMvcConfig implements WebApplicationInitializer, WebMvcConfigurer {

	String url = "jdbc:mysql://localhost:3306/zulmak";
	String user = "root";
	String password = "root";
	String driver = "com.mysql.cj.jdbc.Driver";
	
	//from WebMvcConfigurer
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//if a request comes in and needs a static resource, where do i find it?
		//any request that is looking for /static/whatever will look inside our static folder
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	@Bean
	public ViewResolver viewResolver() {
		//take our views and return them to the user
		
		//we can add prefixes and suffixes in here.
		//this only works when everything follows the same naming convention
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/static/");
		resolver.setSuffix(".html");
		
		return resolver;
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//everything that we would put in the web.xml we put here
		//things like:
		//register the dispatcher servlet with the servlet container
		//servlet mappings(url-pattern)
		//load-on startup, etc
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.scan("com.skillstorm");
		
		//need the context loader listener
		//this needs out app context
		servletContext.addListener(new ContextLoaderListener(context));
		
		//setup our dispatcher
		//have to hand that new dispatcher servlet a blank web.xml (handled by GenericWebApplicationContext)
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", 
				new DispatcherServlet(new GenericWebApplicationContext()));
		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		emfBean.setDataSource(dataSource());
		emfBean.setPackagesToScan("com.skillstorm");
		
		JpaVendorAdapter hibernate = new HibernateJpaVendorAdapter();
		emfBean.setJpaVendorAdapter(hibernate);
		
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		emfBean.setJpaProperties(props);
		
		return emfBean;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
