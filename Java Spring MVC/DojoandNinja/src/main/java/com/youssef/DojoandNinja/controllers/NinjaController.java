package com.youssef.DojoandNinja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.youssef.DojoandNinja.models.Ninja;
import com.youssef.DojoandNinja.services.DojoServices;
import com.youssef.DojoandNinja.services.NinjaServices;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private NinjaServices NinjaServ;
	
	@Autowired
	private DojoServices DojoServ;
	// DISPLAY ROUTE - FORM
			@GetMapping("/ninjas/new")
			public String create(@ModelAttribute("ninja") Ninja ninja ,Model model) {
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
