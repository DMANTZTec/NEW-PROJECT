package com.dm02tbdapp.dao;

import java.util.List;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dm02tbdapp.bean.Catalog;


@Repository
public class FilterDAO {
@Autowired
JdbcTemplate jdbcTemplate;

Logger logger = LoggerFactory.getLogger(LogoutUserDAO.class);


public JSONObject sort(int min,int max,String item_name) {
	logger.info("entered into sort() method of class FilterDAO ");
	JSONArray jsonarrayObj=new JSONArray();
	JSONObject jsonObj=null ;
	JSONObject jsonMainObj=new JSONObject();
	String sql="select * from catalog where item_price>? and item_price<? and item_name like ? ";
	 List list=jdbcTemplate.query(sql,new Object[] {min,max,item_name}, new FilterRowMapper());
	for(Object Obj:list) {
		Catalog catalogObj=(Catalog)Obj;
		jsonObj=new JSONObject();
		jsonObj.put("item_name", catalogObj.getItem_name());
		jsonObj.put("item_size", catalogObj.getItem_size());
		jsonObj.put("item_price", catalogObj.getItem_price());
		jsonObj.put("category", catalogObj.getCategory());
	 jsonarrayObj.put(jsonObj);
	}
	
	jsonMainObj.put("Catalog", jsonarrayObj);
	 return jsonMainObj;
}
}
