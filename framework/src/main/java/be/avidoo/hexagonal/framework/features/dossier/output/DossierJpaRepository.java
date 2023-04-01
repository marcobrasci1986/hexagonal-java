package be.avidoo.hexagonal.framework.features.dossier.output;

import be.avidoo.hexagonal.framework.features.dossier.jpa.DossierJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DossierJpaRepository extends JpaRepository<DossierJpaEntity, UUID> {
}
