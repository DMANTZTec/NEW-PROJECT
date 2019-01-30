package com.dm02tbdapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.dm02tbdapp.bean.ProductColor;
import com.dm02tbdapp.bean.ProductOption;
import com.dm02tbdapp.bean.ProductSize;



@Repository

public class ProductInfoDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public ProductOption retrive() {
	 System.out.println("entered in retrive() method of class ProductInfoDAO.");
	 
	 // code to get records from database.
	 
	 String sql="select info_id,option1_name,option2_name,option1_value,option1_name,option2_value,available from product_info";
 	
	  List results=jdbcTemplate.queryForList(sql);
	  
	  Iterator itrObj=results.iterator();
	  
	  ProductColor obj=null;
	  ProductSize obj1=null;
	  ProductOption o=new ProductOption();
	  ArrayList al_color=new ArrayList();
	  ArrayList al_size=new ArrayList();
	  LinkedCaseInsensitiveMap pObj=null;
	  
	  while(itrObj.hasNext()) {
	  
	  pObj=(LinkedCaseInsensitiveMap)itrObj.next();
	  //System.out.println(" in iterator objects "+pObj);
	  obj=new ProductColor();
	 obj.setAvailable(pObj.get("available"));
	 obj.setColor(pObj.get("option2_value"));
	 
	 
	 
	 obj1=new ProductSize();
	 obj1.setAvailable(pObj.get("available"));
	 obj1.setSize(pObj.get("option1_value"));
	 
	 
    
    al_color.add(obj);
    
    al_size.add(obj1);
    
   
   o.setColor(al_color);
   o.setSize(al_size);
	  
	  }
	
	 
	 
	 System.out.println("leaved from retrive() method of class ProductInfoDAO.");	
	 return o;
	}
	
}
