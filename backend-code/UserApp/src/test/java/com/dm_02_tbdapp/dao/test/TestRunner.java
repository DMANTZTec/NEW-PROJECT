package com.dm_02_tbdapp.dao.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
public static void main(String... args) {
	Result result_obj=JUnitCore.runClasses(UserTestSuite.class);
	for(Failure failure:result_obj.getFailures())
		System.out.println(" "+failure.toString());
	System.out.println("All are successful:"+result_obj.wasSuccessful());
}	
}
