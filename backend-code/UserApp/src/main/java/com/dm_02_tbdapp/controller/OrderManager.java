package com.dm_02_tbdapp.controller;



import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm_02_tbdapp.dao.OrderClientImpl;

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
