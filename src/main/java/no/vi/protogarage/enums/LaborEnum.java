package no.vi.protogarage.enums;

//todo geen enum maken maar arraylist
public enum LaborEnum
{
	INSPECTION(60, 4500, "Inspectie"),		//Always costs €45,-
	
	BLINKERFLUID(150, 6000, "Ruitenwisservloeistof vervangen"),
	BRAKEDISC(60, 4000, "Remschijf vervangen"),
	LAMBDASENSOR(120, 4000, "Lambdasensor vervangen"),
	WIPER(15, 40000, "Ruitenwisser vervangen"),
	
	//todo bedenken hoe other te implementeren
	OTHER(0, 0, "Overig");
	
	public final int minutes;
	public final int cost;
	public final String description;
	
	private LaborEnum(int minutes, int cost, String description)
	{
		this.minutes = minutes;
		this.cost = cost;
		this.description = description;
	}
}