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
	    
	    CatalogFilter catalogFilterTemplateObj=catalogDAOObj.createCatalogFilterObj();
	    CatalogFilter catalogFilterOneObj=new CatalogFilter();
	    String[] filterEnabledOneObj=catalogFilterOneObj.getFilterEnabled();
	    filterEnabledOneObj=new String[2];
	    
	    ArrayList<Filter> filterArrayListOneObj=catalogFilterOneObj.getFilterObj();
	    String[] filterTypeValueOneObj=new String[4];
	    String[] filterDataValueOneObj=new String[5];
	    
	    //CatalogFilter catalogFilterClonedTemplateObj=(CatalogFilter) catalogFilterTemplateObj.clone();                 
	              JSONObject jsonMainObj=new JSONObject();
		
	
		
	    JSONObject catalogFilterJsonObj=new JSONObject(filter);
		String[] filterEnabledJsonObj=new String[2];
	    filterEnabledJsonObj[0]=(String)catalogFilterJsonObj.get("filterEnabled");
	    
	    
	    catalogFilterOneObj.setFilterEnabled(filterEnabledJsonObj);
		 
		if(filterEnabledJsonObj[0].equals("none")) {
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
		
		
		else if(filterEnabledJsonObj[0].equals("yes")) {
	    ArrayList<Filter> filterJsonObj=(ArrayList<Filter>) catalogFilterJsonObj.get("filterCriteria");
	    filterArrayListOneObj=filterJsonObj;
	    
	    /*
	    * assiging ArrayList of Filter objects of class CatalogFilter.
	    */
	    filterArrayListOneObj=filterJsonObj;
	    
	    
	    
	    
	    int i=0;
	    int j=0;
	    for(Object obj:filterJsonObj) {
	    	 LinkedHashMap fJsonObj=(LinkedHashMap)obj;
	         
	    	 System.out.println(fJsonObj.get("filterType"));
	    	 
	    // use below array in sql query.
	    	 
	    	 
	    	 filterTypeValueOneObj[i]=(String)fJsonObj.get("filterType");
	    	 i++;
	         ArrayList filterArrayListJsonObj=(ArrayList)fJsonObj.get("filterData");
	         Iterator itrObj=filterArrayListJsonObj.iterator();
	        
	         
	         
	         while(itrObj.hasNext()) {
	       //System.out.println("values entered in filterData are : "+itrObj.next());
	      
	      // use below array in sql query
	        	 
	        	 
	        	 filterDataValueOneObj[j]=(String)itrObj.next();
	        	 System.out.println("filterDataValueOneObj values are : "+filterDataValueOneObj[j]);
	        	// System.out.println(" j value : "+j);
	        j++;
	         }
	         
	         
	      
	         
	         
	    }
		
		}
		
		
		// code to get records from database using jdbcTemplate.
		
		JSONArray jsonarrayObj=new JSONArray();
		JSONObject jsonObj=null;
		Product productObj=new Product();
		// write jdbc code to retrive records from database.
	 System.out.println("JdbcTemplate object is: "+jdbcTemplate);
	 String query="select * from catalog where "+filterTypeValueOneObj[0]+"= '"+filterDataValueOneObj[0]+"' and "+filterTypeValueOneObj[1]+"= '"+filterDataValueOneObj[1]+"'";
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
		
		
		//System.out.println("exit from showMenu() method of class CatalogDAO");  
		//return jsonMainObj;
		        
	}
	
	
public CatalogFilter createCatalogFilterObj() {
	
	
	// created one Filter class object
	
  	Filter filterOneObj=new Filter();

	filterOneObj.setFilterType("catagerious");
    ArrayList alOneObj=new ArrayList();
	alOneObj.add("MEN");
	alOneObj.add("WOMEN");
	alOneObj.add("KIDS");
	filterOneObj.setFilterData(alOneObj);
	
	// created second Filter class object
	
	  	Filter filterTwoObj=new Filter();

		filterTwoObj.setFilterType("size");
	    ArrayList alTwoObj=new ArrayList();
		alTwoObj.add("m");
		alTwoObj.add("l");
		alTwoObj.add("s");
		alTwoObj.add("xl");
		alTwoObj.add("xs");
		filterTwoObj.setFilterData(alTwoObj);

		// created third Filter class object
		
	  	Filter filterThreeObj=new Filter();

		filterThreeObj.setFilterType("brand");
	    ArrayList alThreeObj=new ArrayList();
		alThreeObj.add("nike");
		alThreeObj.add("puma");
		alThreeObj.add("levis");
		filterThreeObj.setFilterData(alThreeObj);
		
       /*
        *  creating CatalogFilter class object. 
        */
		
		CatalogFilter catalogFilterObj=new CatalogFilter();
		
		String[] filterEnabledObj=new String[2];
		filterEnabledObj[0]="none";
		filterEnabledObj[1]="yes";
		
		catalogFilterObj.setFilterEnabled(filterEnabledObj);
		ArrayList filterCriteriaObj=new ArrayList();
		filterCriteriaObj.add(filterOneObj);
		filterCriteriaObj.add(filterTwoObj);
		filterCriteriaObj.add(filterThreeObj);
		
	return catalogFilterObj;  
}
	
}
