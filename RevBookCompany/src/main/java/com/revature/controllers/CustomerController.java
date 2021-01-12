package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Customer;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	public List<Customer> allc = new ArrayList<Customer>();
	private int newId = 1;
	{
		allc.add(new Customer(newId++, "office Max"));
		allc.add(new Customer(newId++, "Local Government"));
	}
	
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAllCustomer(){
		
		return new ResponseEntity<List<Customer>>(this.allc, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable int id){
		for(Customer c : this.allc) {
			if(c.getId() == id) {
				return new ResponseEntity<Customer>(c, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Customer> saveNewCustomer(@RequestBody Customer c){
		c.setId(this.newId++);
		allc.add(c);
		return new ResponseEntity<Customer>(c, HttpStatus.CREATED);
	}
}
