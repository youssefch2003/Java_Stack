package com.youssef.loginregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.youssef.loginregistration.models.Ninja;
import com.youssef.loginregistration.services.DojoServices;
import com.youssef.loginregistration.services.NinjaServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private NinjaServices NinjaServ;
	
	@Autowired
	private DojoServices DojoServ;
	// DISPLAY ROUTE - FORM
			@GetMapping("/ninjas/new")
			public String create(@ModelAttribute("ninja") Ninja ninja ,Model model,HttpSession s) {
				
//				grab the user id from session 
				Long userId = (Long) s.getAttribute("user_id");
//				ROUTE GUARD
				if (userId == null ) {
					return "redirect:/login";
					
				}
				model.addAttribute("dojos", DojoServ.allDojos());
				
				return "createninja.jsp";
			}
	// ACTION ROUTE - Process Form
	@PostMapping("/process/ninja")
	public String createBook(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,Model m) {

				if (result.hasErrors()) {
					m.addAttribute("dojos", DojoServ.allDojos());
					return "createninja.jsp";
				} else {
					// save the book
					Ninja newNinja =  NinjaServ.create(ninja);

				return "redirect:/success";
				}
			
	
}
	
	}
