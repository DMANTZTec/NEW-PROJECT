package com.dm_02_tbdapp.bean;

import java.util.ArrayList;
import java.util.HashMap;

public class CatalogFilter {

	
	String filterEnabled;
	Filter filterObj;
	HashMap<String,String> hm=filterObj.getFilterHashMap();

	public String getFilterEnabled() {
		return filterEnabled;
	}
	public void setFilterEnabled(String filterEnabled) {
		this.filterEnabled = filterEnabled;
	}
	public Filter getFilterObj() {
		return filterObj;
	}
	public void setFilterObj(Filter filterObj) {
		this.filterObj = filterObj;
	}
	public HashMap<String, String> getHm() {
		return hm;
	}
	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}
	
	
}
