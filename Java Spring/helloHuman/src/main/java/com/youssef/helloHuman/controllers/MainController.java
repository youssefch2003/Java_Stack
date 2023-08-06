package com.youssef.helloHuman.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
      @RequestMapping
      public String Hello(@RequestParam(value="name", required=false) String name ,
    		  @RequestParam(value="lastName", required=false) String lastName ,
    		  @RequestParam(value="times", required=false) Integer times
    		  
    		  ) {
		if( name == null && lastName == null && times == null ) {
			return"Hello Human";
		}else {
			 String p = "hello" + name + lastName ;
		 ArrayList<String> tab = new ArrayList<String>();
		 for (int i = 0; i < times; i++) {
	            tab.add(p);
	        }
	
			return String.join("", tab);
    	  
		}
		
    	  
      }

}
