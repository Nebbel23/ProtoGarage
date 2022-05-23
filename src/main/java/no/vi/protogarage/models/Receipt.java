package no.vi.protogarage.models;

import no.vi.protogarage.config.Constants;

import java.util.ArrayList;

//TODO BTW TOEVOEGEN
//TODO afmaken
public class Receipt
{
	//todo finals ergens neerzetten
	private final String GARAGE_NAME = Constants.GARAGE_NAME;
	private final String INDENT_SPACES = Constants.INDENT_SPACES;
	private final int STANDARD_WIDTH = Constants.STANDARD_WIDTH;	//werkt alleen met even getallen atm //todo ook voor oneven werkend maken?
	private final int MIN_WIDTH = 36;								//todo uitzoeken wat echt min is
	private int width = STANDARD_WIDTH;                				//Dit is exclusief de |borders|
	private Car car;
	
	public Receipt(Car car)
	{
		this.car = car;
	}
	
	public Receipt(Car car, int width)
	{
		this.car = car;
		
		if (width < MIN_WIDTH)
		{
			this.width = MIN_WIDTH;
			//todo throw exception over te kleine width
		}
		else
			this.width = width;
	}
	
	//todo ergens kijken wanneer part dubbel is? waarom eigenlijk? print gewoon 2 keer. maak eerst je andere shit eens niels
	public String generate()
	{
		String r = "";
		
		r += endLine();
		r += whiteLine();
		r += centerLine(GARAGE_NAME);
		r += whiteLine();
		r += dashLine();
		r += centerLine("abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890");
		r += whiteLine();
		r += whiteLine();
		r += dashLine();
		r += whiteLine();
		
		//TODO Hier gaat iets fout
		for (Reparation reparation : car.getReparations())
			r += printReparation(reparation);
		
		//todo totaal toevoegen
		r+=whiteLine();
		
		r += endLine();
		
		return r;
	}
	
	public String printReparation(Reparation reparation)
	{
		//todo totaalprijs repair toevoegen
		String retString = justifyLine(reparation.getName(), toEuro(reparation.getCost()));
		
		for (Labor l : reparation.getLabor())
			retString += printLabor(l);
		
		retString += whiteLine();
		
		return retString;
	}
	
	public String printLabor(Labor labor)
	{
		String retString = justifyIndentedLine(1, "Arbeid (" + labor.getDurationInMinutes() + " min) ", toEuro(labor.getCost()));
		
		for (Part p : labor.getParts())
			retString += printPart(p);
		
		return retString;
	}
	
	public String printPart(Part part)
	{
		return justifyIndentedLine(2, part.getName(), toEuro(part.getCost()));
	}
	
	public String centerLine(String toCenter)
	{
		String retString = "";
		
		ArrayList<String> splitStrings = splitStringToLenght(toCenter, width - 2);
		
		for (String s : splitStrings)
		{
			int totalSpace = width - s.length();
			
			retString += "|";
			for (int i = 0; i < Math.floor(totalSpace / 2); i++)    					//Links padden
				retString += " ";
			retString += s;
			for (int i = 0 - (totalSpace % 2); i < Math.floor(totalSpace / 2); i++)		//Rechts padden
				retString += " ";														//Maar voegt extra spatie toe als woord oneven aantal karakters is

			retString += "|\n";
		}
		
		return retString;
	}
	
	private String leftAlignLine(String string)
	{
		return justifyLine(string, "");
	}
	
	private String justifyLine(String leftString, String rightString)
	{
		return justifyIndentedLine(0, leftString, rightString);
	}
	
	private String leftAlignIndentedLine(int indents, String string)
	{
		return justifyIndentedLine(indents, string, "");
	}
	
	private String justifyIndentedLine(int indents, String leftString, String rightString)
	{
		String retString = "";
		
		ArrayList<String> splitStrings = splitStringToLenght(indent(indents, leftString), width - rightString.length() - 3);
		
		whiteLine();
		whiteLine();
		whiteLine();
		for (String s : splitStrings)
			System.out.println(s);
		whiteLine();
		whiteLine();
		whiteLine();
		
		//todo splitstrings
		for (int i = 0; i < splitStrings.size(); i++)
		{
			String indentedString = indent(indents, splitStrings.get(i));
			retString += "| " + indentedString;
			if (i == 0)
			{
				for (int j = 0; j < width - indentedString.length() - rightString.length() - 2; j++)	//-2 omdat een spatie tussen leftString en rightString EN aan het begin al een spatie komt tussen | en indentedString
					retString += " ";
				retString += rightString + " ";
			}
			else
				for (int j = 0; j < width - indentedString.length() - 1; j++)							//-1 omdat aan het begin al een spatie komt tussen | en indentedString
					retString += " ";
				
			retString += "|\n";
		}
		
		return retString;
	}
	
	private String whiteLine()
	{
		String line = "|";
		for (int i = 0; i < width; i++)
			line += " ";
		line += "|";
		
		line += "\n";
		return line;
	}
	
	private String dashLine()
	{
		int whiteSpacePerSide = 3;					//Hoe veel spaties aan padding per kant
		
		String line = "";
		for (int i = 0; i <= width - (whiteSpacePerSide * 2); i++)
			line += "-";
		
		return centerLine(line);
	}
	
	private String endLine()
	{
		String line = "+";
		for (int i = 0; i < width; i++)
			line += "-";
		line += "+";
		
		line += "\n";
		return line;
	}
	
	private String toEuro(int cents)
	{
		return "€" + String.format("%.2f", (double) cents / 100);
	}
	
	private String indent(int indents, String string)		//Voegt per indent twee spaties toe links van de String
	{
		String retString = "";
		for (int i = 0; i < indents; i++)
			retString += INDENT_SPACES;
		return retString + string;
	}
	
	private ArrayList<String> splitStringToLenght(String string, int length)
	{
		ArrayList<String> splitStrings = new ArrayList<String>();			//Hier worden strings opgesplitst als ze breder zijn dan het vak (= breedte bonnetje - bedrag)
		
		for (int i = 0; i <= string.length(); i += length)
			splitStrings.add(string.substring(i, Math.min(string.length(), i + length)));
		
		return splitStrings;
	}
}

/*

+-----------------------------------------+	X
|                                         |	X
|                 VONS                    |	X
|                                         | X
|           Welcome To Our Store          | X
|                                         | X
|   6 @ 5/1.00 Top Ramen          1.20 F  |
|    6 @ .10                              |
|  SC 3339 Club Nissin Top Ra      .60-F  |
|  2@.00   Italian Seasn          1.98 F  |
|          LCN 32Z Mex            6.49 F  |
|  SC 3210 Club Lucerne Chees     1.50-F  |
|          HLYWD Mayo             2.79 F  |
|   2 @ 5/1.00                            |
|          Top Ramen               .40 F  |
|    2 @   10                             |
|  SC 3339 Club Nissin To Ra       .20-F  |
|   2 @ 5/1.00                            |
|          Top Ramen                      |
|    2 @ .10                              |
|  SC 3339 Club Nissin Top Ra      .20-F  |
|          Kikko MN Soy           1.09 F  |
|     **** TAX        .00   BAL   11.85   |
|          CASH                   20.00   |
|                                         | X
|          Change                  8.15   |
|                                         | X
|          Number Of Items      15        |
|     6/02/03 19:01 2355 01 0579 7143     | X
|                                         | X
|   -----------------------------------   | X
|            X2of3       3894             | X
|   -----------------------------------   | X
|    Club Card Savings          $  2.50   |
|    Total Savings Value  17%   $  2.50   |
|                                         | X
|  You have purchased   0  of   8 toward  | X
|        Your  1st  FREE BAGLE!!          | X
|         See Store For Details.          | X
|                                         | X
|  You have purchased   0  of   7 toward  | X
|     Your  1st  FREE DELI SANDWICH       | X
|         See Store For Details.          | X
|                                         | X
|         LET US HEAR FROM YOU!           | X
|    1-877-723-3929 or visit VONS.COM     | X
|                                         | X
+-----------------------------------------+ X

Reparatie						VEEL
   9 Onderdeel					 WAT
  99 Onderdeel					 WAT
   9  Onderdeel					 WAT
99,5 Labor						IETS

 */