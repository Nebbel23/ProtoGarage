package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.Customer;
import no.vi.protogarage.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@RestController
@RequestMapping(PATH_PREFIX + "/customer")
public class CustomerController
{
	private final CustomerService customerService;
	
	@Autowired
	private CustomerController(CustomerService customerService)
	{
		this.customerService = customerService;
	}
	
	//region Get
	@GetMapping
	private List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	private Customer getCustomerById(@PathVariable("id") Long id)
	{
		return customerService.getCustomerById(id);
	}
	//endregion
	
	//region Post
	@PostMapping
	private void addCustomer(@RequestBody Customer customer)
	{
		customerService.addCustomer(customer);
	}
	
	@PostMapping("/{id}")
	private Customer addCarToCustomer(@PathVariable("id") Long id, @RequestBody Car car)
	{
		return customerService.addCarToCustomer(id, car);
	}
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	private void editCustomer(@RequestBody Customer customer, @PathVariable("id") Long id)
	{
		customerService.editCustomer(id, customer);
	}
	//endregion
	
	//region Delete
	@DeleteMapping("/{id}")
	private void deleteCustomer(@PathVariable("id") Long id)
	{
		customerService.deleteCustomer(id);
	}
	//endregion
}