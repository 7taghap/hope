package com.rb.hopeapp.repository;

import java.util.List;

import com.rb.hopeapp.domain.UnitConversion;
import com.rb.hopeapp.exception.NoSuchNameException;


public interface UnitConversionDao {

	public List<UnitConversion> getAllUnitConversion();
	public UnitConversion saveUnitConversion(UnitConversion unitConversion);
	public UnitConversion findById(int id);
	public UnitConversion findByName(String name) throws NoSuchNameException;
	public boolean deleteUnitConversion(int id);
	
}
