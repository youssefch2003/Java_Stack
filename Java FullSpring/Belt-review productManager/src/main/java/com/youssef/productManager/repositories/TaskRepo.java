package com.youssef.productManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youssef.productManager.models.Task;
@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
	// Read All
				List<Task> findAll();
				
				List<Task> findByProjectId(Long id);
}
