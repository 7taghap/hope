package com.rb.hopeapp.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.domain.Status;
import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.StatusNamedQueries;
import com.rb.hopeapp.exception.NoSuchStatusException;


@Repository
public class StatusDaoImpl extends HibernateDaoSupport implements StatusDao{

	static Logger logger = Logger.getLogger(StatusDaoImpl.class);
	
	public StatusDaoImpl(SessionFactory sessionFactory) {
//		setClazz(Status.class);
		super.setSessionFactory(sessionFactory);
	}
	
	
	public Status getActive() throws NoSuchStatusException {
//		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
//				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.ACTIVE).getSingleResult();
		return getHibernateTemplate().execute(this.getStatusByName(StatusNamedQueries.ACTIVE));
	}

	public Status getInActive() throws NoSuchStatusException {
//		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
//				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.INACTIVE).getSingleResult();
		return getHibernateTemplate().execute(this.getStatusByName(StatusNamedQueries.ACTIVE));
	}

	public Status getDeleted() throws NoSuchStatusException {
//		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
//				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.DELETED).getSingleResult();
		return getHibernateTemplate().execute(this.getStatusByName(StatusNamedQueries.ACTIVE));
	}

	public Status getOpen() throws NoSuchStatusException {
//		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
//				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.OPEN).getSingleResult();
		return getHibernateTemplate().execute(this.getStatusByName(StatusNamedQueries.ACTIVE));
	}

	public Status getClose() throws NoSuchStatusException {
//		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
//				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.CLOSED).getSingleResult();
		return getHibernateTemplate().execute(this.getStatusByName(StatusNamedQueries.ACTIVE));
	}

	public Status getPending() throws NoSuchStatusException {
//		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
//				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.PENDING).getSingleResult();
		return getHibernateTemplate().execute(this.getStatusByName(StatusNamedQueries.ACTIVE));
	}

	public Status getArchived() throws NoSuchStatusException {
//		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
//				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.ARCHIVED).getSingleResult();
		return getHibernateTemplate().execute(this.getStatusByName(StatusNamedQueries.ACTIVE));
	}

	@Transactional
	public Status saveStatus(Status status) {
		try {
//		save(status);
//			entityManager.persist(status);
//			entityManager.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		logger.info("status id :"+ status.getStatusId());
		
		return status;
	}
	
	private HibernateCallback<Status> getStatusByName(final String name) {
		return new HibernateCallback<Status>() {

			public Status doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Criteria c = arg0.createCriteria(Status.class);
				 c.add(Restrictions.eq("statusName", name));
				 List<Status> list = c.list();
				return (list.size() > 0 ? list.get(0) : null);
						
			}
		};
	}

	
}
