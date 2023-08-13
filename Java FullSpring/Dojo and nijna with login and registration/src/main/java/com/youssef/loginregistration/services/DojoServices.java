package com.youssef.loginregistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youssef.loginregistration.models.Dojo;
import com.youssef.loginregistration.repositories.DojoRepo;

@Service
public class DojoServices {
	// === CRUD ===

		@Autowired
		private DojoRepo DojoRepo;

		// READ ALL
		public List<Dojo> allDojos(){
			return DojoRepo.findAll();
		}

		// CREATE
		public Dojo createDojo(Dojo b) {
			return DojoRepo.save(b);
		}

		// READ ONE
		public Dojo findDojo(Long id) {

			Optional<Dojo> maybeDojo = DojoRepo.findById(id);
			if(maybeDojo.isPresent()) {
				return maybeDojo.get();
			}else {
				return null;
			}
		}

		// UPDATE 
		public Dojo updateDojo(Dojo b) {
			return DojoRepo.save(b);
		}

		// DELETE
		public void deleteDojo(Long id) {
			DojoRepo.deleteById(id);
		}
}
