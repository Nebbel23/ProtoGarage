package no.vi.protogarage.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reparations")
@NoArgsConstructor
public class Reparation
{
//TODO Kiezen tussen ID generators
	
//	@Id
//	@SequenceGenerator(
//			name = "user_sequence",
//			sequenceName = "user_sequence",
//			allocationSize = 1
//	)
//
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "user_sequence"
//	)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id")
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private boolean done = false;
	@Column
	@ManyToMany(fetch = FetchType.EAGER)//(cascade = CascadeType.PERSIST)
	private List<Labor> labor = new ArrayList<Labor>();
	
	public void addLabor(Labor l)
	{
		labor.add(l);
	}
	
	public Reparation(String name)
	{
		this.name = name;
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
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public List<Labor> getLabor()
	{
		return labor;
	}
	
	public void setLabor(List<Labor> labor)
	{
		this.labor = labor;
	}
	
	public int getCost()
	{
		int cost = 0;
		
		for (Labor l : labor)
		{
			cost += l.getCost();
			for (Part p : l.getParts())
				cost += p.getCost();
		}
		
		return cost;
	}
	//endregion
}