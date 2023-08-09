package com.youssef.ApiBooks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youssef.ApiBooks.models.Burger;
@Repository
public interface BurgerRepo extends CrudRepository<Burger, Long> {
	
	// Read all/get all
	List<Burger> findAll();

}
