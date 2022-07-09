package com.skillstorm;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.skillstorm.beans.Owner;
import com.skillstorm.data.OwnerDao;

@Configuration
@ComponentScan
@PropertySource("classpath:owner.properties")
@EnableTransactionManagement
public class OwnerJdbcConfig {
	
	@Value("${dbUrl}")
	String url;
	@Value("${dbUser}")
	String user;
	@Value("${dbPw}")
	String password;
	@Value("${dbDriver}")
	String driverClassName;
	
	//in Spring jdbc you use a DataSource to manage your connection
	@Bean
	public DataSource datasource() {
		SingleConnectionDataSource ds = new SingleConnectionDataSource(url, user, password, false);
		ds.setDriverClassName(driverClassName);
		return ds;
	}
	
	//In Spring JDBC they use a JDBC Template
	//the template handles exception, makes queries, translates data, etc for you
	//is also thread safe
	@Bean
	public JdbcTemplate jdbcTemplate() {
		//uses the data source
		return new JdbcTemplate(datasource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedTemplate() {
		return new NamedParameterJdbcTemplate(datasource());
	}
	
	//needs these bean names
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(datasource());
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(OwnerJdbcConfig.class);
		//context.getBean(OwnerDao.class).findAll();
		//context.getBean(OwnerDao.class).findById(7);
		//context.getBean(OwnerDao.class).createOwner(new Owner(0, "Ozzy Osbourne", "Green", "Bats", 73));
		//Owner temp = new Owner(0, "Austin Reeves", "Grey", "Tex Mex", 23);
		//context.getBean(OwnerDao.class).createOwnerNoQuestionMarks(temp);
		//context.getBean(OwnerDao.class).findAll();
		//context.getBean(OwnerDao.class).countRows();
		//context.getBean(OwnerDao.class).findBlues();
		context.getBean(OwnerDao.class).updateValues();
	}
}
