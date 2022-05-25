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

import no.vi.protogarage.models.Part;
import no.vi.protogarage.repositories.PartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PartService.class})
@ExtendWith(SpringExtension.class)
class PartServiceTest
{
	@MockBean
	private PartRepository partRepository;
	
	@Autowired
	private PartService partService;
	
	/**
	 * Method under test: {@link PartService#getAllParts()}
	 */
	@Test
	void testGetAllParts()
	{
		ArrayList<Part> partList = new ArrayList<>();
		when(this.partRepository.findAll()).thenReturn(partList);
		List<Part> actualAllParts = this.partService.getAllParts();
		assertSame(partList, actualAllParts);
		assertTrue(actualAllParts.isEmpty());
		verify(this.partRepository).findAll();
	}
	
	/**
	 * Method under test: {@link PartService#getPartById(Long)}
	 */
	@Test
	void testGetPartById()
	{
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		Optional<Part> ofResult = Optional.of(part);
		when(this.partRepository.findById((Long) any())).thenReturn(ofResult);
		assertSame(part, this.partService.getPartById(123L));
		verify(this.partRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link PartService#addPart(Part)}
	 */
	@Test
	void testAddPart()
	{
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		when(this.partRepository.save((Part) any())).thenReturn(part);
		
		Part part1 = new Part();
		part1.setCost(1);
		part1.setName("Name");
		assertSame(part, this.partService.addPart(part1));
		verify(this.partRepository).save((Part) any());
	}
	
	/**
	 * Method under test: {@link PartService#editPart(Long, Part)}
	 */
	@Test
	void testEditPart()
	{
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		
		Part part1 = new Part();
		part1.setCost(1);
		part1.setName("Name");
		Optional<Part> ofResult = Optional.of(part1);
		when(this.partRepository.save((Part) any())).thenReturn(part);
		when(this.partRepository.findById((Long) any())).thenReturn(ofResult);
		
		Part part2 = new Part();
		part2.setCost(1);
		part2.setName("Name");
		assertSame(part, this.partService.editPart(123L, part2));
		verify(this.partRepository).save((Part) any());
		verify(this.partRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link PartService#editPart(Long, Part)}
	 */
	@Test
	void testEditPart2()
	{
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		when(this.partRepository.save((Part) any())).thenReturn(part);
		when(this.partRepository.findById((Long) any())).thenReturn(Optional.empty());
		
		Part part1 = new Part();
		part1.setCost(1);
		part1.setName("Name");
		assertSame(part, this.partService.editPart(123L, part1));
		verify(this.partRepository).save((Part) any());
		verify(this.partRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link PartService#deletePart(Long)}
	 */
	@Test
	void testDeletePart()
	{
		doNothing().when(this.partRepository).deleteById((Long) any());
		this.partService.deletePart(123L);
		verify(this.partRepository).deleteById((Long) any());
		assertTrue(this.partService.getAllParts().isEmpty());
	}
}