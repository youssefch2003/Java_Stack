package com.youssef.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youssef.Lookify.models.Song;
@Repository
public interface RepoSong extends CrudRepository<Song, Long> {
	// Read All
			List<Song> findAll();
			
			List<Song> findByArtist(String artist);
			
			List<Song> findTop10ByOrderByRatingDesc();
			
			
}
