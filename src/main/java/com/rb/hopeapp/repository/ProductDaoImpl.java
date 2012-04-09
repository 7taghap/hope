package com.rb.hopeapp.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.ProductNameQueries;
import com.rb.hopeapp.exception.ProductNotSaveException;


@Repository
public class ProductDaoImpl extends AbstractJpaDao<Integer, Product> implements ProductDao {

	static Logger logger = Logger.getLogger(ProductDaoImpl.class);
	public ProductDaoImpl() {
		setClazz(Product.class);
	}
	
	public Product findById(int id) {
		
		return findOne(id);
	}
	
	@Transactional
	public Product saveProduct(Product product) throws ProductNotSaveException{
		try{
			logger.info("before saving product" + product.toString());
			if(product.getProductId() > 0) {
				update(product);
			}
			else {
				logger.info("saving product");
				
				save(product);
				logger.info("after save :" + product.getProductId());
//				entityManager.flush();
			}
		}catch(Exception e) {
			throw new ProductNotSaveException("failed to save product");
		}

		return product;
	}

	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Product> findByCategory(String category) {
		@SuppressWarnings("unchecked")
		List<Product> products = entityManager.createNamedQuery(ProductNameQueries.FIND_BY_CATEGORY)
				.setParameter(NamedQueriesParam.SEARCH_NAME, category).getResultList();
		logger.info("product size :" + products.size());
		return products;
	}

	public List<Product> findByName(String name) {
		@SuppressWarnings("unchecked")
		List<Product> products = entityManager.createNamedQuery(ProductNameQueries.FIND_BY_NAME)
				.setParameter(ProductNameQueries.PARAM_NAME, name).getResultList();
		return products;
	}

}