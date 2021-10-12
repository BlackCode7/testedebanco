package com.testedebanco.bancodemonstracao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testedebanco.bancodemonstracao.entities.User;
import com.testedebanco.bancodemonstracao.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository repository; 

	// Aqui defini os caminhos da API
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
	    List<User> result = repository.findAll();
	    return ResponseEntity.ok(result);
	}
	
	// Aqui defini os caminhos da API
		@GetMapping(value="/page") // busca por página
		public ResponseEntity<Page<User>> findAll(Pageable pageable) {
		    Page<User> result = repository.findAll(pageable);
		    return ResponseEntity.ok(result);
		}
		
		// Aqui defini os caminhos da API
		@GetMapping(value="/search-salary") // busca por salario
		public ResponseEntity<Page<User>> searchBySalary(
				@RequestParam(defaultValue="0") Double minSalary, 
				@RequestParam(defaultValue = "1000000000") Double maxSalary, 
				Pageable pageable) {
		    Page<User> result = repository.findBySalaryBetween(minSalary, maxSalary, pageable);
		    return ResponseEntity.ok(result);
		}
		
		// Aqui defini os caminhos da API
			@GetMapping(value="/search-name") // busca por salario
			public ResponseEntity<Page<User>> searchByName(
					@RequestParam(defaultValue="0") String name, Pageable pageable) {
			    Page<User> result = repository.findByNameBetween(name,  pageable);
			    return ResponseEntity.ok(result);
			}
	
}
