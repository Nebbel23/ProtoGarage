package no.vi.protogarage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import no.vi.protogarage.enums.AppUserRole;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class AppUserTest
{
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link AppUser#AppUser(String, String, String, AppUserRole, boolean, boolean)}
	 *   <li>{@link AppUser#getPassword()}
	 *   <li>{@link AppUser#getUsername()}
	 *   <li>{@link AppUser#isAccountNonExpired()}
	 *   <li>{@link AppUser#isCredentialsNonExpired()}
	 *   <li>{@link AppUser#isEnabled()}
	 * </ul>
	 */
	@Test
	void testConstructor()
	{
		AppUser actualAppUser = new AppUser("Name", "janedoe", "iloveyou", AppUserRole.ADMIN, true, true);
		
		assertEquals("iloveyou", actualAppUser.getPassword());
		assertEquals("janedoe", actualAppUser.getUsername());
		assertTrue(actualAppUser.isAccountNonExpired());
		assertTrue(actualAppUser.isCredentialsNonExpired());
		assertTrue(actualAppUser.isEnabled());
	}
	
	/**
	 * Method under test: {@link AppUser#getAuthorities()}
	 */
	@Test
	void testGetAuthorities2()
	{
		AppUser appUser = new AppUser();
		appUser.setAppUserRole(AppUserRole.ADMIN);
		appUser.setEnabled(true);
		appUser.setId(123L);
		appUser.setLocked(true);
		appUser.setName("Name");
		appUser.setPassword("iloveyou");
		appUser.setUsername("janedoe");
		Collection<? extends GrantedAuthority> actualAuthorities = appUser.getAuthorities();
		assertEquals(1, actualAuthorities.size());
		assertEquals("ADMIN", ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
	}
	
	/**
	 * Method under test: {@link AppUser#isAccountNonLocked()}
	 */
	@Test
	void testIsAccountNonLocked()
	{
		assertTrue((new AppUser()).isAccountNonLocked());
	}
	
	/**
	 * Method under test: {@link AppUser#isAccountNonLocked()}
	 */
	@Test
	void testIsAccountNonLocked2()
	{
		AppUser appUser = new AppUser();
		appUser.setAppUserRole(AppUserRole.ADMIN);
		appUser.setEnabled(true);
		appUser.setId(123L);
		appUser.setLocked(true);
		appUser.setName("Name");
		appUser.setPassword("iloveyou");
		appUser.setUsername("janedoe");
		assertFalse(appUser.isAccountNonLocked());
	}
}