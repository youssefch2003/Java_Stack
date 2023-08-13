package com.youssef.DojoandNinja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.youssef.DojoandNinja.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {

	// Read All
		List<Ninja> findAll();
}
