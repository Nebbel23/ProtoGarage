package no.vi.protogarage.services;

import no.vi.protogarage.models.Labor;
import no.vi.protogarage.models.Reparation;
import no.vi.protogarage.repositories.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparationService
{
	@Autowired
	ReparationRepository reparationRepository;
	
	//region Get
	public List<Reparation> getAllReparations()
	{
		return reparationRepository.findAll();
	}
	
	public Reparation getReparationById(Long id)
	{
		return reparationRepository.findById(id).get();
	}
	//region
	
	//region Post
	public Reparation addReparation(Reparation reparation)
	{
		return reparationRepository.save(reparation);
	}
	
	public Reparation addLaborToReparation(Long reparationId, Labor labor)
	{
		Reparation reparation = reparationRepository.findById(reparationId).get();
		reparation.addLabor(labor);
		return reparationRepository.save(reparation);
	}
	//endregion
	
	//region Put
	public Reparation editReparation(Long id, Reparation r)
	{
		return reparationRepository.findById(id)
				.map(
						reparation ->
						{
							reparation.setName(r.getName());
							reparation.setLabor(r.getLabor());
							reparation.setDone(r.isDone());
							
							return reparationRepository.save(reparation);
						}
				).orElseGet(() ->
						{
							return addReparation(r);
						}
				);
	}
	//endregion
	
	//region Delete
	public void deleteReparation(Long id)
	{
		reparationRepository.deleteById(id);
	}
	//endregion
}