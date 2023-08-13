package com.youssef.loginregistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.youssef.loginregistration.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long> {
	// Read All
		List<Dojo> findAll();
}
