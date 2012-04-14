package com.rb.hopeapp.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.ProductNameQueries;
import com.rb.hopeapp.exception.ProductNotSaveException;


@Repository
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	static Logger logger = Logger.getLogger(ProductDaoImpl.class);

	public ProductDaoImpl(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product saveProduct(Product product) throws ProductNotSaveException {
		getHibernateTemplate().saveOrUpdate(product);
		return product;
	}

	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//	public ProductDaoImpl() {
//		setClazz(Product.class);
//	}
//	
//	public Product findById(int id) {
//		
//		return findOne(id);
//	}
//	
//	@Transactional
//	public Product saveProduct(Product product) throws ProductNotSaveException{
//		try{
//			System.out.println("before saving product" + product.toString());
//			if(product.getProductId() > 0) {
//				update(product);
//			}
//			else {
//				System.out.println("saving product");
//				
//				save(product);
//				System.out.println("after save :" + product.getProductId());
////				entityManager.getTransaction().commit();
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//			throw new ProductNotSaveException();
//		}
//
//		return product;
//	}
//
//	public boolean deleteProduct(Product product) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public List<Product> findByCategory(String category) {
//		@SuppressWarnings("unchecked")
//		List<Product> products = entityManager.createNamedQuery(ProductNameQueries.FIND_BY_CATEGORY)
//				.setParameter(NamedQueriesParam.SEARCH_NAME, category).getResultList();
//		logger.info("product size :" + products.size());
//		return products;
//	}
//
//	public List<Product> findByName(String name) {
//		@SuppressWarnings("unchecked")
//		List<Product> products = entityManager.createNamedQuery(ProductNameQueries.FIND_BY_NAME)
//				.setParameter(ProductNameQueries.PARAM_NAME, name).getResultList();
//		return products;
//	}

}
