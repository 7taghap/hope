package com.rb.hopeapp.repository;

import java.io.Serializable;
import java.util.List;


public interface IRepositoryDao<T extends Serializable> {
	T findById(final int id);
	T save(T o);
	T update(T o);
	List<T> findByCategory(final String category);
	List<T> findByName(final String name);
	List<T> findAll();
	boolean remove(T entity);
}
