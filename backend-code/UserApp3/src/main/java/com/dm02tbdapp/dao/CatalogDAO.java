package com.dm02tbdapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.dm02tbdapp.bean.CatalogFilter;
import com.dm02tbdapp.bean.Filter;
import com.dm02tbdapp.bean.Product;




@Repository
public class CatalogDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	private Filter filterObj;
    @Autowired
	private CatalogFilter catalogFilterObj;
	
	public JSONObject showMenu(JSONObject filter) {
		System.out.println("entered into showMenu() method of class CatalogDAO");
					
	    CatalogDAO catalogDAOObj=new CatalogDAO();          
	    
	    // creating object of type class CatalogFilter.
	    
        // remove below comment and other comment . It is very importent.
	    
	    // CatalogFilter catalogFilterTemplateObj=catalogDAOObj.createCatalogFilterObj();
	    CatalogFilter catalogFilterOneObj=new CatalogFilter();
	    String[] filterEnabledOneObj=catalogFilterOneObj.getFilterEnabled();
	    filterEnabledOneObj=new String[2];
	    
	    // change 1 below line only
	    
	    Filter filterArrayListOneObj=catalogFilterOneObj.getFilterObj();
	    String[] filterTypeValueOneObj=new String[4];
	    String[] filterDataValueOneObj=new String[5];
	    
	    //CatalogFilter catalogFilterClonedTemplateObj=(CatalogFilter) catalogFilterTemplateObj.clone();                 
	              JSONObject jsonMainObj=new JSONObject();
		
	
		
	    JSONObject catalogFilterJsonObj=new JSONObject(filter);
		String[] filterEnabledJsonObj=new String[2];
	    filterEnabledJsonObj[0]=(String)catalogFilterJsonObj.get("filterEnabled");
	    
	    
	    catalogFilterOneObj.setFilterEnabled(filterEnabledJsonObj);
		 
		if(filterEnabledJsonObj[0].equals("False")) {
		JSONArray jsonarrayObj=new JSONArray();
		JSONObject jsonObj=null;
		Product productObj=new Product();
		// write jdbc code to retrive records from database.
	 System.out.println("JdbcTemplate object is: "+jdbcTemplate);
	 String query="select * from catalog";
	 List results=jdbcTemplate.queryForList(query);
	 for(Object result:results) {
		 LinkedCaseInsensitiveMap map=(LinkedCaseInsensitiveMap)result;
		 jsonObj=new JSONObject();
		 for (Object key : map.keySet()) {
			
	         System.out.print(key + " = " + map.get(key) + "; ");
	         
	         jsonObj.put(key, map.get(key));
		 }
		
		 jsonarrayObj.put(jsonObj);
		 
	     System.out.println();
	 }
	 jsonMainObj.put("Catogery",jsonarrayObj);
	 System.out.println(jsonarrayObj.toString());
 
      return jsonMainObj;
		}
		
	
		
		
		
		
		else if(filterEnabledJsonObj[0].equals("True")) {
	    LinkedHashMap filterJsonObj=(LinkedHashMap)catalogFilterJsonObj.get("filterCriteria");
	    Set filterKeys=filterJsonObj.keySet();
	    ArrayList filterCriteriaKeysObj=new ArrayList();
	    ArrayList filterCriteriaValuesObj=new ArrayList();
	    
	    
	    for(Object obj:filterKeys) {
	    	String s=(String)obj;
	    System.out.println("keys are : "+s);
	    filterCriteriaKeysObj.add(s);
	    filterCriteriaValuesObj.add(filterJsonObj.get(s));
	    }
	    System.out.println("keys are : "+filterCriteriaKeysObj.size());
	    System.out.println("values are : "+filterCriteriaValuesObj.size());
	    String[] filterArrayListKeys=new String[5];
	    int i=0;
	    for(Object o:filterCriteriaKeysObj) {
	    	filterArrayListKeys[i]=(String)o;
	    	i++;
	    }
	    ArrayList filterArrayList;
	    ArrayList categorieArrayListObj=null;
	    ArrayList sizeArrayListObj=null;
	    for(Object o:filterCriteriaValuesObj) {
	    	
	    	filterArrayList=new ArrayList();
	        filterArrayList=(ArrayList)o;
	    	System.out.println(filterArrayList);
	    if(filterArrayList.contains("MEN")||filterArrayList.contains("WOMEN")||filterArrayList.contains("KIDS")||(filterArrayList.isEmpty())) {
	    	categorieArrayListObj=new ArrayList();
	    	categorieArrayListObj=(ArrayList)filterArrayList.clone();
	      }
	    /*  Remove this comments use below code.
	    * 
	    * else if(filterArrayList.contains("xl")||filterArrayList.contains("l")||(filterArrayList.isEmpty())) {
	      sizeArrayListObj=new ArrayList();
	      sizeArrayListObj=(ArrayList)filterArrayList.clone();
	      }
	   */
	    }
	    //System.out.println("size class name"+sizeArrayListObj.size());
	    
	    // study from here. written on 20/12/2018.
	    
	    Object[] keys=filterKeys.toArray();
	    Object[] values=filterCriteriaValuesObj.toArray();
	    ArrayList categoryValueObj=null; 
	    ArrayList brandValueObj=null; 
	    	categoryValueObj=(ArrayList)filterJsonObj.get("categorie");
            brandValueObj=(ArrayList)filterJsonObj.get("brand");   	    
            Object[] brandValueArrayValueObj=null;
            Object[] categoryValueArrayValueObj=null;
            if(brandValueObj!=null)
            	brandValueArrayValueObj=brandValueObj.toArray();
	        if(categoryValueObj!=null)
	        	categoryValueArrayValueObj=categoryValueObj.toArray();
       
	    
        System.out.println("filter keys are : ");
	    for(Object o:keys) {
	    	System.out.println(o);
	    }
 	    System.out.println("filter values are : ");
 	   for(Object o:values) {
	    	System.out.println(o);
	    }
	    ArrayList val=null;
	    
	    // code for category filter.       
	    String sql=null;
	    
	    
	    for(int a=0;a<keys.length;a++) {
	    	
	    	
	    	if(keys[a].equals("categorie")) {
	            
	    		if(a==0)
	    		sql="select * from catalog where "+keys[a]+" in ('";
	       
	    		if(a==1)
	    		sql=sql+" and "+keys[a]+" in ('";
	    		
	    		if(categoryValueObj.isEmpty())
	       	sql=sql+"')";
	    int j=0;
	    int k=categoryValueArrayValueObj.length;
	    System.out.println("Array value size is in categorie : "+k);
	   
	    for(Object append:categoryValueArrayValueObj) {
	    	
	    	if(j<k) 
	    		sql=sql+categoryValueArrayValueObj[j]+"','";
	    	
	    	if(j==(k-1))
	    		sql=sql+categoryValueArrayValueObj[j]+"')";
	    		
	    		j++;
	    }
	    	}
	     if(keys[a].equals("brand")) {
	    	
	    if(a==1)
		     sql=sql+" and "+keys[a]+" in ('";
	    if(a==0)
	    	sql=sql="select * from catalog where "+keys[a]+" in ('";
	    
		     if(brandValueObj.isEmpty())
		    	 sql=sql+"')";
		    
		    int l=0;
		    int m=brandValueArrayValueObj.length;
		    System.out.println("Array value size is in brand : "+m);
		   
		    for(Object append:brandValueArrayValueObj) {
		    	
		    	if(l<m) 
		    		sql=sql+""+append+"','";
		    	
		    	if(l==(m-1))
		    		sql=sql+append+"')";
		    		
		    		l++;
		    }
		   
	    }
	     if(sql.contains("categorie in ('') and")) {
		    	sql=sql.replace("categorie in ('') and","");
		    	System.out.println("substring is : "+sql);
		        
		    }
		    if(sql.contains("brand in ('')")) {
		    System.out.println("entered brand");
		    	sql=sql.replace("and brand in ('')","");
		    	System.out.println("substring is : "+sql);
		    }
		    if(brandValueObj!=null & categoryValueObj!=null) {
		    if(brandValueObj.isEmpty() & categoryValueObj.isEmpty())
		    	sql="select * from catalog";
		     }
		    
	    }
		    
	    System.out.println("sql statement is : "+sql);
	    
	 // code to get records from database using jdbcTemplate.
		
	 		JSONArray jsonarrayObj=new JSONArray();
	 		JSONObject jsonObj=null;
	 		Product productObj=new Product();
	 		// write jdbc code to retrive records from database.
	 	 System.out.println("JdbcTemplate object is: "+jdbcTemplate);
	 	 String query="select * from catalog where "+filterTypeValueOneObj[0]+"= '"+filterDataValueOneObj[0]+"'";
	 	 List results=jdbcTemplate.queryForList(sql);
	 	 for(Object result:results) {
	 		 LinkedCaseInsensitiveMap map=(LinkedCaseInsensitiveMap)result;
	 		 jsonObj=new JSONObject();
	 		 for (Object key : map.keySet()) {
	 			
	 	         System.out.print(key + " = " + map.get(key) + "; ");
	 	         
	 	         jsonObj.put(key, map.get(key));
	 		 }
	 		
	 		 jsonarrayObj.put(jsonObj);
	 		 
	 	     System.out.println();
	 	 }
	 	 jsonMainObj.put("Catogery",jsonarrayObj);
	 	 System.out.println(jsonarrayObj.toString());
	  
	      
	 	
	 	 // return jsonMainObj;
	 		
	 		
	 		//System.out.println("exit from showMenu() method of class CatalogDAO");  
	 		//return jsonMainObj;
	 		        
		} 
		return jsonMainObj;
		}
}
