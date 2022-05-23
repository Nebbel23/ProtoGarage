package no.vi.protogarage.config;

import no.vi.protogarage.enums.AppUserRole;

import no.vi.protogarage.models.*;
import no.vi.protogarage.repositories.*;
import no.vi.protogarage.security.PasswordEncoder;

import lombok.AllArgsConstructor;
import no.vi.protogarage.services.CarService;
import no.vi.protogarage.services.LaborService;
import no.vi.protogarage.services.PartService;
import no.vi.protogarage.services.ReparationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@AllArgsConstructor
@Configuration
public class Config
{
	private final PasswordEncoder encoder;
	
	private final PartService partService;
	private final LaborService laborService;
	private final ReparationService reparationService;
	private final CarService carService;
	
	@Bean
	CommandLineRunner partCommandLineRunner(PartRepository repo)
	{
		return args ->
		{
			Part blinkerFluid = new Part("Knipperlichtvloeistof", 7999);
			Part brakeDisc = new Part("Remschijf", 4395);
			Part lambdaSensor = new Part("Lambdasensor", 7398);
			Part wiper = new Part("Ruitenwisser", 730);
			
			repo.save(blinkerFluid);
			repo.save(brakeDisc);
			repo.save(lambdaSensor);
			repo.save(wiper);
		};
	}
	
	@Bean
	CommandLineRunner laborCommandLineRunner(LaborRepository repo)
	{
		return args ->
		{
			Labor inspection = new Labor("Inspecteren", "Inspecteren van de auto", 30);
			inspection.setFixedPriceCost(4500);					//Inspectie kost altijd €45,-
			Labor wiperLabor = new Labor("Wisser vervangen", "Vervangen van de een ruitenwisser", 15);
			wiperLabor.addPart(partService.getPartById(4l));	//Wiper heeft 4 als id
			Labor brakeDiscLabor = new Labor("Remschijf vervangen", "Vervangen van een remschijf", 60);
			brakeDiscLabor.addPart(partService.getPartById(2l));
			
			repo.save(inspection);
			repo.save(wiperLabor);
			repo.save(brakeDiscLabor);
		};
	}
	
	@Bean
	CommandLineRunner reparationCommandLineRunner(ReparationRepository repo)
	{
		return args ->
		{
			Reparation inspectionReparation = new Reparation("Inspectie");
			inspectionReparation.addLabor(laborService.getLaborById(1l));
			
			Reparation replaceWiper = new Reparation("Ruitenwisser vervangen");
			replaceWiper.addLabor(laborService.getLaborById(2l));
			
			Reparation replaceFrontBrakeDiscs = new Reparation("Remschijven voor vervangen");
			replaceFrontBrakeDiscs.addLabor(laborService.getLaborById(3l));
			//replaceFrontBrakeDiscs.addLabor(laborService.getLaborById(3l));
			
			repo.save(inspectionReparation);
			repo.save(replaceWiper);
			repo.save(replaceFrontBrakeDiscs);
		};
	}
	
	@Bean
	CommandLineRunner carCommandLineRunner(CarRepository repo)
	{
		return args ->
		{
			Car car = new Car();
			car.setRegistration("NF-XN-02");
			car.setPayed(false);
			car.setAtShop(true);
			
			car.addReparation(reparationService.getReparationById(1l));
			car.addReparation(reparationService.getReparationById(2l));
			car.addReparation(reparationService.getReparationById(3l));
			
			repo.save(car);
			
			Receipt receipt = new Receipt(carService.getCarById(1l));
			//System.out.println(receipt.generate());
		};
	}
	
	@Bean
	CommandLineRunner appUserCommandLineRunner(AppUserRepository appUserRepository)
	{
		return args ->
		{
			//todo UserRoles toevoegen
			AppUser admin = new AppUser("Niels", "admin", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.ADMIN, false, true);
			AppUser appUser = new AppUser("Rick", "mechanic", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.MECHANIC, false, true);
			appUserRepository.save(admin);
			appUserRepository.save(appUser);
		};
	}
}