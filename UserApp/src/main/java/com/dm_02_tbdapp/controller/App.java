
package com.dm_02_tbdapp.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.dm_02_tbdapp.controller","com.dm_02_tbdapp.dao"})		
public class App 
{

    public static void main( String[] args )
    {
    	
    	SpringApplication.run(App.class, args);
    	
    }
}
