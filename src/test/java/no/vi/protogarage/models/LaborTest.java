package no.vi.protogarage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LaborTest
{
	/**
	 * Method under test: {@link Labor#getCost()}
	 */
	@Test
	void testGetCost()
	{
		assertEquals(0, (new Labor()).getCost());
		assertEquals(0, (new Labor()).getCost());
	}
}

