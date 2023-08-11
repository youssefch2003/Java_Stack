package com.youssef.Lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.youssef.Lookify.models.Song;
import com.youssef.Lookify.services.SongServ;

import jakarta.validation.Valid;
@Controller
public class SongController {
	@Autowired
	private SongServ SongServ;
	
	
//	display landing page
	@GetMapping("/")
	public String index() {
		
		return "landing.jsp";
	}
	
//	display the dashboard page
	
	@GetMapping("/dashboard")
	public String index(@ModelAttribute("search") Song Song,Model model) {
		List<Song> allTheSongs = SongServ.allSongs();
		model.addAttribute("Songs",allTheSongs);
		return "index.jsp";
	}
//	display create song form
	@GetMapping("/songs/new")
	public String add(@ModelAttribute("song") Song song,Model m) {
		
		return "addsong.jsp";
	}
	
	// ACTION ROUTE - Process Form
		@PostMapping("/process/create")
		public String createBook(@Valid @ModelAttribute("song") Song Song,Model m, BindingResult result) {
			
			if (result.hasErrors()) {
				return "addsong.jsp";
			} else {
				// save the song
			Song newSong = SongServ.createSong(Song);

			return "redirect:/dashboard";
			}
			
		}
		
//	Display==============search by name 
		@GetMapping("/search/{artist}")
		public String index(Model model,@PathVariable("artist") String title) {
		
			List<Song> allTheSongs = SongServ.FindOnebyName(title);
			model.addAttribute("Songs",allTheSongs);
			model.addAttribute("artist",title);
			return "search.jsp";
		}
		// ACTION ROUTE - Process Form
				@PostMapping("/process")
				public String createBook(@Valid @ModelAttribute("search") String Song, Model m, BindingResult result,
										@RequestParam("artist") String artist) {
					System.out.println(artist);
					if (result.hasErrors()) {
						List<Song> allTheSongs = SongServ.allSongs();
						m.addAttribute("Songs",allTheSongs);
						return "index.jsp";
					} 
					String link = "/search/" + artist;
					System.out.println(link);
					return "redirect:" + link;
				
					
				}
				
				@GetMapping("/songs/top-ten")
				public String index(Model model) {
					List<Song> allTheSongs = SongServ.getTop10SongsByRatingDesc();
					model.addAttribute("Songs",allTheSongs);
					return "top-ten.jsp";
				}
				
				
				
				// Display Route -Get one
				@GetMapping("/songs/{id}")
				public String GetOne(@PathVariable("id") Long id, Model model) {
					
					// find that book with provided id
					Song thisExpense = SongServ.findOne(id);
					
					// pass thisBook to the jsp page 
					model.addAttribute("songs",thisExpense);
					
					return "showone.jsp";
				}
}
