package com.dm02tbdapp.controller;



import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm02tbdapp.dao.OrderClientImpl;

@Service
public class OrderManager {
	
	@Autowired
	 OrderClientImpl orderClientObj;
	public JSONObject display() {
		
		JSONObject jsonObj=orderClientObj.showCatalog();
		return jsonObj;
	}
    
	public JSONObject orderClient() {
		
		JSONObject jsonObj=orderClientObj.order();
		return jsonObj;
	}

}
