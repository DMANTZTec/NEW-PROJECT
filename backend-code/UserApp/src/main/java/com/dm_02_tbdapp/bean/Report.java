package com.dm_02_tbdapp.bean;

import java.awt.image.BufferedImage;
import java.io.File;

public class Report {
private long id;
private String img_title;
private byte[] img_data;
private File img_data_new;


public File getImg_data_new() {
	return img_data_new;
}
public void setImg_data_new(File img_data_new) {
	this.img_data_new = img_data_new;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getImg_title() {
	return img_title;
}
public void setImg_title(String img_title) {
	this.img_title = img_title;
}
public byte[] getImg_data() {
	return img_data;
}
public void setImg_data(byte[] bImage) {
	this.img_data = bImage;
}


}
