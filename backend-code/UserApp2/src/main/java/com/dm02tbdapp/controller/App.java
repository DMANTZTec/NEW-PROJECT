
package com.dm02tbdapp.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.dm02tbdapp.controller","com.dm02tbdapp.dao","com.dm02tbdapp.bean"})		
public class App 
{

    public static void main( String[] args )
    {
    	
    	SpringApplication.run(App.class, args);
    	
    }
}
