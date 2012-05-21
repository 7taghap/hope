package com.rb.hopeapp.repository;

import java.util.List;

import com.rb.hopeapp.domain.ProductDtl;
import com.rb.hopeapp.exception.NoRecordFoundException;

public interface ProductDtlDao extends IRepositoryDao<ProductDtl> {

	List<ProductDtl> findProductDtlsLike(String name);
	ProductDtl getProductWithHigherUnit(int productId,double factor) throws NoRecordFoundException;
}
