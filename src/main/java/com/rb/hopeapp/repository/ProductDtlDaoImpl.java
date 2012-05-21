package com.rb.hopeapp.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.rb.hopeapp.domain.ProductDtl;
import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.ProductNameQueries;
import com.rb.hopeapp.exception.NoRecordFoundException;

@Repository
public class ProductDtlDaoImpl extends AbstractJpaDao<Integer, ProductDtl> implements ProductDtlDao{

 static Logger logger = Logger.getLogger(ProductDtlDaoImpl.class);
	public ProductDtlDaoImpl() {
		setClazz(ProductDtl.class);
	}

	public ProductDtl findById(final int id) {
		// TODO Auto-generated method stub
		return findById(id);
	}

	public List<ProductDtl> findByCategory(final String category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductDtl> findByName(final String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(ProductDtl product) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<ProductDtl> findProductDtlsLike(String name) {
		name = "%"+name.toLowerCase()+"%";
		logger.info("name for like:" + name);
		@SuppressWarnings("unchecked")
		List<ProductDtl> products = entityManager.createNamedQuery(ProductNameQueries.FIND_DETAILS_LIKE_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, name).getResultList();
		return products;
	}

	public ProductDtl getProductWithHigherUnit(int productId,double factor)
			throws NoRecordFoundException {
		List<ProductDtl> productDtls = entityManager.createNamedQuery(ProductNameQueries.FIND_PRODUCT_DETAIL_WITH_HIGER_UNIT)
		.setParameter(NamedQueriesParam.SEARCH_ID, productId)
		.setParameter(NamedQueriesParam.SEARCH_UNIT_FACTOR, factor).getResultList();
		if (productDtls.size() > 0) {
			return productDtls.get(0);
		}
		else 
			return null;
	}
	
	

	

}
