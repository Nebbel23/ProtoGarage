package no.vi.protogarage.services;

import no.vi.protogarage.models.Part;
import no.vi.protogarage.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartService
{
	@Autowired
	PartRepository repo;
	
	//region Get
	public List<Part> getAllParts()
	{
		return repo.findAll();
	}
	
	public Part getPartById(Long id)
	{
		return repo.findById(id).get();
	}
	//endregion
	
	//region Post
	public Part addPart(Part p)
	{
		return repo.save(p);
	}
	//endregion
	
	//region Put
	public Part editPart(Long id, Part p)
	{
		return repo.findById(id)
				.map(
						part ->
						{
							part.setName(p.getName());
							part.setCost(p.getCost());
							
							return repo.save(part);
						}
				).orElseGet(() ->
						{
							return addPart(p);
						}
				);
	}
	//endregion
	
	//region Delete
	public void deletePart(Long id)
	{
		repo.deleteById(id);
	}
	//endregion
}