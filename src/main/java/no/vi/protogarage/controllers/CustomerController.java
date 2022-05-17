package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Customer;
import no.vi.protogarage.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@RestController
@RequestMapping(PATH_PREFIX + "/customer")
public class CustomerController
{
	private final CustomerService service;
	
	@Autowired
	public CustomerController(CustomerService service)
	{
		this.service = service;
	}
	
	//region Get
	@GetMapping
	public List<Customer> getAllCustomers()
	{
		return service.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") Long id)
	{
		return service.getCustomerById(id);
	}
	//endregion
	
	//region Post
	@PostMapping("/")
	public void addCustomer(@RequestBody Customer customer)
	{
		service.addCustomer(customer);
	}
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	public void editCustomer(@RequestBody Customer customer, @PathVariable("id") Long id)
	{
		service.editCustomer(id, customer);
	}
	//endregion
	
	//region Delete
	public void deleteCustomer(Long id)
	{
		service.deleteCustomer(id);
	}
	//endregion
}