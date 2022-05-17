package no.vi.protogarage.config;

import no.vi.protogarage.enums.AppUserRole;

import no.vi.protogarage.models.*;
import no.vi.protogarage.repositories.*;
import no.vi.protogarage.security.PasswordEncoder;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class Config
{
	private final PasswordEncoder encoder;
	
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
		//todo SEPARATE AND MAKE INDIVIDUAL CONFIGS
		return args ->
		{
			Labor inspection = new Labor("Inspecteren", "Inspecteren van de auto", 30);
			inspection.setFixedPriceCost(4500);					//Inspectie kost altijd €45,-
			Labor wiperLabor = new Labor("Wisser vervangen", "Vervangen van de een ruitenwisser", 15);
			//wiperLabor.addPart(wiper);
			Labor brakeDiscLabor = new Labor("Remschijf vervangen", "Vervangen van een remschijf", 60);
			//brakeDiscLabor.addPart(brakeDisc);
			
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
			//inspectionReparation.addLabor(inspection);
			
			Reparation replaceWiper = new Reparation("Ruitenwisser vervangen");
			//replaceWiper.addLabor(wiperLabor);
			
			Reparation replaceFrontBrakeDiscs = new Reparation("Remschijven voor vervangen");
			//replaceFrontBrakeDiscs.addLabor(brakeDiscLabor);
			//replaceFrontBrakeDiscs.addLabor(brakeDiscLabor);
			
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
			//car.addReparation(inspectionReparation);
			//car.addReparation(replaceWiper);
			//car.addReparation(replaceFrontBrakeDiscs);
			//car.addReparation(tempReparation);
			
			repo.save(car);
		};
	}
	
	@Bean
	CommandLineRunner appUserCommandLineRunner(AppUserRepository appUserRepository)
	{
		return args ->
		{
			//todo UserRoles toevoegen
			AppUser admin = new AppUser("Niels", "AppAdmin", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.ADMIN, false, true);
			AppUser appUser = new AppUser("Rick", "AppUser", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.MECHANIC, false, true);
			appUserRepository.save(admin);
			appUserRepository.save(appUser);
		};
	}
}