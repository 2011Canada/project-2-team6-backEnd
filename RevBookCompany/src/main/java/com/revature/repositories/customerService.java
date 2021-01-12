package com.revature.repositories;

import java.util.List;

import com.revature.models.Customer;

public interface customerService {

	public List<Customer> findAllCustomer();
	public Customer findCustomerById(int id);
	public Customer saveCustomer(Customer c);
}
