package com.youssef.loginregistration.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youssef.loginregistration.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	// FIND USER BY EMAIL
    Optional<User> findByEmail(String email);

}
