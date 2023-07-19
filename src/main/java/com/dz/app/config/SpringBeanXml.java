package com.dz.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.dz.app.*" })
@PropertySource(value = { "classpath:database.properties" })
@EnableTransactionManagement
public class SpringBeanXml {

//	db properties
	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.url}")
	private String dbUrl;

	@Value("${jdbc.username}")
	private String dbUserName;

	@Value("${jdbc.password}")
	private String password;

//	hibernate properties
	@Value("${hibernate.dialect}")
	private String hbmDialectPropertyValue;

	@Value("${hibernate.show_sql}")
	private String hbmShowSqlPropertyValue;

	@Value("${hibernate.format_sql}")
	private String hbmFormatSqlPropertyValue;

	@Value("${hibernate.ddl}")
	private String hbmDdlAutoPropertyValue;

	@Bean("ds")
	public DataSource getDataSource() {
		System.out.println("driver class loaded.. ");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean("sf")
	public LocalSessionFactoryBean getSessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.dz.app.entity" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hbmDialectPropertyValue);
		properties.put("hibernate.show_sql", hbmShowSqlPropertyValue);
		properties.put("hibernate.format_sql", hbmFormatSqlPropertyValue);
		properties.put("hibernate.hbm2ddl.auto", hbmDdlAutoPropertyValue);
		return properties;
	}

	@Bean("hibernateTemplate")
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(getSessionFactory().getObject());
		return hibernateTemplate;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public ModelMapper ModelMapper() {
		return new ModelMapper();
	}

}
