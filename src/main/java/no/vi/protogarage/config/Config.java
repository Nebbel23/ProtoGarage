package no.vi.protogarage.config;

import no.vi.protogarage.enums.AppUserRole;

import no.vi.protogarage.models.*;
import no.vi.protogarage.repositories.*;
import no.vi.protogarage.security.PasswordEncoder;

import lombok.AllArgsConstructor;
import no.vi.protogarage.services.LaborService;
import no.vi.protogarage.services.PartService;
import no.vi.protogarage.services.ReparationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class Config
{
	private final PasswordEncoder encoder;
	
	private final PartService partService;
	private final LaborService laborService;
	private final ReparationService reparationService;
	
	@Bean
	CommandLineRunner partCommandLineRunner(PartRepository partRepository)
	{
		return args ->
		{
			Part blinkerFluid = new Part("Knipperlichtvloeistof", 7999);
			Part brakeDisc = new Part("Remschijf", 4395);
			Part lambdaSensor = new Part("Lambdasensor", 7398);
			Part wiper = new Part("Ruitenwisser", 730);
			
			partRepository.save(blinkerFluid);
			partRepository.save(brakeDisc);
			partRepository.save(lambdaSensor);
			partRepository.save(wiper);
		};
	}
	
	@Bean
	CommandLineRunner laborCommandLineRunner(LaborRepository laborRepository)
	{
		return args ->
		{
			Labor inspection = new Labor("Inspecteren", "Inspecteren van de auto", 30);
			inspection.setFixedPriceCost(4500);                    //Inspectie kost altijd €45,-
			Labor wiperLabor = new Labor("Wisser vervangen", "Vervangen van de een ruitenwisser", 15);
			wiperLabor.addPart(partService.getPartById(4L));    //Wiper heeft 4 als id
			Labor brakeDiscLabor = new Labor("Remschijf vervangen", "Vervangen van een remschijf", 60);
			brakeDiscLabor.addPart(partService.getPartById(2L));
			
			laborRepository.save(inspection);
			laborRepository.save(wiperLabor);
			laborRepository.save(brakeDiscLabor);
		};
	}
	
	@Bean
	CommandLineRunner reparationCommandLineRunner(ReparationRepository reparationRepository)
	{
		return args ->
		{
			Reparation inspectionReparation = new Reparation("Inspectie");
			inspectionReparation.addLabor(laborService.getLaborById(1L));
			
			Reparation replaceWiper = new Reparation("Ruitenwisser vervangen");
			replaceWiper.addLabor(laborService.getLaborById(2L));
			
			Reparation replaceFrontBrakeDiscs = new Reparation("Remschijven voor vervangen");
			replaceFrontBrakeDiscs.addLabor(laborService.getLaborById(3L));
			replaceFrontBrakeDiscs.addLabor(laborService.getLaborById(3L));
			
			reparationRepository.save(inspectionReparation);
			reparationRepository.save(replaceWiper);
			reparationRepository.save(replaceFrontBrakeDiscs);
		};
	}
	
	@Bean
	CommandLineRunner carCommandLineRunner(CarRepository carRepository)
	{
		return args ->
		{
			Car mitsubishi = new Car();
			mitsubishi.setRegistration("NF-XN-02");
			mitsubishi.setPayed(false);
			mitsubishi.setAtShop(true);
			
			mitsubishi.addReparation(reparationService.getReparationById(1L));
			mitsubishi.addReparation(reparationService.getReparationById(2L));
			mitsubishi.addReparation(reparationService.getReparationById(3L));
			
			Car kia = new Car();
			kia.setRegistration("16-SJ-PZ");
			kia.setPayed(false);
			kia.setAtShop(true);
			
			kia.addReparation(reparationService.getReparationById(2L));
			
			Car ford = new Car();
			ford.setRegistration("74-JZB-9");
			ford.setPayed(true);
			ford.setAtShop(false);
			
			ford.addReparation(reparationService.getReparationById(1L));
			ford.addReparation(reparationService.getReparationById(3L));
			
			carRepository.save(mitsubishi);
			carRepository.save(kia);
			carRepository.save(ford);
		};
	}
	
	@Bean
	CommandLineRunner appUserCommandLineRunner(AppUserRepository appUserRepository)
	{
		return args ->
		{
			AppUser admin = new AppUser("Arnold", "admin", encoder.bCryptPasswordEncoder().encode("admin"), AppUserRole.ADMIN, false, true);
			AppUser backoffice = new AppUser("Bob", "backoffice", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.BACKOFFICE, false, true);
			AppUser cashier = new AppUser("Karin", "cashier", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.CASHIER, false, true);
			AppUser mechanic = new AppUser("Mark", "mechanic", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.MECHANIC, false, true);
			
			appUserRepository.save(admin);
			appUserRepository.save(backoffice);
			appUserRepository.save(cashier);
			appUserRepository.save(mechanic);
		};
	}
}