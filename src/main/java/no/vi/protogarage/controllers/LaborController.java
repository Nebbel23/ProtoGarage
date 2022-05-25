package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Labor;
import no.vi.protogarage.models.Part;
import no.vi.protogarage.services.LaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@RestController
@RequestMapping(PATH_PREFIX + "/labor")
public class LaborController
{
	private final LaborService laborService;
	
	@Autowired
	private LaborController(LaborService laborService)
	{
		this.laborService = laborService;
	}
	
	//region Get
	@GetMapping
	private List<Labor> getAllLabor()
	{
		return laborService.getAllLabor();
	}
	
	@GetMapping("/{id}")
	private Labor getLaborById(@PathVariable("id") Long id)
	{
		return laborService.getLaborById(id);
	}
	//endregion
	
	//region Post
	@PostMapping
	private Labor addLabor(@RequestBody Labor labor)
	{
		return laborService.addLabor(labor);
	}
	
	@PostMapping("/{id}")
	private Labor addPartToLabor(@PathVariable("id") Long id, @RequestBody Part part)
	{
		return laborService.addPartToLabor(id, part);
	}
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	private void editLabor(@RequestBody Labor labor, @PathVariable("id") Long id)
	{
		laborService.editLabor(id, labor);
	}
	//endregion
	
	//region Delete
	@DeleteMapping("/{id}")
	private void deleteLabor(@PathVariable("id") Long id)
	{
		laborService.deleteLabor(id);
	}
	//endregion
}