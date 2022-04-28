package no.vi.protogarage.controllers;

import no.vi.protogarage.models.Part;
import no.vi.protogarage.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping(path = "/part")
public class PartController
{
	private final PartService ps;
	
	@Autowired
	public PartController(PartService partService)
	{
		this.ps = partService;
	}
	
	//region Get
	@GetMapping
	public List<Part> getAllParts()
	{
		return ps.getAllParts();
	}
	
	@GetMapping("/{id}")
	public Part getPartById(@PathVariable("id") Long id)
	{
		return ps.getPartById(id);
	}
	//getById
	
	//endregion
	
	//region Post
	
	//addPart
	
	//endregion
	
	//region Put
	
	//changePart
	
	//endregion
	
	//region Delete
	
	//deletePart
	
	//endregion
}