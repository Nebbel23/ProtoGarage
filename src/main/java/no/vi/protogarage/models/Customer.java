package no.vi.protogarage.models;

//import javax.persistence.*;
import java.util.ArrayList;

//@Entity
//@Table
public class Customer
{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(unique = true, nullable = false, name = "id")
	private int id;
//	@Column(nullable = false)
	private String name;
//	@Column(nullable = false)
	private String phoneNr;
//	@OneToMany
//	@Column
	private ArrayList<Car> cars;
	private ArrayList<Reparation> reparations;
	
	//region Getters & setters
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPhoneNr()
	{
		return phoneNr;
	}
	//endregion
}