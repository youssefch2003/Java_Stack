package com.youssef.helloHuman.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/m/{action}/{dis}")
		    public String showLesson(@PathVariable("action") String action,
		    		@PathVariable("dis") String dis){
		    	return "Congratulations! You will soon" + action + " " + "to"+" "+ dis +"!";
		    }
	@RequestMapping("/diakichi/loto/{num}")
    public String showLesson(@PathVariable("num") Integer num){
		
		if( num % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		return "You have enjoyed the fruits of your labor but"
				+ " now is a great time to spend time with family and friends.";
    	
    }
		
    	  
      }


