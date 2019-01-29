package com.dm02tbdapp.controller;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm02tbdapp.bean.ProductOption;
import com.dm02tbdapp.bean.Report;
import com.dm02tbdapp.dao.CatalogDAO;
import com.dm02tbdapp.dao.CatalogProductDAO;
import com.dm02tbdapp.dao.FilterDAO;
import com.dm02tbdapp.dao.ImageDAO;
import com.dm02tbdapp.dao.ProductInfoDAO;


@Service
public class CatalogManager {

    @Autowired
    private CatalogProductDAO productObj;
    
    @Autowired
    private CatalogDAO catalogObj;
    
    @Autowired
    private ImageDAO imageObj;
    
    @Autowired
    private FilterDAO filterObj;
    
    @Autowired
    private ProductInfoDAO productInfoObj;
    
	public JSONObject catalogDetails(JSONObject filter) {
	
	System.out.println("entered into catalogDetails() method of class CatalogManager");
	JSONObject jsonObj=catalogObj.showMenu(filter);
	System.out.println("exit from catalogDetails() method of class CatalogManager");
    return jsonObj;
	
	}
	
    

    public JSONObject retriveProductDetails() {
    	JSONObject jsonObj=productObj.retriveProduct();
    	return jsonObj;
    }
    public String insertImg(String path) {
    	String image=imageObj.insertImage(path);
    	return image;
    }
    public Object displayImage(int id) {
    	Object image=imageObj.showImage(id);
    	return image;
    }
    public JSONObject sort(int min,int max,String name) {
    
    JSONObject jsonObj=filterObj.sort(min, max, name);
    	return jsonObj;
    }
    public ProductOption productInfo() {
    	
    	System.out.println("entered into catalogDetails() method of class CatalogManager");
    	ProductOption productOptionObj =productInfoObj.retrive();
    	System.out.println("exit from catalogDetails() method of class CatalogManager");
        return productOptionObj;
    	
    	}
	}
