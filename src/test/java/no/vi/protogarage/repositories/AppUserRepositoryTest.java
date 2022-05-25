package no.vi.protogarage.repositories;

import static org.junit.jupiter.api.Assertions.assertNull;

import no.vi.protogarage.enums.AppUserRole;
import no.vi.protogarage.models.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {AppUserRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"no.vi.protogarage.models"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class AppUserRepositoryTest
{
	@Autowired
	private AppUserRepository appUserRepository;
	
	/**
	 * Method under test: {@link AppUserRepository#findByUsername(String)}
	 */
	@Test
	void testFindByUsername()
	{
		AppUser appUser = new AppUser();
		appUser.setAppUserRole(AppUserRole.ADMIN);
		appUser.setEnabled(true);
		appUser.setLocked(true);
		appUser.setName("Name");
		appUser.setPassword("iloveyou");
		appUser.setUsername("janedoe");
		
		AppUser appUser1 = new AppUser();
		appUser1.setAppUserRole(AppUserRole.ADMIN);
		appUser1.setEnabled(true);
		appUser1.setLocked(true);
		appUser1.setName("Name");
		appUser1.setPassword("iloveyou");
		appUser1.setUsername("janedoe");
		this.appUserRepository.save(appUser);
		this.appUserRepository.save(appUser1);
		assertNull(this.appUserRepository.findByUsername("foo"));
	}
}