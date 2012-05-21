package com.rb.hopeapp.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.rb.hopeapp.domain.Sale;

@Repository
public class SalesDaoImpl extends AbstractJpaDao<Integer, Sale> implements SalesDao{

	
	public SalesDaoImpl() {
		setClazz(Sale.class);
	}
	
	public Sale findById(int id) {
		// TODO Auto-generated method stub
		return findById(id);
	}

	public List<Sale> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Sale> findByName(String name) {

		return findByName(name);
	}

	public boolean remove(Sale sale) {
		delete(sale);
		return true;
	}

}
