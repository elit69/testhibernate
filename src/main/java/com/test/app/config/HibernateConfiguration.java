package com.test.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@ComponentScan({ "com.test" })
public class HibernateConfiguration {
 
   @Autowired
   private Environment env;
 
   @Bean
   public AnnotationSessionFactoryBean sessionFactory() {
      AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
      sessionFactory.setDataSource(restDataSource());
      sessionFactory.setPackagesToScan(new String[] { "com.test.app.entities" });
      sessionFactory.setHibernateProperties(hibernateProperties());
 
      return sessionFactory;
   }
 
   @Bean
   public DataSource restDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
      dataSource.setUrl(env.getProperty("jdbc.url"));
      dataSource.setUsername(env.getProperty("jdbc.user"));
      dataSource.setPassword(env.getProperty("jdbc.pass"));
 
      return dataSource;
   }
 
   @Bean
   public HibernateTransactionManager transactionManager() {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory().getObject());
 
      return txManager;
   }
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }
 
   private Properties hibernateProperties() {
       Properties properties = new Properties();
       properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
       properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
       properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
       return properties;        
   }
    
}