package com.dm02tbdapp.bean;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class Filter {
    
    	ArrayList<Object> categories = new ArrayList<Object>();
		ArrayList<Object> size = new ArrayList<Object>();

    	
    	
    	
    	// setter & getter methods.

    	
    	public ArrayList<Object> getCategories() {
			return categories;
		}
		public void setCategories(ArrayList<Object> categories) {
			this.categories = categories;
		}
		public ArrayList<Object> getSize() {
			return size;
		}
		public void setSize(ArrayList<Object> size) {
			this.size = size;
		}

	
	
		
	}
