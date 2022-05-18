//e7ba5601-88d2-4420-b877-fbf7c808edc1

package no.vi.protogarage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ProtoGarageApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ProtoGarageApplication.class, args);
		System.out.println("Running!");
		
		//todo Templates class verwijderen
		
		//TODO Bonnetje implementeren!!
		
		
		//TODO Verwijderen
		
		//Car car = mockBrokenCar();
		//Receipt receipt = new Receipt(car);
		//System.out.println(receipt.generate());
	}
	
/*	//region Mocks
	public static Car mockBrokenCar()
	{
		//Parts
		Part blinkerFluid = new Part("Knipperlichtvloeistof", 7999);
		Part brakeDisc = new Part("Remschijf", 4395);
		Part lambdaSensor = new Part("Lambdasensor", 7398);
		Part wiper = new Part("Ruitenwisser", 730);
		
		
		//Labor
		Labor inspection = new Labor("Inspecteren", "Inspecteren van de auto", 30);
		inspection.setFixedPriceCost(4500);		//Inspectie kost altijd €45,-
		Labor wiperLabor = new Labor("Wisser vervangen", "Vervangen van de een ruitenwisser", 15);
		wiperLabor.addPart(wiper);
		Labor brakeDiscLabor = new Labor("Remschijf vervangen", "Vervangen van een remschijf", 60);
		//brakeDiscLabor.addPart(brakeDisc);
		
		
		//Reparations
		Reparation inspectionReparation = new Reparation("Inspectie");
		//inspectionReparation.addLabor(inspection);
		
		Reparation replaceWiper = new Reparation("Ruitenwisser vervangen");
		//replaceWiper.addLabor(wiperLabor);
		
		Reparation replaceFrontBrakeDiscs = new Reparation("Remschijven voor vervangen");
		//replaceFrontBrakeDiscs.addLabor(brakeDiscLabor);
		//replaceFrontBrakeDiscs.addLabor(brakeDiscLabor);
		
		Part tempPart = new Part("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz", 4599);
		Labor tempLabor = new Labor("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz", "X", 1234567890);
		//tempLabor.addPart(tempPart);
		Reparation tempReparation = new Reparation("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz");
		//tempReparation.addLabor(tempLabor);
		//tempReparation.addLabor(tempLabor);
		
		//Car
		Car car = new Car();
		//car.addReparation(inspectionReparation);
		//car.addReparation(replaceWiper);
		//car.addReparation(replaceFrontBrakeDiscs);
		//car.addReparation(tempReparation);
		
		return car;
	}*/
}