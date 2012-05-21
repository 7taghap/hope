package com.rb.hopeapp.domain;

import java.io.Serializable;
import java.util.List;

public class AjaxResponse <T extends Serializable>{


	private Class<T> clazz;
	
	private List errors;
	
	private boolean hasErrors;
	

	private Object model;
	public void setModel(Object model) {
		this.model = model;
	}
	
	public Object getModel() {
		return this.model;
	}
	public void setClazz(Class<T> clazztoset) {
		this.clazz = clazztoset;
	}
	public List getErrors() {
		return errors;
	}

	public void setErrors(List errors) {
		this.errors = errors;
	}

	public void setHasErrors(boolean status) {
		this.hasErrors = status;
	}
	public boolean hasErrors() {
		return this.hasErrors;
	}


	
	
}
