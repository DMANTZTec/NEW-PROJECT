package com.dm_02_tbdapp.bean;

import java.util.ArrayList;
import java.util.HashMap;

public class Filter {

	String filterType;
	
	String filterData;
	//ArrayList<Object> filterData= new ArrayList<Object>();
	HashMap<String,String> filterHashMap= new HashMap<String,String>();

	
	public HashMap<String, String> getFilterHashMap() {
		return filterHashMap;
	}
	public void setFilterHashMap(HashMap<String, String> filterHashMap) {
		this.filterHashMap = filterHashMap;
	}
	public String getFilterType() {
		return filterType;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	public String getFilterData() {
		return filterData;
	}
	public void setFilterData(String filterData) {
		this.filterData = filterData;
	}
}
