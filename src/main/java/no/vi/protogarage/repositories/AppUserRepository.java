package no.vi.protogarage.repositories;

import no.vi.protogarage.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>
{
	@Query("SELECT s FROM AppUser s WHERE s.username = ?1")
	UserDetails findByUsername(String username);
}