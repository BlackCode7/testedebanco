package com.testedebanco.bancodemonstracao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.testedebanco.bancodemonstracao.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

	Page<User> findByNameBetween(String name, Pageable pageable);
	
}
