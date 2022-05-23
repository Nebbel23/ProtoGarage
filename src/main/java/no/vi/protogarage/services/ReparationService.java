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
	ReparationRepository repo;
	
	//region Get
	public List<Reparation> getAllReparations()
	{
		return repo.findAll();
	}
	
	public Reparation getReparationById(Long id)
	{
		return repo.findById(id).get();
	}
	//region
	
	//region Post
	public Reparation addReparation(Reparation reparation)
	{
		return repo.save(reparation);
	}
	
	public Reparation addLaborToReparation(Long reparationId, Labor labor)
	{
		Reparation reparation = repo.findById(reparationId).get();
		reparation.addLabor(labor);
		return repo.save(reparation);
	}
	//endregion
	
	//region Put
	public Reparation editReparation(Long id, Reparation r)
	{
		return repo.findById(id)
				.map(
						reparation ->
						{
							reparation.setName(r.getName());
							reparation.setLabor(r.getLabor());
							reparation.setDone(r.isDone());
							
							return repo.save(reparation);
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
		repo.deleteById(id);
	}
	//endregion
}