package be.avidoo.hexagonal.framework.features.dossier.adaptor.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DossierJpaRepository extends JpaRepository<DossierJpaEntity, UUID> {
}
