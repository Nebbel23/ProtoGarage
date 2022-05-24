package no.vi.protogarage.services;

import no.vi.protogarage.models.Labor;
import no.vi.protogarage.models.Part;
import no.vi.protogarage.repositories.LaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaborService
{
	@Autowired
	LaborRepository laborRepository;
	
	//region Get
	public List<Labor> getAllLabor()
	{
		return laborRepository.findAll();
	}
	
	public Labor getLaborById(Long id)
	{
		return laborRepository.findById(id).get();
	}
	//endregion
	
	//region Post
	public Labor addLabor(Labor l)
	{
		return laborRepository.save(l);
	}
	
	public Labor addPartToLabor(Long laborId, Part part)
	{
		Labor labor = laborRepository.findById(laborId).get();
		labor.addPart(part);
		return laborRepository.save(labor);
	}
	//endregion
	
	//region Put
	public Labor editLabor(Long id, Labor l)
	{
		return laborRepository.findById(id)
				.map(
						labor ->
						{
							labor.setName(l.getName());
							labor.setDescription(l.getDescription());
							labor.setCostPerHour(l.getCostPerHour());
							labor.setDurationInMinutes(l.getDurationInMinutes());
							labor.setFixedPriceCost(l.getFixedPriceCost());
							
							return laborRepository.save(labor);
						}
				).orElseGet(() ->
						{
							return addLabor(l);
						}
				);
	}
	//endregion
	
	//region Delete
	public void deleteLabor(Long id)
	{
		laborRepository.deleteById(id);
	}
	//endregion
}