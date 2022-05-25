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
import no.vi.protogarage.models.Reparation;
import no.vi.protogarage.repositories.ReparationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ReparationService.class})
@ExtendWith(SpringExtension.class)
class ReparationServiceTest
{
	@MockBean
	private ReparationRepository reparationRepository;
	
	@Autowired
	private ReparationService reparationService;
	
	/**
	 * Method under test: {@link ReparationService#getAllReparations()}
	 */
	@Test
	void testGetAllReparations()
	{
		ArrayList<Reparation> reparationList = new ArrayList<>();
		when(this.reparationRepository.findAll()).thenReturn(reparationList);
		List<Reparation> actualAllReparations = this.reparationService.getAllReparations();
		assertSame(reparationList, actualAllReparations);
		assertTrue(actualAllReparations.isEmpty());
		verify(this.reparationRepository).findAll();
	}
	
	/**
	 * Method under test: {@link ReparationService#getReparationById(Long)}
	 */
	@Test
	void testGetReparationById()
	{
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		Optional<Reparation> ofResult = Optional.of(reparation);
		when(this.reparationRepository.findById((Long) any())).thenReturn(ofResult);
		assertSame(reparation, this.reparationService.getReparationById(123L));
		verify(this.reparationRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link ReparationService#addReparation(Reparation)}
	 */
	@Test
	void testAddReparation()
	{
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		when(this.reparationRepository.save((Reparation) any())).thenReturn(reparation);
		
		Reparation reparation1 = new Reparation();
		reparation1.setDone(true);
		reparation1.setLabor(new ArrayList<>());
		reparation1.setName("Name");
		assertSame(reparation, this.reparationService.addReparation(reparation1));
		verify(this.reparationRepository).save((Reparation) any());
	}
	
	/**
	 * Method under test: {@link ReparationService#addLaborToReparation(Long, Labor)}
	 */
	@Test
	void testAddLaborToReparation()
	{
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		Optional<Reparation> ofResult = Optional.of(reparation);
		
		Reparation reparation1 = new Reparation();
		reparation1.setDone(true);
		reparation1.setLabor(new ArrayList<>());
		reparation1.setName("Name");
		when(this.reparationRepository.save((Reparation) any())).thenReturn(reparation1);
		when(this.reparationRepository.findById((Long) any())).thenReturn(ofResult);
		
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		
		Labor labor = new Labor();
		labor.addPart(part);
		labor.setCostPerHour(1);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(1);
		labor.setName("Name");
		assertSame(reparation1, this.reparationService.addLaborToReparation(123L, labor));
		verify(this.reparationRepository).save((Reparation) any());
		verify(this.reparationRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link ReparationService#editReparation(Long, Reparation)}
	 */
	@Test
	void testEditReparation()
	{
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		
		Reparation reparation1 = new Reparation();
		reparation1.setDone(true);
		reparation1.setLabor(new ArrayList<>());
		reparation1.setName("Name");
		Optional<Reparation> ofResult = Optional.of(reparation1);
		when(this.reparationRepository.save((Reparation) any())).thenReturn(reparation);
		when(this.reparationRepository.findById((Long) any())).thenReturn(ofResult);
		
		Reparation reparation2 = new Reparation();
		reparation2.setDone(true);
		reparation2.setLabor(new ArrayList<>());
		reparation2.setName("Name");
		assertSame(reparation, this.reparationService.editReparation(123L, reparation2));
		verify(this.reparationRepository).save((Reparation) any());
		verify(this.reparationRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link ReparationService#editReparation(Long, Reparation)}
	 */
	@Test
	void testEditReparation2()
	{
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		when(this.reparationRepository.save((Reparation) any())).thenReturn(reparation);
		when(this.reparationRepository.findById((Long) any())).thenReturn(Optional.empty());
		
		Reparation reparation1 = new Reparation();
		reparation1.setDone(true);
		reparation1.setLabor(new ArrayList<>());
		reparation1.setName("Name");
		assertSame(reparation, this.reparationService.editReparation(123L, reparation1));
		verify(this.reparationRepository).save((Reparation) any());
		verify(this.reparationRepository).findById((Long) any());
	}
	
	/**
	 * Method under test: {@link ReparationService#deleteReparation(Long)}
	 */
	@Test
	void testDeleteReparation()
	{
		doNothing().when(this.reparationRepository).deleteById((Long) any());
		this.reparationService.deleteReparation(123L);
		verify(this.reparationRepository).deleteById((Long) any());
		assertTrue(this.reparationService.getAllReparations().isEmpty());
	}
}