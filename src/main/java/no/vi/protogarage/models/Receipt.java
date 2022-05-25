package no.vi.protogarage.models;

import no.vi.protogarage.config.Constants;

import java.util.ArrayList;

public class Receipt
{
	private final String GARAGE_NAME = Constants.GARAGE_NAME;
	private final String INDENT_SPACES = Constants.INDENT_SPACES;
	private final int STANDARD_WIDTH = Constants.STANDARD_WIDTH;
	private final int MIN_WIDTH = 42;
	private int width = STANDARD_WIDTH;                                //Dit is exclusief de |borders|
	private Car car;
	
	public Receipt(Car car)
	{
		this.car = car;
		
		if (width % 2 > 0)
			width++;
	}
	
	public Receipt(Car car, int width)
	{
		this.car = car;
		
		if (width % 2 > 0)
			width++;
		
		if (width < MIN_WIDTH)
			this.width = MIN_WIDTH;
		else
			this.width = width;
	}
	
	//Maakt het bonnentje
	public String generate()
	{
		String r = "\n";
		
		r += endLine();
		r += whiteLine();
		r += centerLine(GARAGE_NAME);
		r += whiteLine();
		r += centerLine("De geautomatiseerde autospeciaalzaak");
		r += whiteLine();
		r += whiteLine();
		r += dashLine();
		r += whiteLine();
		
		for (Reparation reparation : car.getReparations())
			r += printReparation(reparation);
		
		r += whiteLine();
		r += dashLine();
		r += justifyLine("Totaal excl. BTW", toEuro(calcPriceWithoutVAT(car)));
		r += justifyLine("BTW", toEuro(calcVAT(car)));
		r += justifyLine("Totaal", toEuro(calcPriceWithoutVAT(car) + calcVAT(car)));
		r += whiteLine();
		r += endLine();
		
		return r;
	}
	
	public int calcPriceWithoutVAT(Car car)
	{
		int cost = 0;
		
		for (Reparation r : car.getReparations())
			cost += r.getCost();
		
		return cost;
	}
	
	public int calcVAT(Car car)
	{
		return (int) Math.round(calcPriceWithoutVAT(car) * 0.21);
	}
	
	public String printReparation(Reparation reparation)
	{
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
		
		ArrayList<String> splitStrings = splitStringToLength(toCenter, width - 2);
		
		for (String s : splitStrings)
		{
			int totalSpace = width - s.length();
			
			retString += "|";
			for (int i = 0; i < Math.floor(totalSpace / 2); i++)                        //Links padden
				retString += " ";
			retString += s;
			for (int i = 0 - (totalSpace % 2); i < Math.floor(totalSpace / 2); i++)        //Rechts padden
				retString += " ";                                                        //Voegt extra spatie toe als woord oneven aantal karakters is
			
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
		
		ArrayList<String> splitStrings = splitStringToLength(indent(indents, leftString), width - rightString.length() - 3);
		
		for (int i = 0; i < splitStrings.size(); i++)
		{
			String indentedString = indent(indents, splitStrings.get(i));
			retString += "| " + indentedString;
			if (i == 0)
			{
				for (int j = 0; j < width - indentedString.length() - rightString.length() - 2; j++)    //-2 omdat een spatie tussen leftString en rightString EN aan het begin al een spatie komt tussen | en indentedString
					retString += " ";
				retString += rightString + " ";
			}
			else
				for (int j = 0; j < width - indentedString.length() - 1; j++)                            //-1 omdat aan het begin al een spatie komt tussen | en indentedString
					retString += " ";
			
			retString += "|\n";
		}
		
		return retString;
	}
	
	private String whiteLine()        //
	{
		String line = "|";
		for (int i = 0; i < width; i++)
			line += " ";
		line += "|";
		
		line += "\n";
		return line;
	}
	
	private String dashLine()        //   -------------
	{
		int whiteSpacePerSide = 3;   //Hoe veel spaties aan padding per kant
		
		String line = "";
		for (int i = 0; i <= width - (whiteSpacePerSide * 2); i++)
			line += "-";
		
		return centerLine(line);
	}
	
	private String endLine()        // +---------------+
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
	
	private String indent(int indents, String string)                    //Voegt per indent twee spaties toe links van de String
	{
		String retString = "";
		for (int i = 0; i < indents; i++)
			retString += INDENT_SPACES;
		return retString + string;
	}
	
	private ArrayList<String> splitStringToLength(String string, int length)
	{
		ArrayList<String> splitStrings = new ArrayList<String>();       //Hier worden strings opgesplitst als ze breder zijn dan het vak (= breedte bonnetje - bedrag)
		
		for (int i = 0; i <= string.length(); i += length)
			splitStrings.add(string.substring(i, Math.min(string.length(), i + length)));
		
		return splitStrings;
	}
}