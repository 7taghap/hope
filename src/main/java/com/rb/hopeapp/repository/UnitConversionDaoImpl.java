package com.rb.hopeapp.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.rb.hopeapp.domain.UnitConversion;
import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.UnitConversionNameQueries;
import com.rb.hopeapp.exception.NoSuchNameException;


@Repository
public class UnitConversionDaoImpl extends
		AbstractJpaDao<Integer, UnitConversion> implements UnitConversionDao {

	private static Logger logger = Logger.getLogger(UnitConversionDaoImpl.class);
	
	public UnitConversionDaoImpl() {
		setClazz(UnitConversion.class);
	}

	public List<UnitConversion> getAllUnitConversion() {
		// TODO Auto-generated method stub
		logger.info("entitymanager :" + entityManager);
		List<UnitConversion> unitConverstions = findAll();
		logger.info("unitConversion size :" + unitConverstions.size());
		return unitConverstions;
	}

	public UnitConversion saveUnitConversion(UnitConversion unitConversion) {
		if (unitConversion.getId() > 0) {
			update(unitConversion);
		}
		else {
			save(unitConversion);
			
		}
		return unitConversion;
	}

	public UnitConversion findById(int id) {
		// TODO Auto-generated method stub
		return findOne(id);
	}

	public boolean deleteUnitConversion(int id) {
		

		return false;
	}

	public UnitConversion findByName(String name) throws NoSuchNameException {
		UnitConversion unit = (UnitConversion) entityManager.createNamedQuery(UnitConversionNameQueries.FIND_BY_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, name).getSingleResult();
		return unit;
	}

}
