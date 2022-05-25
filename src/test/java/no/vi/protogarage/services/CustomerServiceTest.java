package no.vi.protogarage.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.Customer;
import no.vi.protogarage.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerService.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceTest
{
	@MockBean
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * Method under test: {@link CustomerService#getAllCustomers()}
	 */
	@Test
	void testGetAllCustomers()
	{
		ArrayList<Customer> customerList = new ArrayList<>();
		when(this.customerRepository.findAll()).thenReturn(customerList);
		List<Customer> actualAllCustomers = this.customerService.getAllCustomers();
		assertSame(customerList, actualAllCustomers);
		assertTrue(actualAllCustomers.isEmpty());
		verify(this.customerRepository).findAll();
	}
	
	/**
	 * Method under test: {@link CustomerService#getCustomerById(Long)}
	 */
	@Test
	void testGetCustomerById()
	{
		Customer customer = new Customer();
		customer.setCars(new ArrayList<>());
		customer.setName("Name");
		customer.setPhoneNr("4105551212");
		Optional<Customer> ofResult = Optional.of(customer);
		when(this.customerRepository.findById((Long) any())).thenReturn(ofResult);
		assertSame(customer, this.customerService.getCustomerById(123L));
		verify(this.customerRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CustomerService#addCustomer(Customer)}
	 */
	@Test
	void testAddCustomer()
	{
		Customer customer = new Customer();
		customer.setCars(new ArrayList<>());
		customer.setName("Name");
		customer.setPhoneNr("4105551212");
		when(this.customerRepository.save((Customer) any())).thenReturn(customer);
		
		Customer customer1 = new Customer();
		customer1.setCars(new ArrayList<>());
		customer1.setName("Name");
		customer1.setPhoneNr("4105551212");
		assertSame(customer, this.customerService.addCustomer(customer1));
		verify(this.customerRepository).save((Customer) any());
	}
	
	/**
	 * Method under test: {@link CustomerService#addCarToCustomer(Long, Car)}
	 */
	@Test
	void testAddCarToCustomer()
	{
		Customer customer = new Customer();
		customer.setCars(new ArrayList<>());
		customer.setName("Name");
		customer.setPhoneNr("4105551212");
		Optional<Customer> ofResult = Optional.of(customer);
		
		Customer customer1 = new Customer();
		customer1.setCars(new ArrayList<>());
		customer1.setName("Name");
		customer1.setPhoneNr("4105551212");
		when(this.customerRepository.save((Customer) any())).thenReturn(customer1);
		when(this.customerRepository.findById((Long) any())).thenReturn(ofResult);
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		assertSame(customer1, this.customerService.addCarToCustomer(123L, car));
		verify(this.customerRepository).save((Customer) any());
		verify(this.customerRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CustomerService#editCustomer(Long, Customer)}
	 */
	@Test
	void testEditCustomer()
	{
		Customer customer = new Customer();
		customer.setCars(new ArrayList<>());
		customer.setName("Name");
		customer.setPhoneNr("4105551212");
		
		Customer customer1 = new Customer();
		customer1.setCars(new ArrayList<>());
		customer1.setName("Name");
		customer1.setPhoneNr("4105551212");
		Optional<Customer> ofResult = Optional.of(customer1);
		when(this.customerRepository.save((Customer) any())).thenReturn(customer);
		when(this.customerRepository.findById((Long) any())).thenReturn(ofResult);
		
		Customer customer2 = new Customer();
		customer2.setCars(new ArrayList<>());
		customer2.setName("Name");
		customer2.setPhoneNr("4105551212");
		assertSame(customer, this.customerService.editCustomer(123L, customer2));
		verify(this.customerRepository).save((Customer) any());
		verify(this.customerRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CustomerService#editCustomer(Long, Customer)}
	 */
	@Test
	void testEditCustomer2()
	{
		Customer customer = new Customer();
		customer.setCars(new ArrayList<>());
		customer.setName("Name");
		customer.setPhoneNr("4105551212");
		when(this.customerRepository.save((Customer) any())).thenReturn(customer);
		when(this.customerRepository.findById((Long) any())).thenReturn(Optional.empty());
		
		Customer customer1 = new Customer();
		customer1.setCars(new ArrayList<>());
		customer1.setName("Name");
		customer1.setPhoneNr("4105551212");
		assertSame(customer, this.customerService.editCustomer(123L, customer1));
		verify(this.customerRepository).save((Customer) any());
		verify(this.customerRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link CustomerService#deleteCustomer(Long)}
	 */
	@Test
	void testDeleteCustomer()
	{
		doNothing().when(this.customerRepository).deleteById((Long) any());
		this.customerService.deleteCustomer(123L);
		verify(this.customerRepository).deleteById((Long) any());
		assertTrue(this.customerService.getAllCustomers().isEmpty());
	}
}