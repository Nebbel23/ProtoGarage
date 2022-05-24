package no.vi.protogarage.services;

import no.vi.protogarage.models.Part;
import no.vi.protogarage.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService
{
	@Autowired
	PartRepository partRepository;
	
	//region Get
	public List<Part> getAllParts()
	{
		return partRepository.findAll();
	}
	
	public Part getPartById(Long id)
	{
		return partRepository.findById(id).get();
	}
	//endregion
	
	//region Post
	public Part addPart(Part p)
	{
		return partRepository.save(p);
	}
	//endregion
	
	//region Put
	public Part editPart(Long id, Part p)
	{
		return partRepository.findById(id)
				.map(
						part ->
						{
							part.setName(p.getName());
							part.setCost(p.getCost());
							
							return partRepository.save(part);
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
		partRepository.deleteById(id);
	}
	//endregion
}