package no.vi.protogarage.services;

import lombok.AllArgsConstructor;
import no.vi.protogarage.models.AppUser;
import no.vi.protogarage.repositories.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService
{
	private final AppUserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		//todo kijken of hij geen null geeft en misschien afvangen
		return repo.findByUsername(username);
	}
}