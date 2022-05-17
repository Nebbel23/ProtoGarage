package no.vi.protogarage.services;

import no.vi.protogarage.models.Labor;
import no.vi.protogarage.repositories.LaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaborService
{
	@Autowired
	LaborRepository repo;
	
	//region Get
	public List<Labor> getAllLabor()
	{
		return repo.findAll();
	}
	
	public Labor getLaborById(Long id)
	{
		return repo.findById(id).get();
	}
	//endregion
	
	//region Post
	public Labor addLabor(Labor l)
	{
		return repo.save(l);
	}
	
	//todo
	public Labor addPartToLabor(Long laborId, Long partId)
	{
		return new Labor();
	}
	//endregion
	
	//region Put
	public Labor editLabor(Long id, Labor l)
	{
		return repo.findById(id)
				.map(
						labor ->
						{
							labor.setName(l.getName());
							labor.setDescription(l.getDescription());
							labor.setCostPerHour(l.getCostPerHour());
							labor.setDurationInMinutes(l.getDurationInMinutes());
							labor.setFixedPriceCost(l.getFixedPriceCost());
							
							return repo.save(labor);
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
		repo.deleteById(id);
	}
	//endregion
}