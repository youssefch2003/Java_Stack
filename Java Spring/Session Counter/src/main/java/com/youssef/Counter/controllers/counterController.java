package com.youssef.Counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class counterController {
	@RequestMapping("/yourserver")
	public String index(HttpSession session ) {
		Integer counter = (Integer) session.getAttribute("counter");
		if (counter == null) {
			session.setAttribute("counter", 0);
		}else {
			session.setAttribute("counter", counter + 1);
		}
		
		return "index.jsp";
	}
	@RequestMapping("/yourserver/counter")
	public String index1(HttpSession session ) {
		  session.getAttribute("counter");
		return "viewss.jsp";
	}
	
}
