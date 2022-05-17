package no.vi.protogarage.models;

import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Part
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id")
	private int id;
	@Column(nullable = false)
	private String name;
	@Column
	private int cost;
	
	//todo weghalen wanneer service werkt
	public Part() {}
	
	public Part(String name, int cost)
	{
		this.name = name;
		this.cost = cost;
	}
	
	//region Getters & setters
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getCost()
	{
		//todo cost implementeren
		return cost;
	}
	
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	//endregion
}