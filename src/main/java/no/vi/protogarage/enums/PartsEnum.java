package no.vi.protogarage.enums;

//todo geen enum maken maar arraylist
//@Entity
//@Table
public enum PartsEnum
{
	BLINKERFLUID(7999, "Knipperlichtvloeistof"),
	BRAKEDISC(4395, "Remschijf"),
	LAMBDASENSOR(7398, "Lambdasensor"),
	WIPER(730, "Ruitenwisser"),
	
	//todo bedenken hoe other te implementeren
	OTHER(0, "Overig");
	
	public final int cost;
	public final String name;
	
	private PartsEnum(int cost, String name)
	{
		this.cost = cost;
		this.name = name;
	}
}