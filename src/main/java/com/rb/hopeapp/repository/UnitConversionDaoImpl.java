package com.rb.hopeapp.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.rb.hopeapp.domain.UnitConversion;
import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.UnitConversionNameQueries;
import com.rb.hopeapp.exception.NoSuchNameException;


@Repository
public class UnitConversionDaoImpl extends
		HibernateDaoSupport implements UnitConversionDao {

	private static Logger logger = Logger.getLogger(UnitConversionDaoImpl.class);

	
	@Autowired
	public UnitConversionDaoImpl(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}


	public List<UnitConversion> getAllUnitConversion() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(this.getHibernateCallBack());
	}


	public UnitConversion saveUnitConversion(UnitConversion unitConversion) {
		// TODO Auto-generated method stub
		return null;
	}


	public UnitConversion findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public UnitConversion findByName(final String name) throws NoSuchNameException {
		return getHibernateTemplate().execute(new HibernateCallback<UnitConversion>() {

			public UnitConversion doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Criteria c  = session.createCriteria(UnitConversion.class);
				c.add(Restrictions.eq("name", name));
				List<UnitConversion> list = c.list();
				return (list.size() > 0 ? list.get(0) : null);
			}
		});
	}


	public boolean deleteUnitConversion(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private HibernateCallback<List<UnitConversion>> getHibernateCallBack() {
		return new HibernateCallback<List<UnitConversion>>() {

			public List<UnitConversion> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				Criteria c = arg0.createCriteria(UnitConversion.class);
				return c.list();
			}
		};
				
	}
	
	
//	public UnitConversionDaoImpl() {
//		setClazz(UnitConversion.class);
//	}
//
//	public List<UnitConversion> getAllUnitConversion() {
//		// TODO Auto-generated method stub
//		logger.info("entitymanager :" + entityManager);
//		List<UnitConversion> unitConverstions = findAll();
//		logger.info("unitConversion size :" + unitConverstions.size());
//		return unitConverstions;
//	}
//
//	public UnitConversion saveUnitConversion(UnitConversion unitConversion) {
//		if (unitConversion.getId() > 0) {
//			update(unitConversion);
//		}
//		else {
//			save(unitConversion);
//			
//		}
//		return unitConversion;
//	}
//
//	public UnitConversion findById(int id) {
//		// TODO Auto-generated method stub
//		return findOne(id);
//	}
//
//	public boolean deleteUnitConversion(int id) {
//		
//
//		return false;
//	}
//
//	public UnitConversion findByName(String name) throws NoSuchNameException {
//		UnitConversion unit = (UnitConversion) entityManager.createNamedQuery(UnitConversionNameQueries.FIND_BY_NAME)
//				.setParameter(NamedQueriesParam.SEARCH_NAME, name).getSingleResult();
//		return unit;
//	}

}
