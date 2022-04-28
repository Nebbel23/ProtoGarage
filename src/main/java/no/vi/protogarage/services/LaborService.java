package no.vi.protogarage.services;

import no.vi.protogarage.models.Labor;

import java.util.ArrayList;
import java.util.List;

public class LaborService
{
	//region Get
	public List<Labor> getAllLabor()
	{
		return new ArrayList<Labor>();
	}
	
	public Labor getLaborById(Long id)
	{
		return new Labor();
	}
	//endregion
	
	//region Post
	public Labor addLabor(Labor l)
	{
		return new Labor();
	}
	
	public Labor addPartToLabor(Long laborId, Long partId)
	{
		return new Labor();
	}
	//endregion
	
	//region Put
	public Labor editLabor(Long id, Labor l)
	{
		return new Labor();
	}
	//endregion
	
	//region Delete
	//todo check of returntype niet Labor is
	public void deleteLabor(Long id)
	{
	
	}
	//endregion
}