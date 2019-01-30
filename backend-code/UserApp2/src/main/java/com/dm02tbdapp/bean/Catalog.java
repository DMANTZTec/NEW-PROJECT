package com.dm02tbdapp.bean;

public class Catalog {
String item_name;
String item_size;
double item_price;
String category;
public Catalog() {
	
}
public Catalog(String item_name,String item_size,double item_price,String category) {
	this.item_name=item_name;
	this.item_size=item_size;
	this.item_price=item_price;
	this.category=category;
}
public String getItem_name() {
	return item_name;
}
public void setItem_name(String item_name) {
	this.item_name = item_name;
}
public String getItem_size() {
	return item_size;
}
public void setItem_size(String item_size) {
	this.item_size = item_size;
}
public double getItem_price() {
	return item_price;
}
public void setItem_price(double item_price) {
	this.item_price = item_price;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
 
}
