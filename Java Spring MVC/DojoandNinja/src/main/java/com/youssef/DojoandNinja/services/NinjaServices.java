package com.youssef.DojoandNinja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youssef.DojoandNinja.models.Ninja;
import com.youssef.DojoandNinja.repositories.NinjaRepo;

@Service
public class NinjaServices {
	// === CRUD ===

			@Autowired
			private NinjaRepo NinjaRepo;

			// READ ALL
			public List<Ninja> allNinjas(){
				return NinjaRepo.findAll();
			}

			// CREATE
			public Ninja create(Ninja b) {
				return NinjaRepo.save(b);
			}

			// READ ONE
			public Ninja find(Long id) {

				Optional<Ninja> maybeDojo = NinjaRepo.findById(id);
				if(maybeDojo.isPresent()) {
					return maybeDojo.get();
				}else {
					return null;
				}
			}

			// UPDATE 
			public Ninja update(Ninja b) {
				return NinjaRepo.save(b);
			}

			// DELETE
			public void delete(Long id) {
				NinjaRepo.deleteById(id);
			}
}
