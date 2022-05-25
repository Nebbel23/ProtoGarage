package no.vi.protogarage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LaborTest
{
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link Labor#Labor(String, String, int)}
	 *   <li>{@link Labor#setCostPerHour(int)}
	 *   <li>{@link Labor#setDescription(String)}
	 *   <li>{@link Labor#setDurationInMinutes(int)}
	 *   <li>{@link Labor#setName(String)}
	 *   <li>{@link Labor#getCostPerHour()}
	 *   <li>{@link Labor#getDescription()}
	 *   <li>{@link Labor#getDurationInMinutes()}
	 *   <li>{@link Labor#getFixedPriceCost()}
	 *   <li>{@link Labor#getName()}
	 *   <li>{@link Labor#isFixedPrice()}
	 * </ul>
	 */
	@Test
	void testConstructor()
	{
		Labor actualLabor = new Labor("Name", "The characteristics of someone or something", 1);
		actualLabor.setCostPerHour(1);
		actualLabor.setDescription("The characteristics of someone or something");
		actualLabor.setDurationInMinutes(1);
		actualLabor.setName("Name");
		assertEquals(1, actualLabor.getCostPerHour());
		assertEquals("The characteristics of someone or something", actualLabor.getDescription());
		assertEquals(1, actualLabor.getDurationInMinutes());
		assertEquals(0, actualLabor.getFixedPriceCost());
		assertEquals("Name", actualLabor.getName());
		assertFalse(actualLabor.isFixedPrice());
	}
	
	/**
	 * Method under test: {@link Labor#setFixedPriceCost(int)}
	 */
	@Test
	void testSetFixedPriceCost()
	{
		Labor labor = new Labor();
		labor.setFixedPriceCost(1);
		assertTrue(labor.isFixedPrice());
		assertEquals(1, labor.getFixedPriceCost());
	}
	
	/**
	 * Method under test: {@link Labor#setFixedPriceCost(int)}
	 */
	@Test
	void testSetFixedPriceCost2()
	{
		Labor labor = new Labor();
		labor.setFixedPriceCost(0);
		assertFalse(labor.isFixedPrice());
		assertEquals(0, labor.getFixedPriceCost());
	}
	
	/**
	 * Method under test: {@link Labor#addPart(Part)}
	 */
	@Test
	void testAddPart()
	{
		Labor labor = new Labor();
		
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		labor.addPart(part);
		assertEquals(1, labor.getParts().size());
	}
	
	/**
	 * Method under test: {@link Labor#getCost()}
	 */
	@Test
	void testGetCost()
	{
		assertEquals(0, (new Labor()).getCost());
	}
}