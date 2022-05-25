package no.vi.protogarage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CarTest
{
	/**
	 * Method under test: {@link Car#addReparation(Reparation)}
	 */
	@Test
	void testAddReparation()
	{
		Car car = new Car();
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		car.addReparation(reparation);
		assertEquals(1, car.getReparations().size());
	}
	
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>default or parameterless constructor of {@link Car}
	 *   <li>{@link Car#setAtShop(boolean)}
	 *   <li>{@link Car#setExecuteStatus(boolean)}
	 *   <li>{@link Car#setPapersId(String)}
	 *   <li>{@link Car#setPayed(boolean)}
	 *   <li>{@link Car#setRegistration(String)}
	 *   <li>{@link Car#setReparations(List)}
	 *   <li>{@link Car#getPapersId()}
	 *   <li>{@link Car#getRegistration()}
	 *   <li>{@link Car#getReparations()}
	 *   <li>{@link Car#isAtShop()}
	 *   <li>{@link Car#isExecuteStatus()}
	 *   <li>{@link Car#isPayed()}
	 * </ul>
	 */
	@Test
	void testConstructor()
	{
		Car actualCar = new Car();
		actualCar.setAtShop(true);
		actualCar.setExecuteStatus(true);
		actualCar.setPapersId("42");
		actualCar.setPayed(true);
		actualCar.setRegistration("Registration");
		ArrayList<Reparation> reparationList = new ArrayList<>();
		actualCar.setReparations(reparationList);
		assertEquals("42", actualCar.getPapersId());
		assertEquals("Registration", actualCar.getRegistration());
		assertSame(reparationList, actualCar.getReparations());
		assertTrue(actualCar.isAtShop());
		assertTrue(actualCar.isExecuteStatus());
		assertTrue(actualCar.isPayed());
	}
}