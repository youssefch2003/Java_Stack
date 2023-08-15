package com.youssef.productManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youssef.productManager.models.Project;
import com.youssef.productManager.repositories.ProductRepo;

@Service
public class ProjectServ {
	// === CRUD ===

			@Autowired
			private ProductRepo ProjectRepo ;

			// READ ALL
			public List<Project> allDojos(){
				return ProjectRepo.findAll();
			}

			// CREATE
			public Project createDojo(Project b) {
				return ProjectRepo.save(b);
			}

			// READ ONE
			public Project findDojo(Long id) {

				Optional<Project> maybeDojo = ProjectRepo.findById(id);
				if(maybeDojo.isPresent()) {
					return maybeDojo.get();
				}else {
					return null;
				}
			}

			// UPDATE 
			public Project updateDojo(Project b) {
				return ProjectRepo.save(b);
			}

			// DELETE
			public void deleteDojo(Long id) {
				ProjectRepo.deleteById(id);
			}
}
