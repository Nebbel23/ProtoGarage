package no.vi.protogarage.models;

import java.util.ArrayList;

public class Labor
{
	private String name;
	private String description;
	private int costPerHour;
	private int durationInMinutes;
	private ArrayList<Part> parts;
	
	//region Getters & setters
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getCostPerHour()
	{
		return costPerHour;
	}
	
	public int getDurationInMinutes()
	{
		return durationInMinutes;
	}
	
	public void addPart(Part p)
	{
		parts.add(p);
	}
	
	public int getCost()
	{
		return Math.round((costPerHour * durationInMinutes) / 60);
	}
	//endregion
}