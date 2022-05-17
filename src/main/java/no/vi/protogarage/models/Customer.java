package no.vi.protogarage.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id")
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String phoneNr;
	@Column
	@OneToMany
	private List<Car> cars;
	
	//region Getters & setters
	public Long getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getPhoneNr()
	{
		return phoneNr;
	}
	
	public void setPhoneNr(String phoneNr)
	{
		this.phoneNr = phoneNr;
	}
	
	public List<Car> getCars()
	{
		return cars;
	}
	
	public void setCars(List<Car> cars)
	{
		this.cars = cars;
	}
	//endregion
}