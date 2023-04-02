package be.avidoo.hexagonal.framework.features.audit.jpa.output;

import be.avidoo.hexagonal.framework.features.audit.jpa.AuditJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditJpaRepository extends JpaRepository<AuditJpaEntity, Long> {
}
