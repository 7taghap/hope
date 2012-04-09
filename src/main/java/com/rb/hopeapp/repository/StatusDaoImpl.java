package com.rb.hopeapp.repository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.domain.Status;
import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.StatusNamedQueries;
import com.rb.hopeapp.exception.NoSuchStatusException;


@Repository
public class StatusDaoImpl extends AbstractJpaDao<Integer, Status>implements StatusDao{

	static Logger logger = Logger.getLogger(StatusDaoImpl.class);
	
	public StatusDaoImpl() {
		setClazz(Status.class);
	}
	
	
	public Status getActive() throws NoSuchStatusException {
		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.ACTIVE).getSingleResult();
	}

	public Status getInActive() throws NoSuchStatusException {
		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.INACTIVE).getSingleResult();
	}

	public Status getDeleted() throws NoSuchStatusException {
		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.DELETED).getSingleResult();
	}

	public Status getOpen() throws NoSuchStatusException {
		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.OPEN).getSingleResult();
	}

	public Status getClose() throws NoSuchStatusException {
		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.CLOSED).getSingleResult();
	}

	public Status getPending() throws NoSuchStatusException {
		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.PENDING).getSingleResult();
	}

	public Status getArchived() throws NoSuchStatusException {
		return (Status)entityManager.createNamedQuery(StatusNamedQueries.FIND_BY_NAME)
				.setParameter(NamedQueriesParam.SEARCH_NAME, StatusNamedQueries.ARCHIVED).getSingleResult();
	}

	@Transactional
	public Status saveStatus(Status status) {
		try {
		save(status);
//			entityManager.persist(status);
//			entityManager.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		logger.info("status id :"+ status.getStatusId());
		
		return status;
	}

	
}
