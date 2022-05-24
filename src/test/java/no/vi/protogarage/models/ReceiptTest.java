package no.vi.protogarage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class ReceiptTest
{
	/**
	 * Method under test: {@link Receipt#Receipt(Car)}
	 */
	@Test
	void testConstructor()
	{
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Receipt.GARAGE_NAME
		//     Receipt.INDENT_SPACES
		//     Receipt.STANDARD_WIDTH
		//     Receipt.MIN_WIDTH
		//     Receipt.width
		//     Receipt.car
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		new Receipt(car);
	}
	
	/**
	 * Method under test: {@link Receipt#Receipt(Car, int)}
	 */
	@Test
	void testConstructor2()
	{
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Receipt.GARAGE_NAME
		//     Receipt.INDENT_SPACES
		//     Receipt.STANDARD_WIDTH
		//     Receipt.MIN_WIDTH
		//     Receipt.width
		//     Receipt.car
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		new Receipt(car, 1);
		
	}
	
	/**
	 * Method under test: {@link Receipt#Receipt(Car, int)}
	 */
	@Test
	void testConstructor3()
	{
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Receipt.GARAGE_NAME
		//     Receipt.INDENT_SPACES
		//     Receipt.STANDARD_WIDTH
		//     Receipt.MIN_WIDTH
		//     Receipt.width
		//     Receipt.car
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		new Receipt(car, 42);
		
	}
	
	/**
	 * Method under test: {@link Receipt#Receipt(Car)}
	 */
	@Test
	void testConstructor4()
	{
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Receipt.GARAGE_NAME
		//     Receipt.INDENT_SPACES
		//     Receipt.STANDARD_WIDTH
		//     Receipt.MIN_WIDTH
		//     Receipt.width
		//     Receipt.car
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		new Receipt(car);
	}
	
	/**
	 * Method under test: {@link Receipt#Receipt(Car, int)}
	 */
	@Test
	void testConstructor5()
	{
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Receipt.GARAGE_NAME
		//     Receipt.INDENT_SPACES
		//     Receipt.STANDARD_WIDTH
		//     Receipt.MIN_WIDTH
		//     Receipt.width
		//     Receipt.car
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		new Receipt(car, 1);
		
	}
	
	/**
	 * Method under test: {@link Receipt#Receipt(Car, int)}
	 */
	@Test
	void testConstructor6()
	{
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Receipt.GARAGE_NAME
		//     Receipt.INDENT_SPACES
		//     Receipt.STANDARD_WIDTH
		//     Receipt.MIN_WIDTH
		//     Receipt.width
		//     Receipt.car
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		new Receipt(car, 42);
		
	}
	
	/**
	 * Method under test: {@link Receipt#generate()}
	 */
	@Test
	void testGenerate()
	{
		assertEquals(
				"|                                                              |\n"
						+ "+--------------------------------------------------------------+\n"
						+ "|                                                              |\n"
						+ "|                            Garagé                            |\n"
						+ "|                                                              |\n"
						+ "|             De geautomatiseerde autospeciaalzaak             |\n"
						+ "|                                                              |\n"
						+ "|                                                              |\n"
						+ "|  ---------------------------------------------------------   |\n"
						+ "|                                                              |\n"
						+ "|                                                              |\n"
						+ "|  ---------------------------------------------------------   |\n"
						+ "| Totaal excl. BTW                                       €0.00 |\n"
						+ "| BTW                                                    €0.00 |\n"
						+ "| Totaal                                                 €0.00 |\n"
						+ "|                                                              |\n"
						+ "+--------------------------------------------------------------+\n",
				(new Receipt(new Car())).generate());
		assertEquals(
				"|                                                              |\n"
						+ "+--------------------------------------------------------------+\n"
						+ "|                                                              |\n"
						+ "|                            Garagé                            |\n"
						+ "|                                                              |\n"
						+ "|             De geautomatiseerde autospeciaalzaak             |\n"
						+ "|                                                              |\n"
						+ "|                                                              |\n"
						+ "|  ---------------------------------------------------------   |\n"
						+ "|                                                              |\n"
						+ "|                                                              |\n"
						+ "|  ---------------------------------------------------------   |\n"
						+ "| Totaal excl. BTW                                       €0.00 |\n"
						+ "| BTW                                                    €0.00 |\n"
						+ "| Totaal                                                 €0.00 |\n"
						+ "|                                                              |\n"
						+ "+--------------------------------------------------------------+\n",
				(new Receipt(new Car())).generate());
	}
	
	/**
	 * Method under test: {@link Receipt#generate()}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGenerate2()
	{
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "no.vi.protogarage.models.Car.getReparations()" because "this.car" is null
		//       at no.vi.protogarage.models.Receipt.generate(Receipt.java:53)
		//   In order to prevent generate()
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   generate().
		//   See https://diff.blue/R013 to resolve this issue.
		
		(new Receipt(null)).generate();
	}
	
	/**
	 * Method under test: {@link Receipt#generate()}
	 */
	@Test
	void testGenerate3()
	{
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("|");
		
		Car car = new Car();
		car.addReparation(reparation);
		assertEquals("|                                                              |\n"
				+ "+--------------------------------------------------------------+\n"
				+ "|                                                              |\n"
				+ "|                            Garagé                            |\n"
				+ "|                                                              |\n"
				+ "|             De geautomatiseerde autospeciaalzaak             |\n"
				+ "|                                                              |\n"
				+ "|                                                              |\n"
				+ "|  ---------------------------------------------------------   |\n"
				+ "|                                                              |\n"
				+ "| |                                                      €0.00 |\n"
				+ "|                                                              |\n"
				+ "|                                                              |\n"
				+ "|  ---------------------------------------------------------   |\n"
				+ "| Totaal excl. BTW                                       €0.00 |\n"
				+ "| BTW                                                    €0.00 |\n"
				+ "| Totaal                                                 €0.00 |\n"
				+ "|                                                              |\n"
				+ "+--------------------------------------------------------------+\n", (new Receipt(car)).generate());
	}
	
	/**
	 * Method under test: {@link Receipt#generate()}
	 */
	@Test
	void testGenerate4()
	{
		Part part = new Part();
		part.setCost(62);
		part.setName("|");
		
		Labor labor = new Labor();
		labor.addPart(part);
		labor.setCostPerHour(62);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(62);
		labor.setName("|");
		
		ArrayList<Labor> laborList = new ArrayList<>();
		laborList.add(labor);
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(laborList);
		reparation.setName("|");
		
		Car car = new Car();
		car.addReparation(reparation);
		assertEquals("|                                                              |\n"
				+ "+--------------------------------------------------------------+\n"
				+ "|                                                              |\n"
				+ "|                            Garagé                            |\n"
				+ "|                                                              |\n"
				+ "|             De geautomatiseerde autospeciaalzaak             |\n"
				+ "|                                                              |\n"
				+ "|                                                              |\n"
				+ "|  ---------------------------------------------------------   |\n"
				+ "|                                                              |\n"
				+ "| |                                                      €1.26 |\n"
				+ "|     Arbeid (62 min)                                    €0.64 |\n"
				+ "|         |                                              €0.62 |\n"
				+ "|                                                              |\n"
				+ "|                                                              |\n"
				+ "|  ---------------------------------------------------------   |\n"
				+ "| Totaal excl. BTW                                       €1.26 |\n"
				+ "| BTW                                                    €0.26 |\n"
				+ "| Totaal                                                 €1.52 |\n"
				+ "|                                                              |\n"
				+ "+--------------------------------------------------------------+\n", (new Receipt(car)).generate());
	}
	
	/**
	 * Method under test: {@link Receipt#generate()}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGenerate5()
	{
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "no.vi.protogarage.models.Car.getReparations()" because "this.car" is null
		//       at no.vi.protogarage.models.Receipt.generate(Receipt.java:53)
		//   In order to prevent generate()
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   generate().
		//   See https://diff.blue/R013 to resolve this issue.
		
		(new Receipt(null)).generate();
	}
	
	/**
	 * Method under test: {@link Receipt#generate()}
	 */
	@Test
	void testGenerate6()
	{
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("|");
		
		Car car = new Car();
		car.addReparation(reparation);
		assertEquals("|                                                              |\n"
				+ "+--------------------------------------------------------------+\n"
				+ "|                                                              |\n"
				+ "|                            Garagé                            |\n"
				+ "|                                                              |\n"
				+ "|             De geautomatiseerde autospeciaalzaak             |\n"
				+ "|                                                              |\n"
				+ "|                                                              |\n"
				+ "|  ---------------------------------------------------------   |\n"
				+ "|                                                              |\n"
				+ "| |                                                      €0.00 |\n"
				+ "|                                                              |\n"
				+ "|                                                              |\n"
				+ "|  ---------------------------------------------------------   |\n"
				+ "| Totaal excl. BTW                                       €0.00 |\n"
				+ "| BTW                                                    €0.00 |\n"
				+ "| Totaal                                                 €0.00 |\n"
				+ "|                                                              |\n"
				+ "+--------------------------------------------------------------+\n", (new Receipt(car)).generate());
	}
	
	/**
	 * Method under test: {@link Receipt#generate()}
	 */
	@Test
	void testGenerate7()
	{
		Part part = new Part();
		part.setCost(62);
		part.setName("|");
		
		Labor labor = new Labor();
		labor.addPart(part);
		labor.setCostPerHour(62);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(62);
		labor.setName("|");
		
		ArrayList<Labor> laborList = new ArrayList<>();
		laborList.add(labor);
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(laborList);
		reparation.setName("|");
		
		Car car = new Car();
		car.addReparation(reparation);
		assertEquals("|                                                              |\n"
				+ "+--------------------------------------------------------------+\n"
				+ "|                                                              |\n"
				+ "|                            Garagé                            |\n"
				+ "|                                                              |\n"
				+ "|             De geautomatiseerde autospeciaalzaak             |\n"
				+ "|                                                              |\n"
				+ "|                                                              |\n"
				+ "|  ---------------------------------------------------------   |\n"
				+ "|                                                              |\n"
				+ "| |                                                      €1.26 |\n"
				+ "|     Arbeid (62 min)                                    €0.64 |\n"
				+ "|         |                                              €0.62 |\n"
				+ "|                                                              |\n"
				+ "|                                                              |\n"
				+ "|  ---------------------------------------------------------   |\n"
				+ "| Totaal excl. BTW                                       €1.26 |\n"
				+ "| BTW                                                    €0.26 |\n"
				+ "| Totaal                                                 €1.52 |\n"
				+ "|                                                              |\n"
				+ "+--------------------------------------------------------------+\n", (new Receipt(car)).generate());
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
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(reparationList);
		assertEquals(0, receipt.calcPriceWithoutVAT(car));
	}
	
	/**
	 * Method under test: {@link Receipt#calcPriceWithoutVAT(Car)}
	 */
	@Test
	void testCalcPriceWithoutVAT3()
	{
		Receipt receipt = new Receipt(new Car());
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		assertEquals(0, receipt.calcPriceWithoutVAT(car));
	}
	
	/**
	 * Method under test: {@link Receipt#calcPriceWithoutVAT(Car)}
	 */
	@Test
	void testCalcPriceWithoutVAT4()
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
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(reparationList);
		assertEquals(0, receipt.calcVAT(car));
	}
	
	/**
	 * Method under test: {@link Receipt#calcVAT(Car)}
	 */
	@Test
	void testCalcVAT3()
	{
		Receipt receipt = new Receipt(new Car());
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		assertEquals(0, receipt.calcVAT(car));
	}
	
	/**
	 * Method under test: {@link Receipt#calcVAT(Car)}
	 */
	@Test
	void testCalcVAT4()
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
		assertEquals(
				"| Name                                                   €0.00 |\n"
						+ "|                                                              |\n",
				receipt.printReparation(reparation));
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
		assertEquals(
				"| Name                                                   €0.01 |\n"
						+ "|     Arbeid (1 min)                                     €0.00 |\n"
						+ "|         %.2f                                           €0.01 |\n"
						+ "|                                                              |\n",
				receipt.printReparation(reparation));
	}
	
	/**
	 * Method under test: {@link Receipt#printReparation(Reparation)}
	 */
	@Test
	void testPrintReparation3()
	{
		Receipt receipt = new Receipt(new Car());
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		assertEquals(
				"| Name                                                   €0.00 |\n"
						+ "|                                                              |\n",
				receipt.printReparation(reparation));
	}
	
	/**
	 * Method under test: {@link Receipt#printReparation(Reparation)}
	 */
	@Test
	void testPrintReparation4()
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
		assertEquals(
				"| Name                                                   €0.01 |\n"
						+ "|     Arbeid (1 min)                                     €0.00 |\n"
						+ "|         %.2f                                           €0.01 |\n"
						+ "|                                                              |\n",
				receipt.printReparation(reparation));
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
		assertEquals("|     Arbeid (1 min)                                     €0.00 |\n"
				+ "|         Name                                           €0.01 |\n", receipt.printLabor(labor));
	}
	
	/**
	 * Method under test: {@link Receipt#printLabor(Labor)}
	 */
	@Test
	void testPrintLabor2()
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
		assertEquals("|     Arbeid (1 min)                                     €0.00 |\n"
				+ "|         Name                                           €0.01 |\n", receipt.printLabor(labor));
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
		assertEquals("|         Name                                           €0.01 |\n", receipt.printPart(part));
	}
	
	/**
	 * Method under test: {@link Receipt#printPart(Part)}
	 */
	@Test
	void testPrintPart2()
	{
		Receipt receipt = new Receipt(new Car());
		
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		assertEquals("|         Name                                           €0.01 |\n", receipt.printPart(part));
	}
	
	/**
	 * Method under test: {@link Receipt#centerLine(String)}
	 */
	@Test
	void testCenterLine()
	{
		assertEquals("|                          To Center                           |\n",
				(new Receipt(new Car())).centerLine("To Center"));
		assertEquals("|                          To Center                           |\n",
				(new Receipt(new Car())).centerLine("To Center"));
	}
}

