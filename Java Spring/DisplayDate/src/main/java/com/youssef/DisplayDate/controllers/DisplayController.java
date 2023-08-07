package com.youssef.DisplayDate.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DisplayController {
	@RequestMapping("/")
	public String display() {
		return "display.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date currentdate = new Date();
		model.addAttribute("currentdate",currentdate);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		 LocalDateTime currentDateTime = LocalDateTime.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		    String time = currentDateTime.format(formatter);
		    model.addAttribute("currenttime", time);
		    return "time.jsp";
	}
}
