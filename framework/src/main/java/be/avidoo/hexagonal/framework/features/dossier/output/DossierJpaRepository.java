package be.avidoo.hexagonal.framework.features.dossier.output;

import be.avidoo.hexagonal.framework.features.dossier.data.DossierJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierJpaRepository extends JpaRepository<DossierJpaEntity, Long> {
}
