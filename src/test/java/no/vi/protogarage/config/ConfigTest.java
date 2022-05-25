package no.vi.protogarage.config;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import no.vi.protogarage.enums.AppUserRole;
import no.vi.protogarage.models.AppUser;
import no.vi.protogarage.models.Car;
import no.vi.protogarage.models.Labor;
import no.vi.protogarage.models.Part;
import no.vi.protogarage.models.Reparation;
import no.vi.protogarage.repositories.AppUserRepository;
import no.vi.protogarage.repositories.CarRepository;
import no.vi.protogarage.repositories.LaborRepository;
import no.vi.protogarage.repositories.PartRepository;
import no.vi.protogarage.repositories.ReparationRepository;
import no.vi.protogarage.security.PasswordEncoder;
import no.vi.protogarage.services.LaborService;
import no.vi.protogarage.services.PartService;
import no.vi.protogarage.services.ReparationService;
import org.junit.jupiter.api.Test;

class ConfigTest
{
	/**
	 * Method under test: {@link Config#partCommandLineRunner(PartRepository)}
	 */
	@Test
	void testPartCommandLineRunner() throws Exception
	{
		//   Diffblue Cover was unable to write a Spring test,
		//   so wrote a non-Spring test instead.
		//   Reason: R027 Missing beans when creating Spring context.
		//   Failed to create Spring context due to missing beans:
		//         no.vi.protogarage.repositories.LaborRepository
		//
		//   See https://diff.blue/R027 to resolve this issue.
		
		PasswordEncoder encoder = new PasswordEncoder();
		PartService partService = new PartService();
		LaborService laborService = new LaborService();
		Config config = new Config(encoder, partService, laborService, new ReparationService());
		
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		PartRepository partRepository = mock(PartRepository.class);
		when(partRepository.save((Part) any())).thenReturn(part);
		config.partCommandLineRunner(partRepository).run("foo");
		verify(partRepository, atLeast(1)).save((Part) any());
	}
	
	/**
	 * Method under test: {@link Config#laborCommandLineRunner(LaborRepository)}
	 */
	@Test
	void testLaborCommandLineRunner() throws Exception
	{
		//   Diffblue Cover was unable to write a Spring test,
		//   so wrote a non-Spring test instead.
		//   Reason: R027 Missing beans when creating Spring context.
		//   Failed to create Spring context due to missing beans:
		//         no.vi.protogarage.repositories.ReparationRepository
		//
		//   See https://diff.blue/R027 to resolve this issue.
		
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		PartService partService = mock(PartService.class);
		when(partService.getPartById((Long) any())).thenReturn(part);
		PasswordEncoder encoder = new PasswordEncoder();
		LaborService laborService = new LaborService();
		Config config = new Config(encoder, partService, laborService, new ReparationService());
		
		Part part1 = new Part();
		part1.setCost(1);
		part1.setName("Name");
		
		Labor labor = new Labor();
		labor.addPart(part1);
		labor.setCostPerHour(1);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(1);
		labor.setName("Name");
		LaborRepository laborRepository = mock(LaborRepository.class);
		when(laborRepository.save((Labor) any())).thenReturn(labor);
		config.laborCommandLineRunner(laborRepository).run("foo");
		verify(partService, atLeast(1)).getPartById((Long) any());
		verify(laborRepository, atLeast(1)).save((Labor) any());
	}
	
	/**
	 * Method under test: {@link Config#reparationCommandLineRunner(ReparationRepository)}
	 */
	@Test
	void testReparationCommandLineRunner() throws Exception
	{
		//   Diffblue Cover was unable to write a Spring test,
		//   so wrote a non-Spring test instead.
		//   Reason: R027 Missing beans when creating Spring context.
		//   Failed to create Spring context due to missing beans:
		//         no.vi.protogarage.repositories.CarRepository
		//
		//   See https://diff.blue/R027 to resolve this issue.
		
		Part part = new Part();
		part.setCost(1);
		part.setName("Name");
		
		Labor labor = new Labor();
		labor.addPart(part);
		labor.setCostPerHour(1);
		labor.setDescription("The characteristics of someone or something");
		labor.setDurationInMinutes(1);
		labor.setName("Name");
		LaborService laborService = mock(LaborService.class);
		when(laborService.getLaborById((Long) any())).thenReturn(labor);
		PasswordEncoder encoder = new PasswordEncoder();
		PartService partService = new PartService();
		Config config = new Config(encoder, partService, laborService, new ReparationService());
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		ReparationRepository reparationRepository = mock(ReparationRepository.class);
		when(reparationRepository.save((Reparation) any())).thenReturn(reparation);
		config.reparationCommandLineRunner(reparationRepository).run("foo");
		verify(laborService, atLeast(1)).getLaborById((Long) any());
		verify(reparationRepository, atLeast(1)).save((Reparation) any());
	}
	
	/**
	 * Method under test: {@link Config#carCommandLineRunner(CarRepository)}
	 */
	@Test
	void testCarCommandLineRunner() throws Exception
	{
		//   Diffblue Cover was unable to write a Spring test,
		//   so wrote a non-Spring test instead.
		//   Reason: R027 Missing beans when creating Spring context.
		//   Failed to create Spring context due to missing beans:
		//         no.vi.protogarage.repositories.AppUserRepository
		//
		//   See https://diff.blue/R027 to resolve this issue.
		
		Reparation reparation = new Reparation();
		reparation.setDone(true);
		reparation.setLabor(new ArrayList<>());
		reparation.setName("Name");
		ReparationService reparationService = mock(ReparationService.class);
		when(reparationService.getReparationById((Long) any())).thenReturn(reparation);
		PasswordEncoder encoder = new PasswordEncoder();
		PartService partService = new PartService();
		Config config = new Config(encoder, partService, new LaborService(), reparationService);
		
		Car car = new Car();
		car.setAtShop(true);
		car.setExecuteStatus(true);
		car.setPapersId("42");
		car.setPayed(true);
		car.setRegistration("Registration");
		car.setReparations(new ArrayList<>());
		CarRepository carRepository = mock(CarRepository.class);
		when(carRepository.save((Car) any())).thenReturn(car);
		config.carCommandLineRunner(carRepository).run("foo");
		verify(reparationService, atLeast(1)).getReparationById((Long) any());
		verify(carRepository, atLeast(1)).save((Car) any());
	}
	
	/**
	 * Method under test: {@link Config#appUserCommandLineRunner(AppUserRepository)}
	 */
	@Test
	void testAppUserCommandLineRunner() throws Exception
	{
		//   Diffblue Cover was unable to write a Spring test,
		//   so wrote a non-Spring test instead.
		//   Reason: R004 No meaningful assertions found.
		//   Diffblue Cover was unable to create an assertion.
		//   Make sure that fields modified by appUserCommandLineRunner(AppUserRepository)
		//   have package-private, protected, or public getters.
		//   See https://diff.blue/R004 to resolve this issue.
		
		PasswordEncoder encoder = new PasswordEncoder();
		PartService partService = new PartService();
		LaborService laborService = new LaborService();
		Config config = new Config(encoder, partService, laborService, new ReparationService());
		
		AppUser appUser = new AppUser();
		appUser.setAppUserRole(AppUserRole.ADMIN);
		appUser.setEnabled(true);
		appUser.setId(123L);
		appUser.setLocked(true);
		appUser.setName("Name");
		appUser.setPassword("iloveyou");
		appUser.setUsername("janedoe");
		AppUserRepository appUserRepository = mock(AppUserRepository.class);
		when(appUserRepository.save((AppUser) any())).thenReturn(appUser);
		config.appUserCommandLineRunner(appUserRepository).run("foo");
		verify(appUserRepository, atLeast(1)).save((AppUser) any());
	}
}

