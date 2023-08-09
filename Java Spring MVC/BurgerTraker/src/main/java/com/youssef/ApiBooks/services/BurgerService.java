package com.youssef.ApiBooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youssef.ApiBooks.models.Burger;
import com.youssef.ApiBooks.repositories.BurgerRepo;

@Service
public class BurgerService {
@Autowired
private BurgerRepo BurgerRep;
//READ ALL
	public List<Burger> getAll(){
		return BurgerRep.findAll();
	}
	
	// CREATE
	public Burger create(Burger b) {
		return BurgerRep.save(b);
	}
	
	// READ ONE
	public Burger findone(Long id) {
		
		Optional<Burger> maybeBook = BurgerRep.findById(id);
		if(maybeBook.isPresent()) {
			return maybeBook.get();
		}else {
			return null;
		}
	}
	
	// UPDATE 
	public Burger updateOne(Burger b) {
		return BurgerRep.save(b);
	}
	
	// DELETE
	public void deleteOne(Long id) {
		BurgerRep.deleteById(id);
	}

}
