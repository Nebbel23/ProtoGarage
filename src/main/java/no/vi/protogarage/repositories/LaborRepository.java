package no.vi.protogarage.repositories;

import no.vi.protogarage.models.Labor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborRepository extends JpaRepository<Labor, Long>
{
}