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

import no.vi.protogarage.models.Labor;
import no.vi.protogarage.models.Part;
import no.vi.protogarage.repositories.LaborRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LaborService.class})
@ExtendWith(SpringExtension.class)
class LaborServiceTest
{
	@MockBean
	private LaborRepository laborRepository;
	
	@Autowired
	private LaborService laborService;
	
	/**
	 * Method under test: {@link LaborService#getAllLabor()}
	 */
	@Test
	void testGetAllLabor()
	{
		ArrayList<Labor> laborList = new ArrayList<>();
		when(this.laborRepository.findAll()).thenReturn(laborList);
		List<Labor> actualAllLabor = this.laborService.getAllLabor();
		assertSame(laborList, actualAllLabor);
		assertTrue(actualAllLabor.isEmpty());
		verify(this.laborRepository).findAll();
	}
	
	/**
	 * Method under test: {@link LaborService#getLaborById(Long)}
	 */
	@Test
	void testGetLaborById()
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
		Optional<Labor> ofResult = Optional.of(labor);
		when(this.laborRepository.findById((Long) any())).thenReturn(ofResult);
		assertSame(labor, this.laborService.getLaborById(123L));
		verify(this.laborRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link LaborService#addLabor(Labor)}
	 */
	@Test
	void testAddLabor()
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
		when(this.laborRepository.save((Labor) any())).thenReturn(labor);
		
		Part part1 = new Part();
		part1.setCost(1);
		part1.setName("Name");
		
		Labor labor1 = new Labor();
		labor1.addPart(part1);
		labor1.setCostPerHour(1);
		labor1.setDescription("The characteristics of someone or something");
		labor1.setDurationInMinutes(1);
		labor1.setName("Name");
		assertSame(labor, this.laborService.addLabor(labor1));
		verify(this.laborRepository).save((Labor) any());
	}
	
	/**
	 * Method under test: {@link LaborService#addPartToLabor(Long, Part)}
	 */
	@Test
	void testAddPartToLabor()
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
		Optional<Labor> ofResult = Optional.of(labor);
		
		Part part1 = new Part();
		part1.setCost(1);
		part1.setName("Name");
		
		Labor labor1 = new Labor();
		labor1.addPart(part1);
		labor1.setCostPerHour(1);
		labor1.setDescription("The characteristics of someone or something");
		labor1.setDurationInMinutes(1);
		labor1.setName("Name");
		when(this.laborRepository.save((Labor) any())).thenReturn(labor1);
		when(this.laborRepository.findById((Long) any())).thenReturn(ofResult);
		
		Part part2 = new Part();
		part2.setCost(1);
		part2.setName("Name");
		assertSame(labor1, this.laborService.addPartToLabor(123L, part2));
		verify(this.laborRepository).save((Labor) any());
		verify(this.laborRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link LaborService#editLabor(Long, Labor)}
	 */
	@Test
	void testEditLabor()
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
		
		Part part1 = new Part();
		part1.setCost(1);
		part1.setName("Name");
		
		Labor labor1 = new Labor();
		labor1.addPart(part1);
		labor1.setCostPerHour(1);
		labor1.setDescription("The characteristics of someone or something");
		labor1.setDurationInMinutes(1);
		labor1.setName("Name");
		Optional<Labor> ofResult = Optional.of(labor1);
		when(this.laborRepository.save((Labor) any())).thenReturn(labor);
		when(this.laborRepository.findById((Long) any())).thenReturn(ofResult);
		
		Part part2 = new Part();
		part2.setCost(1);
		part2.setName("Name");
		
		Labor labor2 = new Labor();
		labor2.addPart(part2);
		labor2.setCostPerHour(1);
		labor2.setDescription("The characteristics of someone or something");
		labor2.setDurationInMinutes(1);
		labor2.setName("Name");
		assertSame(labor, this.laborService.editLabor(123L, labor2));
		verify(this.laborRepository).save((Labor) any());
		verify(this.laborRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link LaborService#editLabor(Long, Labor)}
	 */
	@Test
	void testEditLabor2()
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
		when(this.laborRepository.save((Labor) any())).thenReturn(labor);
		when(this.laborRepository.findById((Long) any())).thenReturn(Optional.empty());
		
		Part part1 = new Part();
		part1.setCost(1);
		part1.setName("Name");
		
		Labor labor1 = new Labor();
		labor1.addPart(part1);
		labor1.setCostPerHour(1);
		labor1.setDescription("The characteristics of someone or something");
		labor1.setDurationInMinutes(1);
		labor1.setName("Name");
		assertSame(labor, this.laborService.editLabor(123L, labor1));
		verify(this.laborRepository).save((Labor) any());
		verify(this.laborRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link LaborService#deleteLabor(Long)}
	 */
	@Test
	void testDeleteLabor()
	{
		doNothing().when(this.laborRepository).deleteById((Long) any());
		this.laborService.deleteLabor(123L);
		verify(this.laborRepository).deleteById((Long) any());
		assertTrue(this.laborService.getAllLabor().isEmpty());
	}
}