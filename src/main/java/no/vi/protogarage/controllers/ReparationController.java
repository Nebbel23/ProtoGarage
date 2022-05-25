package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Labor;
import no.vi.protogarage.models.Reparation;
import no.vi.protogarage.services.ReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@RestController
@RequestMapping(PATH_PREFIX + "/reparation")
public class ReparationController
{
	private final ReparationService reparationService;
	
	@Autowired
	private ReparationController(ReparationService reparationService)
	{
		this.reparationService = reparationService;
	}
	
	//region Get
	@GetMapping
	private List<Reparation> getAllReparations()
	{
		return reparationService.getAllReparations();
	}
	
	@GetMapping("/{id}")
	private Reparation getReparationById(@PathVariable("id") Long id)
	{
		return reparationService.getReparationById(id);
	}
	//endregion
	
	//region Post
	@PostMapping
	private void addReparation(@RequestBody Reparation reparation)
	{
		reparationService.addReparation(reparation);
	}
	
	@PostMapping("/{id}")
	private Reparation addLaborToReparation(@PathVariable("id") Long id, @RequestBody Labor labor)
	{
		return reparationService.addLaborToReparation(id, labor);
	}
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	private void editReparation(@RequestBody Reparation reparation, @PathVariable("id") Long id)
	{
		reparationService.editReparation(id, reparation);
	}
	//endregion
	
	//region Delete
	@DeleteMapping("/{id}")
	private void deleteReparation(@PathVariable("id") Long id)
	{
		reparationService.deleteReparation(id);
	}
	//endregion
}