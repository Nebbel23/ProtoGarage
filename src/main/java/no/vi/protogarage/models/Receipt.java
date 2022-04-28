package no.vi.protogarage.models;

import java.util.ArrayList;

public class Receipt
{
	private ArrayList<Reparation> reparations;
	
	//todo weghalen?
	public ArrayList<Reparation> getReparations()
	{
		return reparations;
	}
	
	public void addReparation(Reparation r)
	{
		reparations.add(r);
	}
}