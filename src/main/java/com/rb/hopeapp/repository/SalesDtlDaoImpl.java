package com.rb.hopeapp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedQueries;

import org.springframework.stereotype.Repository;

import com.rb.hopeapp.domain.SalesDtl;
import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.SalesNamedQueries;
import com.rb.hopeapp.exception.NoRecordFoundException;

@Repository
public class SalesDtlDaoImpl extends AbstractJpaDao<Integer, SalesDtl> implements SalesDtlDao{

	public SalesDtl findById(int id) {
		return findById(id);
	}

	public List<SalesDtl> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SalesDtl> findByName(String name) {
		@SuppressWarnings("unchecked")
		List<SalesDtl> list = entityManager.createNamedQuery(SalesNamedQueries.FIND_DETAILS_BY_ITEM_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, name).getResultList();
		return list;
	}

	public boolean remove(SalesDtl entity) {
		delete(entity);
		return true;
	}

	public List<SalesDtl> findSalesDetailByCreatedBy(String createdBy)
			throws NoRecordFoundException {
		@SuppressWarnings("unchecked")
		List<SalesDtl> list = entityManager.createNamedQuery(SalesNamedQueries.FIND_DETAILS_BY_CREATED_BY)
				.setParameter(NamedQueriesParam.SEARCH_CREATED_BY, createdBy).getResultList();
		return list;
	}

	public List<SalesDtl> findSalesDetailByDate(Date startDate, Date endDate)
			throws NoRecordFoundException {
		@SuppressWarnings("unchecked")
		List<SalesDtl> list = entityManager.createNamedQuery(SalesNamedQueries.FIND_DETAILS_BY_DATE)
				.setParameter(NamedQueriesParam.SEARCH_START_DATE, startDate)
				.setParameter(NamedQueriesParam.SEARCH_END_DATE, endDate)
				.getResultList();
		return list;
	}

}
