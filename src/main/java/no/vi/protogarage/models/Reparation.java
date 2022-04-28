package no.vi.protogarage.models;

import java.util.ArrayList;

public class Reparation
{
	private boolean done = false;
	private ArrayList<Part> parts;
	private ArrayList<Labor> labor;
	
	public void addPart(Part p)
	{
		parts.add(p);
	}
	
	public void addLabor(Labor l)
	{
		labor.add(l);
	}
	
	//region Getters & setters
	public boolean isDone()
	{
		return done;
	}
	
	public void setDone(boolean done)
	{
		this.done = done;
	}
	
	public ArrayList<Part> getParts()
	{
		return parts;
	}
	
	public ArrayList<Labor> getLabor()
	{
		return labor;
	}
	
	public int getCost()
	{
		int cost = 0;
		
		for (Part p : parts)
			cost += p.getCost();
		
		for (Labor l : labor)
			cost += l.getCost();
		
		return cost;
	}
	//endregion
}