package com.youssef.loginregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.youssef.loginregistration.models.Dojo;
import com.youssef.loginregistration.services.DojoServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	private DojoServices DojoServ;
	
	// DISPLAY ROUTE - FORM
		@GetMapping("/dojos/new")
		public String create(@ModelAttribute("dojo") Dojo dojo,HttpSession s) {
//			grab the user id from session 
			Long userId = (Long) s.getAttribute("user_id");
//			ROUTE GUARD
			if (userId == null ) {
				return "redirect:/login";
				
			}
			
			return "createdojo.jsp";
		}
		// ACTION ROUTE - Process Form
		@PostMapping("/process/dojo")
		public String createBook(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result,
								Model m) {

			if (result.hasErrors()) {
	
				return "createdojo.jsp";
			} else {
				// save the book
				Dojo newDojo =  DojoServ.createDojo(dojo);

			return "redirect:/success";
			}

		}
		// DISPLAY ROUTE - success page
				@GetMapping("/success")
				public String create() {
					
					return "success.jsp";
				}
		@GetMapping("/show/dojos/{id}")
		public String showDojo(@PathVariable("id") Long id, Model model) {
					model.addAttribute("dojos", DojoServ.findDojo(id));
					return "showninjas.jsp";
				}
				

}
