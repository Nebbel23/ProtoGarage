package no.vi.protogarage.models;

import lombok.NoArgsConstructor;
import no.vi.protogarage.config.Constants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
public class Labor
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)                //Kenteken wordt niet gegenereerd
	@Column(unique = true, nullable = false, name = "id")
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private int durationInMinutes;
	@Column(nullable = false)
	private boolean fixedPrice = false;
	@Column
	private int fixedPriceCost;
	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Part> parts = new ArrayList<Part>();
	
	private int costPerHour = Constants.COST_PER_HOUR;
	
	//Arbeid zonder onderdelen (schroefje aandraaien, banden uitlijnen)
	public Labor(String name, String description, int durationInMinutes)
	{
		this.name = name;
		this.description = description;
		this.durationInMinutes = durationInMinutes;
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
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public int getCostPerHour()
	{
		return costPerHour;
	}
	
	public void setCostPerHour(int costPerHour)
	{
		this.costPerHour = costPerHour;
	}
	
	public int getDurationInMinutes()
	{
		return durationInMinutes;
	}
	
	public void setDurationInMinutes(int durationInMinutes)
	{
		this.durationInMinutes = durationInMinutes;
	}
	
	public boolean isFixedPrice()
	{
		return fixedPrice;
	}
	
	public int getFixedPriceCost()
	{
		return fixedPriceCost;
	}
	
	public void setFixedPriceCost(int cost)
	{
		if (cost == 0)
			fixedPrice = false;
		else
			fixedPrice = true;
		
		fixedPriceCost = cost;
	}
	
	public void addPart(Part p)
	{
		parts.add(p);
	}
	
	public List<Part> getParts()
	{
		return parts;
	}
	
	public int getCost()
	{
		if (fixedPrice)
			return fixedPriceCost;
		else
			return Math.round((costPerHour * durationInMinutes) / 60);
	}
	//endregion
}