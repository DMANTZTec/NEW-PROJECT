package com.dm02tbdapp.bean;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CatalogFilter implements Cloneable {

	String[] filterEnabled;

	ArrayList<Filter> filterObj;

	public String[] getFilterEnabled() {
		return filterEnabled;
	}

	public void setFilterEnabled(String[] filterEnabled) {
		this.filterEnabled = filterEnabled;
	}

	public ArrayList<Filter> getFilterObj() {
		return filterObj;
	}

	public void setFilterObj(ArrayList<Filter> filterObj) {
		this.filterObj = filterObj;
	}

	// Setters & Getters 
	
	
}
