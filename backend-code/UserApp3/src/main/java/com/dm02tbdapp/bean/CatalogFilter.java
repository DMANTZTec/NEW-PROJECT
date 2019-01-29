package com.dm02tbdapp.bean;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CatalogFilter {

	private Filter filterObj;
	private String[] filterEnabled;

	
	public Filter getFilterObj() {
		return filterObj;
	}
	public void setFilterObj(Filter filterObj) {
		this.filterObj = filterObj;
	}
	public String[] getFilterEnabled() {
		return filterEnabled;
	}
	public void setFilterEnabled(String[] filterEnabled) {
		this.filterEnabled = filterEnabled;
	}

	
}
