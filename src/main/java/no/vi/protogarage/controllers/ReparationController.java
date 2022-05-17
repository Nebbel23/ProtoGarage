package no.vi.protogarage.controllers;

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
	private final ReparationService service;
	
	@Autowired
	public ReparationController(ReparationService service)
	{
		this.service = service;
	}
	
	//region Get
	@GetMapping
	public List<Reparation> getAllReparations()
	{
		return service.getAllReparations();
	}
	
	@GetMapping("/{id}")
	public Reparation getReparationById(@PathVariable("id") Long id)
	{
		return service.getReparationById(id);
	}
	//endregion
	
	//region Post
	@PostMapping("/")
	private void addReparation(@RequestBody Reparation reparation)
	{
		service.addReparation(reparation);
	}
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	private void editReparation(@RequestBody Reparation reparation, @PathVariable("id") Long id)
	{
		service.editReparation(id, reparation);
	}
	//endregion
	
	//region Delete
	public void deleteReparation(Long id)
	{
		service.deleteReparation(id);
	}
	//endregion
}