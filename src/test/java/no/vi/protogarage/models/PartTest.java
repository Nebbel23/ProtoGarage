package no.vi.protogarage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PartTest
{
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link Part#Part(String, int)}
	 *   <li>{@link Part#setCost(int)}
	 *   <li>{@link Part#setName(String)}
	 *   <li>{@link Part#getCost()}
	 *   <li>{@link Part#getName()}
	 * </ul>
	 */
	@Test
	void testConstructor()
	{
		Part actualPart = new Part("Name", 1);
		actualPart.setCost(1);
		actualPart.setName("Name");
		assertEquals(1, actualPart.getCost());
		assertEquals("Name", actualPart.getName());
	}
}

