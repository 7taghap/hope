package com.rb.hopeapp.repository;

import com.rb.hopeapp.domain.User;


public interface UserDao {

	public User findById(int userId);
}
