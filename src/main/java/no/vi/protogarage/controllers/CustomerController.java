package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.Customer;
import no.vi.protogarage.models.Labor;
import no.vi.protogarage.models.Part;
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
	private CustomerController(CustomerService service)
	{
		this.service = service;
	}
	
	//region Get
	@GetMapping
	private List<Customer> getAllCustomers()
	{
		return service.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	private Customer getCustomerById(@PathVariable("id") Long id)
	{
		return service.getCustomerById(id);
	}
	//endregion
	
	//region Post
	@PostMapping("/")
	private void addCustomer(@RequestBody Customer customer)
	{
		service.addCustomer(customer);
	}
	
	@PostMapping("/{id}")
	private Customer addCarToCustomer(@PathVariable("id") Long id, @RequestBody Car car)
	{
		return service.addCarToCustomer(id, car);
	}
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	private void editCustomer(@RequestBody Customer customer, @PathVariable("id") Long id)
	{
		service.editCustomer(id, customer);
	}
	//endregion
	
	//region Delete
	private void deleteCustomer(Long id)
	{
		service.deleteCustomer(id);
	}
	//endregion
}