package com.rb.hopeapp.repository;

import java.io.Serializable;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.metamodel.Type;
public abstract class AbstractJpaDao< K,T extends Serializable > {
	   
	   private Class< T > clazz;
	   
	   
	   EntityManager entityManager;
	 
	   @PersistenceContext(unitName="MyPersistentUnit")
	   public void setEntityManager(EntityManager entityManager) {
		   this.entityManager = entityManager;
	   }
	   
	   public void setClazz( final Class< T > clazzToSet ){
	      this.clazz = clazzToSet;
	   }
	   
	   public T findOne( final K id ){
	      return entityManager.find( clazz, id );
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List< T > findAll(){
	      return entityManager.createQuery( "from " + clazz.getName() )
	       .getResultList();
	   }
	   
	   public void save( T entity ){
	      entityManager.persist( entity );

	   }
	   
	   public void update( T entity ){
	      entityManager.merge( entity );
	   }
	   
	   public void delete(  T entity ){
	      entityManager.remove( entity );
	   }
	   public void deleteById( K entityId ){
	      final T entity = findOne( entityId );
	      
	      delete( entity );
	   }
	   public T getById(final K id) {
		   return findOne(id);
	   }

	
	}
