package no.vi.protogarage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CustomerTest
{
	/**
	 * Method under test: {@link Customer#addCar(Car)}
	 */
	@Test
	void testAddCar()
	{
		Customer customer = new Customer();
		customer.setCars(new ArrayList<>());
		customer.setName("Name");
		customer.setPhoneNr("4105551212");
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		customer.addCar(car);
		assertEquals(1, customer.getCars().size());
	}
	
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>default or parameterless constructor of {@link Customer}
	 *   <li>{@link Customer#setCars(List)}
	 *   <li>{@link Customer#setName(String)}
	 *   <li>{@link Customer#setPhoneNr(String)}
	 *   <li>{@link Customer#getCars()}
	 *   <li>{@link Customer#getId()}
	 *   <li>{@link Customer#getName()}
	 *   <li>{@link Customer#getPhoneNr()}
	 * </ul>
	 */
	@Test
	void testConstructor()
	{
		Customer actualCustomer = new Customer();
		ArrayList<Car> carList = new ArrayList<>();
		actualCustomer.setCars(carList);
		actualCustomer.setName("Name");
		actualCustomer.setPhoneNr("4105551212");
		assertSame(carList, actualCustomer.getCars());
		assertNull(actualCustomer.getId());
		assertEquals("Name", actualCustomer.getName());
		assertEquals("4105551212", actualCustomer.getPhoneNr());
	}
}

