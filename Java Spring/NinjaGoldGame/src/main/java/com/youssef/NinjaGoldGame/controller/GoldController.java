package com.youssef.NinjaGoldGame.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class GoldController {
	@GetMapping("/")
	public String index(HttpSession session) {
		 if (session.getAttribute("gold") == null) {
	            session.setAttribute("gold", 0);
	        }
		 if (session.getAttribute("activities") == null) {
	            session.setAttribute("activities", new ArrayList<String>());
	        }
		return "index.jsp";
	}
	@PostMapping("/process")
	public String process(HttpSession session, @RequestParam(value="action") String action) {
		int gold = (int) session.getAttribute("gold");
		@SuppressWarnings("unchecked")
		List<String> activities = (List<String>) session.getAttribute("activities");
		
		 int earnedGold = 0;
	     String activity = "";

		 if ("farm".equals(action)) {
	            earnedGold = (int) (Math.random() * 11) + 10;
	            activity = "Earned " + earnedGold + " gold from the farm.";
	        } else if ("cave".equals(action)) {
	            earnedGold = (int) (Math.random() * 6) + 5;
	            activity = "Found " + earnedGold + " gold in the cave.";
	        } else if ("house".equals(action)) {
	            earnedGold = (int) (Math.random() * 4) + 2;
	            activity = "Earned " + earnedGold + " gold from the house.";
	        } else if ("quest".equals(action)) {
	            earnedGold = (int) (Math.random() * 101) - 50;
	            if (earnedGold >= 0) {
	                activity = "Earned " + earnedGold + " gold on a quest.";
	            } else {
	                activity = "Lost " + Math.abs(earnedGold) + " gold on a quest.";
	            }
	        }
	
	     activities.add(0, "[" + LocalDateTime.now() + "] " + activity);

	     session.setAttribute("gold", gold += earnedGold);
	     session.setAttribute("activities", activities);

	       return "redirect:/";
		
		
		
	}

}
