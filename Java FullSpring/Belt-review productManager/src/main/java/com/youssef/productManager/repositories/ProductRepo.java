package com.youssef.productManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youssef.productManager.models.Project;
@Repository
public interface ProductRepo extends CrudRepository<Project, Long> {
	// Read All
			List<Project> findAll();
}
