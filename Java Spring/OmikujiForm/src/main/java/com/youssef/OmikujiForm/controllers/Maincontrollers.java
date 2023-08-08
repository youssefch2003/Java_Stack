package com.youssef.OmikujiForm.controllers;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
@Controller
public class Maincontrollers {
	 @GetMapping("/")
	 public String index() {
		 return "form.jsp";
	 }
	 @PostMapping("/process")
	 public String process(
			 @RequestParam(value="num") Integer number,
			 @RequestParam(value="city") String city,
			 @RequestParam(value="real") String real,
			 @RequestParam(value="hobby") String hobby,
			 @RequestParam(value="living") String living,
			 @RequestParam(value="nice") String nice,
			 HttpSession session
			 ) {
		 ArrayList<Object> userDataList = new ArrayList<>();
		 userDataList.add(String.valueOf(number));
		 userDataList.add(city);
		 userDataList.add(real);
		 userDataList.add(hobby);
		 userDataList.add(living);
		 userDataList.add(nice);
		 
		 session.setAttribute("userDataList", userDataList);
		 
		 
		 
		 return "redirect:/show";
		 
	 }
	 @GetMapping("/show")
	 public String show(HttpSession session) {
		 session.getAttribute("userDataList");
		 
		 return "show.jsp";
	 }
}
