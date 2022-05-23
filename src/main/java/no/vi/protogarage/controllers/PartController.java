package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Part;
import no.vi.protogarage.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@RestController
@RequestMapping(PATH_PREFIX + "/part")
public class PartController
{
	private final PartService service;
	
	@Autowired
	private PartController(PartService service)
	{
		this.service = service;
	}
	
	//region Get
	@GetMapping
	private List<Part> getAllParts()
	{
		return service.getAllParts();
	}
	
	@GetMapping("/{id}")
	private Part getPartById(@PathVariable("id") Long id)
	{
		return service.getPartById(id);
	}
	//endregion
	
	//region Post
	@PostMapping
	private void addPart(@RequestBody Part part)
	{
		service.addPart(part);
	}
	//endregion
	
	//region Put
	@PutMapping("/{id}")
	private void editPart(@RequestBody Part part, @PathVariable("id") Long id)
	{
		service.editPart(id, part);
	}
	//endregion
	
	//region Delete
	@DeleteMapping("/{id}")
	private void deletePart(@PathVariable("id") Long id)
	{
		service.deletePart(id);
	}
	//endregion
}