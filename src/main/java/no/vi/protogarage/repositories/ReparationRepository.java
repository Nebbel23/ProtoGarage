package no.vi.protogarage.repositories;

import no.vi.protogarage.models.Reparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, Long>
{
}