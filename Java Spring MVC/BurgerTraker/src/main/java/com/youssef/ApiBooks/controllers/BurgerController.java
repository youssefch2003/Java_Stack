package com.youssef.ApiBooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.youssef.ApiBooks.models.Burger;
import com.youssef.ApiBooks.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	private BurgerService BurgerServ;
	
	@GetMapping("/")
	public String index(@ModelAttribute("burger") Burger burger,Model model) {
		List<Burger> allTheBurgers = BurgerServ.getAll();
		model.addAttribute("Burgers",allTheBurgers);
		return "index.jsp";
	}
	  @PostMapping("/process")
	    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result,Model m) {
	        if (result.hasErrors()) {
	        	List<Burger> allTheBurgers = BurgerServ.getAll();
	    		m.addAttribute("Burgers",allTheBurgers);
	        	return "index.jsp";
	        } else {
	        	BurgerServ.create(burger);
	            return "redirect:/";
	        }
	    }
	  
	// Display Route - Edit form
		
		@GetMapping("edit/{id}")
		public String editPage(@PathVariable("id") Long id, Model model) {
			
			// find that book with provided id
			Burger thisBerger = BurgerServ.findone(id);
			
			// pass thisBook to the jsp page 
			model.addAttribute("burger",thisBerger);
			
			return "edit.jsp";
		}
		
		@PutMapping("/{id}/edit")
		public String updateBook(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
			if (result.hasErrors()) {
				return "edit.jsp";
			} else {
				// if there are no errors update one
				BurgerServ.updateOne(burger);
				return "redirect:/";
			}
		}

		// DELETE
		
		@DeleteMapping("/destroy/{id}")
		public String delete(@PathVariable("id") Long id) {
			BurgerServ.deleteOne(id);
			return "redirect:/";
		}
		
}
