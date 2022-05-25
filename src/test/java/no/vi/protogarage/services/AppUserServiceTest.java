package no.vi.protogarage.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import no.vi.protogarage.enums.AppUserRole;
import no.vi.protogarage.models.AppUser;
import no.vi.protogarage.repositories.AppUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AppUserService.class})
@ExtendWith(SpringExtension.class)
class AppUserServiceTest
{
	@MockBean
	private AppUserRepository appUserRepository;
	
	@Autowired
	private AppUserService appUserService;
	
	/**
	 * Method under test: {@link AppUserService#loadUserByUsername(String)}
	 */
	@Test
	void testLoadUserByUsername() throws UsernameNotFoundException
	{
		AppUser appUser = new AppUser("Name", "janedoe", "iloveyou", AppUserRole.ADMIN, true, true);
		
		when(this.appUserRepository.findByUsername((String) any())).thenReturn(appUser);
		assertSame(appUser, this.appUserService.loadUserByUsername("janedoe"));
		verify(this.appUserRepository).findByUsername((String) any());
	}
	
	/**
	 * Method under test: {@link AppUserService#loadUserByUsername(String)}
	 */
	@Test
	void testLoadUserByUsername2() throws UsernameNotFoundException
	{
		when(this.appUserRepository.findByUsername((String) any())).thenThrow(new UsernameNotFoundException("Msg"));
		assertThrows(UsernameNotFoundException.class, () -> this.appUserService.loadUserByUsername("janedoe"));
		verify(this.appUserRepository).findByUsername((String) any());
	}
}