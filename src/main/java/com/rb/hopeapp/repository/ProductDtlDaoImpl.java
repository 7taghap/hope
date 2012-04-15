package com.rb.hopeapp.repository;

import java.util.List;

import com.rb.hopeapp.domain.ProductDtl;

public class ProductDtlDaoImpl extends AbstractJpaDao<Integer, ProductDtl> implements ProductDtlDao{


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

	public boolean deleteProduct(ProductDtl product) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
