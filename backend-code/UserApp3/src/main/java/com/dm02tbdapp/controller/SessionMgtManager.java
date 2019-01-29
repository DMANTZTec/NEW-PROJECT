package com.dm02tbdapp.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service

public class SessionMgtManager {
	static Logger logger=LogManager.getLogger(SessionMgtManager.class);
public String sessionMgt(String userName,String pwd,HttpSession session) {
	
	return "we are in SessionMgtManager() class.";
}
}
