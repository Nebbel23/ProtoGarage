package no.vi.protogarage.config;

public class Constants
{
	//Info over informatiesysteem
	public static final int VERSION = 1;					//Versie van API
	public static final String PATH_PREFIX =				//Pathname begin voor restpoints
			"/api/v" + VERSION;
	
	//Info over garage
	public static final String GARAGE_NAME = "Garagé";		//De naam van de garage
	public static final int COST_PER_HOUR = 7000;			//De prijs per uur voor arbeid (in cent)
	public static final int VAT_PERCENTAGE = 21;			//BTW-percentage
	
	//Bonnetje
	public static final int STANDARD_WIDTH = 62;			//Werkt alleen met even getallen, wordt anders automatisch met 1 opgehoogd
	public static final String INDENT_SPACES = "  ";		//Het aantal spaties dat wordt gebruikt voor indents in het bonnetje
}