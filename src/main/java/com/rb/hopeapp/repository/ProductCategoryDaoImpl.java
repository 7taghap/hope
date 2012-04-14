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

import com.rb.hopeapp.domain.ProductCategory;
import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.ProductCategoryNamedQueries;
import com.rb.hopeapp.exception.NoSuchNameException;

@Repository
public class ProductCategoryDaoImpl extends HibernateDaoSupport 
implements ProductCategoryDao{

	static Logger logger = Logger.getLogger(ProductCategoryDaoImpl.class);

	@Autowired
	public ProductCategoryDaoImpl(SessionFactory factory ) {
		 super.setSessionFactory(factory);
	}
	
	public ProductCategory findById(int id) {
		// TODO Auto-generated method stub
		return (ProductCategory) getHibernateTemplate().get(ProductCategory.class,id);
	}

	public ProductCategory findByName(final String name) throws NoSuchNameException {
		return getHibernateTemplate().execute(new HibernateCallback<ProductCategory>() {

			public ProductCategory doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria c = session.createCriteria(ProductCategory.class);
				 c.add(Restrictions.eq("categoryName", name));
				 List<ProductCategory> list = c.list();
				 
				return (list.size() > 0 ? list.get(0) : null);
			}
		});
	}

	public List<ProductCategory> getProductCategories() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<ProductCategory>>() {

			public List<ProductCategory> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Criteria c =  arg0.createCriteria(ProductCategory.class);
				return c.list();
			}
		});
	}

	public ProductCategory saveProductCategory(ProductCategory category) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteProductCategory(ProductCategory category) {
		// TODO Auto-generated method stub
		return false;
	}

//	public ProductCategoryDaoImpl() {
//		setClazz(ProductCategory.class);
//	}
//	public ProductCategory findById(int id) {
//		// TODO Auto-generated method stub
//		return findOne(id);
//	}
//
//
//	public List<ProductCategory> getProductCategories(){
//		return findAll();
//	}
//
//
//	public ProductCategory saveProductCategory(ProductCategory category) {
//		if (category.getProductCategoryId() > 0) {
//			update(category);
//		}
//		else {
//			save(category);
//		}
//		return category;
//	}
//
//
//	public boolean deleteProductCategory(ProductCategory category) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	public ProductCategory findByName(String name) throws NoSuchNameException {
//		ProductCategory category = (ProductCategory)entityManager.createNamedQuery(ProductCategoryNamedQueries.FIND_BY_NAME)
//				.setParameter(NamedQueriesParam.SEARCH_NAME, name).getSingleResult();
//		return category;
//	}

	
}
