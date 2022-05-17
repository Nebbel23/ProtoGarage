package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Labor;
import no.vi.protogarage.services.LaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@RestController
@RequestMapping(PATH_PREFIX + "/labor")
public class LaborController
{
	private final LaborService service;
	
	@Autowired
	public LaborController(LaborService service)
	{
		this.service = service;
	}
	
	//region Get
	@GetMapping
	public List<Labor> getAllLabor()
	{
		return service.getAllLabor();
	}
	
	@GetMapping("/{id}")
	public Labor getLaborById(@PathVariable("id") Long id)
	{
		return service.getLaborById(id);
	}
	//endregion
	
	//region Post
	@PostMapping("/")
	public void addLabor(@RequestBody Labor labor)
	{
		service.addLabor(labor);
	}
	
	@PostMapping("/{id}")
	//TODO addPartToLabor
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	public void editLabor(@RequestBody Labor labor, @PathVariable("id") Long id)
	{
		service.editLabor(id, labor);
	}
	//endregion
	
	//region Delete
	public void deleteLabor(Long id)
	{
		service.deleteLabor(id);
	}
	//endregion
}