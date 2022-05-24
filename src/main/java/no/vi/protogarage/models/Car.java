package no.vi.protogarage.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)                //Kenteken wordt niet gegenereerd
	@Column(unique = true, nullable = false, name = "id")
	private Long id;
	@Column(nullable = false)
	private String registration;
	@Column(nullable = false)
	private boolean executeStatus = true;
	@Column(nullable = false)
	private boolean atShop = false;
	@Column(nullable = false)
	private boolean payed = false;
	@Column
	@ManyToMany//(cascade = CascadeType.PERSIST)//TODO checken of weghalen
	private List<Reparation> reparations = new ArrayList<Reparation>();
	
	//todo pdf reader ding
	private String papers;
	
	//region Getters & setters
	public String getRegistration()
	{
		return registration;
	}
	
	public void setRegistration(String registration)
	{
		this.registration = registration;
	}
	
	public boolean isExecuteStatus()
	{
		return executeStatus;
	}
	
	public void setExecuteStatus(boolean executeStatus)
	{
		this.executeStatus = executeStatus;
	}
	
	public boolean isAtShop()
	{
		return atShop;
	}
	
	public void setAtShop(boolean atShop)
	{
		this.atShop = atShop;
	}
	
	public boolean isPayed()
	{
		return payed;
	}
	
	public void setPayed(boolean payed)
	{
		this.payed = payed;
	}
	
	public List<Reparation> getReparations() {return reparations;}
	
	public void setReparations(List<Reparation> reparations)
	{
		this.reparations = reparations;
	}
	//endregion
	
	public void addReparation(Reparation reparation)
	{
		reparations.add(reparation);
	}
}