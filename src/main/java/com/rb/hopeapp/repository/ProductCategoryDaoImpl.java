package com.rb.hopeapp.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.rb.hopeapp.domain.ProductCategory;
import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.ProductCategoryNamedQueries;
import com.rb.hopeapp.exception.NoSuchNameException;

@Repository("productCategoryDao")
public class ProductCategoryDaoImpl extends AbstractJpaDao<Integer, ProductCategory> 
implements ProductCategoryDao{

	static Logger logger = Logger.getLogger(ProductCategoryDaoImpl.class);

	public ProductCategoryDaoImpl() {
		setClazz(ProductCategory.class);
	}
	public ProductCategory findById(int id) {
		// TODO Auto-generated method stub
		return findOne(id);
	}


	public List<ProductCategory> getProductCategories(){
		return findAll();
	}


	public ProductCategory saveProductCategory(ProductCategory category) {
		if (category.getProductCategoryId() > 0) {
			update(category);
		}
		else {
			save(category);
		}
		return category;
	}


	public boolean deleteProductCategory(ProductCategory category) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ProductCategory findByName(String name) throws NoSuchNameException {
		ProductCategory category = (ProductCategory)entityManager.createNamedQuery(ProductCategoryNamedQueries.FIND_BY_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, name).getSingleResult();
		return category;
	}

	
}
