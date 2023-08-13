package com.youssef.loginregistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.youssef.loginregistration.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {

	// Read All
		List<Ninja> findAll();
}
