package be.avidoo.hexagonal.output.persistence.dossier.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DossierJpaRepository extends JpaRepository<DossierJpaEntity, UUID> {
}
