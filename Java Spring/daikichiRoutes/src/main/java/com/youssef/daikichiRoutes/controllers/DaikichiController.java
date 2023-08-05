package com.youssef.daikichiRoutes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	   @RequestMapping("/diakichi")
       public String hello() {
               return "Welcome!";
       }
	   @RequestMapping("/today")
       public String Today() {
               return "Today you will find luck in all your endeavors!!";
       }
	   @RequestMapping("/tommorow")
       public String Tommorow() {
               return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!'";
       }
}

	

