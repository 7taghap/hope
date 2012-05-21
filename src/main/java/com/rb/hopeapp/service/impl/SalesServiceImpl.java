package com.rb.hopeapp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.rb.hopeapp.domain.Sale;
import com.rb.hopeapp.domain.SalesDtl;
import com.rb.hopeapp.exception.NoRecordFoundException;
import com.rb.hopeapp.exception.SaleNotSaveException;
import com.rb.hopeapp.repository.SalesDao;
import com.rb.hopeapp.repository.SalesDtlDao;
import com.rb.hopeapp.service.SalesService;
import com.rb.hopeapp.util.AppUtil;

public class SalesServiceImpl implements SalesService {

	
	@Autowired
	SalesDao salesDao;
	
	@Autowired
	SalesDtlDao salesDtlDao;
	
	@Transactional
	public Sale saveSale(Sale sale) throws SaleNotSaveException {
		
		sale.setCreatedDate(AppUtil.getInstance().getCurrentDate());
		sale.setLastUpdatedDate(AppUtil.getInstance().getCurrentDate());
		sale.setCreatedBy(AppUtil.getInstance().getUser());
		sale.setLastUpdatedBy(AppUtil.getInstance().getUser());
		sale = salesDao.save(sale);
		return sale;
	}

	public Sale getSale(int id) throws NoRecordFoundException {
		
		return salesDao.findById(id);
	}

	public List<Sale> getAllSales() {
		// TODO Auto-generated method stub
		return salesDao.findAll();
	}

	public List<SalesDtl> getAllSalesDetail() {
		// TODO Auto-generated method stub
		return salesDtlDao.findAll();
	}

	public List<SalesDtl> findSalesByCreatedBy(String createdBy)
			throws NoRecordFoundException {
		return salesDtlDao.findSalesDetailByCreatedBy(createdBy);
	}

	public List<SalesDtl> findSalesByDate(Date startDate, Date endDate)
			throws NoRecordFoundException {
		return salesDtlDao.findSalesDetailByDate(startDate, endDate);
	}

	public List<SalesDtl> findSalesByItemName(String name)
			throws NoRecordFoundException {
		return salesDtlDao.findByName(name);
	}
	
	

}
