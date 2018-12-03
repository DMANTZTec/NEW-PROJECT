package com.dm02tbdapp.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.dm02tbdapp.bean.Report;

@Repository
public class ImageDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	final static Logger logger = LogManager.getLogger(ImageDAO.class);
	public Report showImage(int id) {
		logger.info("entered into showImage() of class ImageDAO.");
		List persons=jdbcTemplate.query("select * from image where img_id=?",new Object[] {id},(resultSet,i)-> {
			return toReport(resultSet); 
		});
		System.out.println("no of images : "+persons.size());

		return (Report)persons.get(0);
	
	}
    
	
	public Report toReport(ResultSet resultSet) throws SQLException {
		Report report=new Report();
		BufferedImage bImage=null;
		File image=null;
		try {
		
	    report.setId(resultSet.getLong("img_id"));
	    report.setImg_title(resultSet.getString("img_title"));
	    Blob blob=resultSet.getBlob("img_data");
	    byte[] bytes=blob.getBytes(1,(int)blob.length());
	    ByteArrayInputStream bis= new ByteArrayInputStream(bytes);
	    
		bImage= ImageIO.read(bis);
	    System.out.println(" report.getImg_title() is: "+report.getImg_title());
	    image=new File(report.getImg_title());
	    //image.mkdir();
	    //image.createNewFile();
	    
	    ImageIO.write(bImage, "jpg",image);
	    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    report.setImg_data_new(image);
	    
	    
		return report;
	}
	
	
	public String insertImage(String name) {
		
	
	//System.out.println("hello this is insertImage() method."+jdbcTemplate);
		try {
		     String path="C:\\Users\\shashi\\Downloads\\img\\"+name;
			final File image= new File(path);
		    final InputStream imageIs=new FileInputStream(image);
		    LobHandler lobHandler= new DefaultLobHandler();
		    jdbcTemplate.update("insert into image (img_title,img_data) values(?,?)",
		    new Object[] {name, new SqlLobValue(imageIs, (int)image.length(), lobHandler),},
		    new int[] {Types.VARCHAR,Types.BLOB});
	}catch(DataAccessException e) {
		System.out.println("exception occured "+e.getMessage());
	}catch(FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "image";
	}
}
