package no.vi.protogarage.models;

//import javax.persistence.*;

import java.util.ArrayList;

//@Entity
//@Table
public class Car
{
//	@Id
////@GeneratedValue(strategy = GenerationType.IDENTITY)				//Kenteken wordt niet gegenereerd
//	@Column(unique = true, nullable = false, name = "registration")
	private String registration;
	private boolean atShop = false;
	private boolean payed = false;
	private ArrayList<Reparation> reparations;
	//todo pdf reader ding
	private String papers;
	
	//region Getters & setters
	private String getRegistration()
	{
		return registration;
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
	//endregion
	
	public void addReparation(Reparation r)
	{
		reparations.add(r);
	}
	
	public void delReparation(Reparation r)
	{
		reparations.remove(r);
	}
}