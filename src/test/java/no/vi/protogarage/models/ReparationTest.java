package no.vi.protogarage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReparationTest
{
	/**
	 * Method under test: {@link Reparation#addLabor(Labor)}
	 */
	@Test
	void testAddLabor()
	{
		Reparation reparation = new Reparation();
		
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		
		Labor labor = new Labor();
		labor.addPart(part);
		labor.setCostPerHour(1);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(1);
		labor.setName("Name");
		reparation.addLabor(labor);
		assertEquals(1, reparation.getLabor().size());
	}
	
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link Reparation#Reparation(String)}
	 *   <li>{@link Reparation#setDone(boolean)}
	 *   <li>{@link Reparation#setLabor(List)}
	 *   <li>{@link Reparation#setName(String)}
	 *   <li>{@link Reparation#getLabor()}
	 *   <li>{@link Reparation#getName()}
	 *   <li>{@link Reparation#isDone()}
	 * </ul>
	 */
	@Test
	void testConstructor()
	{
		Reparation actualReparation = new Reparation("Name");
		actualReparation.setDone(true);
		ArrayList<Labor> laborList = new ArrayList<>();
		actualReparation.setLabor(laborList);
		actualReparation.setName("Name");
		assertSame(laborList, actualReparation.getLabor());
		assertEquals("Name", actualReparation.getName());
		assertTrue(actualReparation.isDone());
	}
	
	/**
	 * Method under test: {@link Reparation#getCost()}
	 */
	@Test
	void testGetCost()
	{
		assertEquals(0, (new Reparation()).getCost());
	}
	
	/**
	 * Method under test: {@link Reparation#getCost()}
	 */
	@Test
	void testGetCost2()
	{
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		
		Labor labor = new Labor();
		labor.addPart(part);
		labor.setCostPerHour(1);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(1);
		labor.setName("Name");
		
		Reparation reparation = new Reparation();
		reparation.addLabor(labor);
		assertEquals(1, reparation.getCost());
	}
}