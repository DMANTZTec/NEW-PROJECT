package com.dm02tbdapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dm02tbdapp.bean.Catalog;

public class FilterRowMapper implements RowMapper<Catalog> {
	
		
		public Catalog mapRow(ResultSet rs,int row) throws SQLException {
			return new Catalog(rs.getString("item_name"),rs.getString("item_size"),rs.getDouble("item_price"),rs.getString("category"));
		}
	
}
