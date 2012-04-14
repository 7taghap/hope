package com.rb.hopeapp.web;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.domain.ProductCategory;
import com.rb.hopeapp.domain.ProductDtl;
import com.rb.hopeapp.domain.Status;
import com.rb.hopeapp.domain.UnitConversion;
import com.rb.hopeapp.exception.NoSuchNameException;
import com.rb.hopeapp.repository.ProductCategoryDao;
import com.rb.hopeapp.repository.ProductCategoryDaoImpl;
import com.rb.hopeapp.repository.ProductDao;
import com.rb.hopeapp.repository.ProductDaoImpl;
import com.rb.hopeapp.repository.StatusDao;
import com.rb.hopeapp.repository.StatusDaoImpl;
import com.rb.hopeapp.repository.UnitConversionDao;
import com.rb.hopeapp.repository.UnitConversionDaoImpl;


/**
 * @EnableTransactionManagement Xml equivalent <bean id="transactionManager"
 *                              class=
 *                              "org.springframework.orm.jpa.JpaTransactionManager"
 *                              > <property name="entityManagerFactory"
 *                              ref="entityManagerFactory" />
 */

@Configuration
@EnableTransactionManagement
public class DefaultDaoConfig implements DaoConfig,
		TransactionManagementConfigurer {

	/**
	 * session factory 
	 * add entity classes since there is no persistence.xml defined
	 * @return
	 */
	@Bean
	public SessionFactory getSessionFactory() {
		return new AnnotationConfiguration().addAnnotatedClass(Product.class)
				.addAnnotatedClass(ProductDtl.class)
				.addAnnotatedClass(ProductCategory.class)
				.addAnnotatedClass(UnitConversion.class)
				.addAnnotatedClass(Status.class)
				.configure()
				.buildSessionFactory();
	}

	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new HibernateTransactionManager(getSessionFactory());
	}

	@Bean
	public ProductDao getProductDao() {
		return new ProductDaoImpl(getSessionFactory());
	}

	@Bean
	public ProductCategoryDao getProductCategoryDao() {
		// TODO Auto-generated method stub
		return new ProductCategoryDaoImpl(getSessionFactory());	}

	@Bean
	public UnitConversionDao getUnitConversionDao() {
		return new UnitConversionDaoImpl(getSessionFactory());
	}

	@Bean
	public StatusDao getStatusDao() {
		return new StatusDaoImpl(getSessionFactory());
	}

}
