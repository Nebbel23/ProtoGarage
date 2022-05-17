package no.vi.protogarage.services;

import no.vi.protogarage.models.Customer;
import no.vi.protogarage.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
	@Autowired
	CustomerRepository repo;
	
	//region Get
	public List<Customer> getAllCustomers()
	{
		return repo.findAll();
	}
	
	public Customer getCustomerById(Long id)
	{
		return repo.findById(id).get();
	}
	//region
	
	//region Post
	public Customer addCustomer(Customer customer)
	{
		return repo.save(customer);
	}
	//endregion
	
	//region Put
	public Customer editCustomer(Long id, Customer c)
	{
		return repo.findById(id)
				.map(
						customer ->
						{
							customer.setName(c.getName());
							customer.setPhoneNr(c.getPhoneNr());
							customer.setCars(c.getCars());
							
							return repo.save(customer);
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
		repo.deleteById(id);
	}
	//endregion
}