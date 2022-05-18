package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Labor;
import no.vi.protogarage.models.Part;
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
	private LaborController(LaborService service)
	{
		this.service = service;
	}
	
	//region Get
	@GetMapping
	private List<Labor> getAllLabor()
	{
		return service.getAllLabor();
	}
	
	@GetMapping("/{id}")
	private Labor getLaborById(@PathVariable("id") Long id)
	{
		return service.getLaborById(id);
	}
	//endregion
	
	//region Post
	@PostMapping("/")
	private Labor addLabor(@RequestBody Labor labor)
	{
		return service.addLabor(labor);
	}
	
	@PostMapping("/{id}")
	private Labor addPartToLabor(@PathVariable("id") Long id, @RequestBody Part part)
	{
		return service.addPartToLabor(id, part);
	}
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	private void editLabor(@RequestBody Labor labor, @PathVariable("id") Long id)
	{
		service.editLabor(id, labor);
	}
	//endregion
	
	//region Delete
	private void deleteLabor(Long id)
	{
		service.deleteLabor(id);
	}
	//endregion
}