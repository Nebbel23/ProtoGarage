package no.vi.protogarage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static no.vi.protogarage.config.Constants.GARAGE_NAME;

class ReceiptTest
{
	/**
	 * Method under test: {@link Receipt#generate()}
	 */
	@Test
	void testGenerate()
	{
		assertEquals("\n"
				+ "+----------------------------------------------------+\n"
				+ "|                                                    |\n"
				+ "|                       " + GARAGE_NAME + "                       |\n"
				+ "|                                                    |\n"
				+ "|        De geautomatiseerde autospeciaalzaak        |\n"
				+ "|                                                    |\n"
				+ "|                                                    |\n"
				+ "|  -----------------------------------------------   |\n"
				+ "|                                                    |\n"
				+ "|                                                    |\n"
				+ "|  -----------------------------------------------   |\n"
				+ "| Totaal excl. BTW                             €0.00 |\n"
				+ "| BTW                                          €0.00 |\n"
				+ "| Totaal                                       €0.00 |\n"
				+ "|                                                    |\n"
				+ "+----------------------------------------------------+\n", (new Receipt(new Car())).generate());
	}
	
	/**
	 * Method under test: {@link Receipt#generate()}
	 */
	@Test
	void testGenerate2()
	{
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("\n");
		
		Car car = new Car();
		car.addReparation(reparation);
		assertEquals("\n"
				+ "+----------------------------------------------------+\n"
				+ "|                                                    |\n"
				+ "|                       " + GARAGE_NAME + "                       |\n"
				+ "|                                                    |\n"
				+ "|        De geautomatiseerde autospeciaalzaak        |\n"
				+ "|                                                    |\n"
				+ "|                                                    |\n"
				+ "|  -----------------------------------------------   |\n"
				+ "|                                                    |\n" + "| \n"
				+ "                                            €0.00 |\n"
				+ "|                                                    |\n"
				+ "|                                                    |\n"
				+ "|  -----------------------------------------------   |\n"
				+ "| Totaal excl. BTW                             €0.00 |\n"
				+ "| BTW                                          €0.00 |\n"
				+ "| Totaal                                       €0.00 |\n"
				+ "|                                                    |\n"
				+ "+----------------------------------------------------+\n", (new Receipt(car)).generate());
	}
	
	/**
	 * Method under test: {@link Receipt#generate()}
	 */
	@Test
	void testGenerate3()
	{
		Part part = new Part();
		part.setCost(52);
		part.setName("\n");
		
		Labor labor = new Labor();
		labor.addPart(part);
		labor.setCostPerHour(52);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(52);
		labor.setName("\n");
		
		ArrayList<Labor> laborList = new ArrayList<>();
		laborList.add(labor);
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(laborList);
		reparation.setName("\n");
		
		Car car = new Car();
		car.addReparation(reparation);
		assertEquals("\n"
				+ "+----------------------------------------------------+\n"
				+ "|                                                    |\n"
				+ "|                       " + GARAGE_NAME + "                       |\n"
				+ "|                                                    |\n"
				+ "|        De geautomatiseerde autospeciaalzaak        |\n"
				+ "|                                                    |\n"
				+ "|                                                    |\n"
				+ "|  -----------------------------------------------   |\n"
				+ "|                                                    |\n" + "| \n"
				+ "                                            €0.97 |\n"
				+ "|     Arbeid (52 min)                          €0.45 |\n" + "|         \n"
				+ "                                    €0.52 |\n" + "|                                                    |\n"
				+ "|                                                    |\n"
				+ "|  -----------------------------------------------   |\n"
				+ "| Totaal excl. BTW                             €0.97 |\n"
				+ "| BTW                                          €0.20 |\n"
				+ "| Totaal                                       €1.17 |\n"
				+ "|                                                    |\n"
				+ "+----------------------------------------------------+\n", (new Receipt(car)).generate());
	}
	
	/**
	 * Method under test: {@link Receipt#calcPriceWithoutVAT(Car)}
	 */
	@Test
	void testCalcPriceWithoutVAT()
	{
		Receipt receipt = new Receipt(new Car());
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		assertEquals(0, receipt.calcPriceWithoutVAT(car));
	}
	
	/**
	 * Method under test: {@link Receipt#calcPriceWithoutVAT(Car)}
	 */
	@Test
	void testCalcPriceWithoutVAT2()
	{
		Receipt receipt = new Receipt(new Car());
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		
		ArrayList<Reparation> reparationList = new ArrayList<>();
		reparationList.add(reparation);
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(reparationList);
		assertEquals(0, receipt.calcPriceWithoutVAT(car));
	}
	
	/**
	 * Method under test: {@link Receipt#calcVAT(Car)}
	 */
	@Test
	void testCalcVAT()
	{
		Receipt receipt = new Receipt(new Car());
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		assertEquals(0, receipt.calcVAT(car));
	}
	
	/**
	 * Method under test: {@link Receipt#calcVAT(Car)}
	 */
	@Test
	void testCalcVAT2()
	{
		Receipt receipt = new Receipt(new Car());
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		
		ArrayList<Reparation> reparationList = new ArrayList<>();
		reparationList.add(reparation);
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(reparationList);
		assertEquals(0, receipt.calcVAT(car));
	}
	
	/**
	 * Method under test: {@link Receipt#printReparation(Reparation)}
	 */
	@Test
	void testPrintReparation()
	{
		Receipt receipt = new Receipt(new Car());
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		assertEquals("| Name                                         €0.00 |\n"
				+ "|                                                    |\n", receipt.printReparation(reparation));
	}
	
	/**
	 * Method under test: {@link Receipt#printReparation(Reparation)}
	 */
	@Test
	void testPrintReparation2()
	{
		Receipt receipt = new Receipt(new Car());
		
		Part part = new Part();
		part.setCost(1);
		part.setName("%.2f");
		
		Labor labor = new Labor();
		labor.addPart(part);
		labor.setCostPerHour(1);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(1);
		labor.setName("%.2f");
		
		ArrayList<Labor> laborList = new ArrayList<>();
		laborList.add(labor);
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(laborList);
		reparation.setName("Name");
		assertEquals("| Name                                         €0.01 |\n"
				+ "|     Arbeid (1 min)                           €0.00 |\n"
				+ "|         %.2f                                 €0.01 |\n"
				+ "|                                                    |\n", receipt.printReparation(reparation));
	}
	
	/**
	 * Method under test: {@link Receipt#printLabor(Labor)}
	 */
	@Test
	void testPrintLabor()
	{
		Receipt receipt = new Receipt(new Car());
		
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		
		Labor labor = new Labor();
		labor.addPart(part);
		labor.setCostPerHour(1);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(1);
		labor.setName("Name");
		assertEquals("|     Arbeid (1 min)                           €0.00 |\n"
				+ "|         Name                                 €0.01 |\n", receipt.printLabor(labor));
	}
	
	/**
	 * Method under test: {@link Receipt#printPart(Part)}
	 */
	@Test
	void testPrintPart()
	{
		Receipt receipt = new Receipt(new Car());
		
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		assertEquals("|         Name                                 €0.01 |\n", receipt.printPart(part));
	}
	
	/**
	 * Method under test: {@link Receipt#centerLine(String)}
	 */
	@Test
	void testCenterLine()
	{
		assertEquals("|                     To Center                      |\n",
				(new Receipt(new Car())).centerLine("To Center"));
	}
}