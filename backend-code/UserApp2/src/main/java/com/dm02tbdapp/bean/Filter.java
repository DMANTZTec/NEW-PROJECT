package com.dm02tbdapp.bean;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class Filter {
    
    String filterType;
	
	ArrayList<String> filterData;	
	
	
	// setter & getter methods.
	
	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	public ArrayList<String> getFilterData() {
		return filterData;
	}

	public void setFilterData(ArrayList<String> filterData) {
		this.filterData = filterData;
	}

	
	}
