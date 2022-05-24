package no.vi.protogarage.services;

import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.Customer;
import no.vi.protogarage.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
	@Autowired
	CustomerRepository customerRepository;
	
	//region Get
	public List<Customer> getAllCustomers()
	{
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(Long id)
	{
		return customerRepository.findById(id).get();
	}
	//region
	
	//region Post
	public Customer addCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	public Customer addCarToCustomer(Long customerId, Car car)
	{
		Customer customer = customerRepository.findById(customerId).get();
		customer.addCar(car);
		return customerRepository.save(customer);
	}
	//endregion
	
	//region Put
	public Customer editCustomer(Long id, Customer c)
	{
		return customerRepository.findById(id)
				.map(
						customer ->
						{
							customer.setName(c.getName());
							customer.setPhoneNr(c.getPhoneNr());
							customer.setCars(c.getCars());
							
							return customerRepository.save(customer);
						}
				).orElseGet(() ->
						{
							return addCustomer(c);
						}
				);
	}
	//endregion
	
	//region Delete
	public void deleteCustomer(Long id)
	{
		customerRepository.deleteById(id);
	}
	//endregion
}