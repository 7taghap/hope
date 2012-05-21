package com.rb.hopeapp.service;

import java.util.Date;
import java.util.List;

import com.rb.hopeapp.domain.Sale;
import com.rb.hopeapp.domain.SalesDtl;
import com.rb.hopeapp.exception.NoRecordFoundException;
import com.rb.hopeapp.exception.SaleNotSaveException;

public interface SalesService {

	public Sale saveSale(Sale sale) throws SaleNotSaveException;
	public Sale getSale(int id) throws NoRecordFoundException;
	public List<Sale> getAllSales();
	public List<SalesDtl> getAllSalesDetail();
	public List<SalesDtl> findSalesByCreatedBy(String createdBy) throws NoRecordFoundException;
	public List<SalesDtl> findSalesByDate(Date startDate, Date endDate) throws NoRecordFoundException;
	public List<SalesDtl> findSalesByItemName(String name) throws NoRecordFoundException;
}
