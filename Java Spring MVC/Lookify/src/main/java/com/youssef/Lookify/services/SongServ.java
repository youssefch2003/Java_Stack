package com.youssef.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youssef.Lookify.models.Song;
import com.youssef.Lookify.repositories.RepoSong;

@Service
public class SongServ {
	// === CRUD ===
	
	@Autowired
	private RepoSong RepoSong;
	
	// READ ALL
	public List<Song> allSongs(){
		return RepoSong.findAll();
	}
	
	// CREATE
	public Song createSong(Song b) {
		return RepoSong.save(b);
	}
	
	// READ ONE
	public Song findSong(Long id) {
		
		Optional<Song> maybeSong = RepoSong.findById(id);
		if(maybeSong.isPresent()) {
			return maybeSong.get();
		}else {
			return null;
		}
	}
	
	// UPDATE 
	public Song updateSong(Song b) {
		return RepoSong.save(b);
	}
	
	// DELETE
	public void deleteSong(Long id) {
		RepoSong.deleteById(id);
	}
	
	// FIND ONE BY NAME
	public List<Song> FindOnebyName(String artist){
		return RepoSong.findByArtist(artist);
		}
	// get Top 10 Songs By Rating Desc
    public List<Song> getTop10SongsByRatingDesc() {
        return RepoSong.findTop10ByOrderByRatingDesc();
    }
 // FIND ONE BY NAME
 	public Song findOne(Long id){
 		Optional<Song> maybeOne = RepoSong.findById(id);
		if(maybeOne.isPresent()) {
			return maybeOne.get();
		}else {
			return null;
		}
 		}
    
	
}