package com.rb.hopeapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rb.hopeapp.domain.Status;
import com.rb.hopeapp.exception.NoSuchStatusException;
import com.rb.hopeapp.repository.StatusDao;
import com.rb.hopeapp.repository.UserDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
public class StatusDaoImplTest extends TestCase {

	@Autowired
	StatusDao statusDao;
	
//	@PersistenceContext(name="testPU", type=PersistenceContextType.TRANSACTION)
//	EntityManager entityManager;
	
	@Test
	public void saveStatus() throws NoSuchStatusException {
		Status status = new Status();
//		status.setStatusId(4);
		status.setStatusName("test");
		status.setCategory("default");
//		System.out.println("entity manager :"+ entityManager);
//		entityManager.persist(status);
//		entityManager.flush();
//		status = statusDao.getActive();
		System.out.println("status :" + status.toString());
		statusDao.saveStatus(status);
		System.out.println("status :" + status.toString());
	}
	
}
