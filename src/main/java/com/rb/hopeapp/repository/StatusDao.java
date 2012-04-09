package com.rb.hopeapp.repository;

import java.io.Serializable;

import com.rb.hopeapp.domain.Status;
import com.rb.hopeapp.exception.NoSuchStatusException;

public interface StatusDao extends Serializable {

	public Status getActive() throws NoSuchStatusException;
	public Status getInActive() throws NoSuchStatusException;
	public Status getDeleted() throws NoSuchStatusException;
	public Status getOpen() throws NoSuchStatusException;
	public Status getClose() throws NoSuchStatusException;
	public Status getPending() throws NoSuchStatusException;
	public Status getArchived() throws NoSuchStatusException;
	
	public Status saveStatus(Status status);
	
}
