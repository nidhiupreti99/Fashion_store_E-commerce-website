package ECommerce.config;

import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ECommerce.model.Category;
import ECommerce.model.Product;
import ECommerce.model.Supplier;
import ECommerce.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("ECommerce")

public class DBConfig {
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test5");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		
	  Properties hibernateProp = new Properties();	
	  hibernateProp.put("hibernate.hbm2ddl.auto", "update");
	  hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	   
	  LocalSessionFactoryBuilder localFactory = new LocalSessionFactoryBuilder(getH2DataSource());
	  localFactory.addProperties(hibernateProp);
	
	  
      localFactory.addAnnotatedClass(Category.class);	  
	  localFactory.addAnnotatedClass(Product.class);
	  localFactory.addAnnotatedClass(Supplier.class);
	  localFactory.addAnnotatedClass(UserDetail.class);
	  
	  System.out.println("---SessionFactory Object is created-----");
	  
	  return localFactory.buildSessionFactory();
	  
	}
	
	
	
	
	
	
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		System.out.println("---Transaction manager object created------");
		
		return new HibernateTransactionManager(sessionFactory);
		
	}
	 		

}
