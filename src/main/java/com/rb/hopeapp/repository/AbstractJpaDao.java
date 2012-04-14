package com.rb.hopeapp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDao< K,T extends Serializable > {
	   
	   private Class< T > clazz;
	   
//	   @PersistenceContext
//	   EntityManager entityManager;
	   
	   public void setClazz( final Class< T > clazzToSet ){
	      this.clazz = clazzToSet;
	   }
	   
	   public T findOne( final K id ){
//	      return entityManager.find( clazz, id );
		   return null;
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List< T > findAll(){
//	      return entityManager.createQuery( "from " + clazz.getName() )
//	       .getResultList();
		   return null;
	   }
	   
	   public void save( T entity ){
//	      entityManager.persist( entity );
	   }
	   
	   public void update( T entity ){
//	      entityManager.merge( entity );
	   }
	   
	   public void delete(  T entity ){
//	      entityManager.remove( entity );
	   }
	   public void deleteById( K entityId ){
	      final T entity = findOne( entityId );
	      
//	      delete( entity );
	   }
	   public T getById(final K id) {
//		   return findOne(id);
		   return null;
	   }

	
	}
