package com.rb.hopeapp.repository;

import java.util.Date;
import java.util.List;

import com.rb.hopeapp.domain.SalesDtl;
import com.rb.hopeapp.exception.NoRecordFoundException;

public interface SalesDtlDao extends IRepositoryDao<SalesDtl>{

	public List<SalesDtl> findSalesDetailByCreatedBy(String createdBy) throws NoRecordFoundException;
	public List<SalesDtl> findSalesDetailByDate(Date startDate, Date endDate) throws NoRecordFoundException;
}
