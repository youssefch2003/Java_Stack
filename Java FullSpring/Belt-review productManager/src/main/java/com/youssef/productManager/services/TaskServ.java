package com.youssef.productManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youssef.productManager.models.Project;
import com.youssef.productManager.models.Task;
import com.youssef.productManager.repositories.TaskRepo;


@Service
public class TaskServ {
	// === CRUD ===

				@Autowired
				private TaskRepo TaskRepo ;

				// READ ALL
				public List<Task> allTasks(){
					return TaskRepo.findAll();
				}

				// CREATE
				public Task create(Task b) {
					return TaskRepo.save(b);
				}
				// READ ONE
				public Task  findOne(Long id) {

					Optional<Task> maybeDojo = TaskRepo.findById(id);
					if(maybeDojo.isPresent()) {
						return maybeDojo.get();
					}else {
						return null;
					}
				}
//				find tasks by proj 
				
				public List<Task> findbyproject (Long id) {
					return TaskRepo.findByProjectId(id);
				}
}
