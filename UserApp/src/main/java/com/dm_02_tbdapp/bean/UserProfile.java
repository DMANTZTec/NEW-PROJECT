package com.dm_02_tbdapp.bean;

import java.util.ArrayList;

public class UserProfile {

public String userId;
public Integer userKey;
public String profileKey;
public User user;
public String firstName;
public String lastName;
public Integer DOB;
public String gender;
public Integer age;
public String emailId;
public String mobileNumber;
public String altMobileNumber;
public String lastLoggedLocation;
public ArrayList shipAddressList;
public ArrayList billingAddressList;

// newly added feilds.

public String password;



public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public Integer getUserKey() {
	return userKey;
}
public void setUserKey(Integer userKey) {
	this.userKey = userKey;
}
public String getProfileKey() {
	return profileKey;
}
public void setProfileKey(String profileKey) {
	this.profileKey = profileKey;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Integer getDOB() {
	return DOB;
}
public void setDOB(Integer dOB) {
	DOB = dOB;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getAltMobileNumber() {
	return altMobileNumber;
}
public void setAltMobileNumber(String altMobileNumber) {
	this.altMobileNumber = altMobileNumber;
}
public String getLastLoggedLocation() {
	return lastLoggedLocation;
}
public void setLastLoggedLocation(String lastLoggedLocation) {
	this.lastLoggedLocation = lastLoggedLocation;
}
public ArrayList getShipAddressList() {
	return shipAddressList;
}
public void setShipAddressList(ArrayList shipAddressList) {
	this.shipAddressList = shipAddressList;
}
public ArrayList getBillingAddressList() {
	return billingAddressList;
}
public void setBillingAddressList(ArrayList billingAddressList) {
	this.billingAddressList = billingAddressList;
}

	
}
