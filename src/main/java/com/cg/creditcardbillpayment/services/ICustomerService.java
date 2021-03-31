package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);

	public Customer removeCustomer(long custId);

	public Customer updateCustomer(long custId, Customer customer);

	public Customer getCustomer(long custId);

	public List<Customer> getAllCustomers();
}
