package be.avidoo.hexagonal.framework.features.audit.adaptor.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditJpaRepository extends JpaRepository<AuditJpaEntity, Long> {
}
