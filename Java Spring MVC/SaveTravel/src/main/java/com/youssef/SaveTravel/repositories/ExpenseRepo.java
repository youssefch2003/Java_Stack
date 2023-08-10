package com.youssef.SaveTravel.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.youssef.SaveTravel.models.Expense;

public interface ExpenseRepo extends CrudRepository<Expense, Long> {
	// Read All
		List<Expense> findAll();

		
}
