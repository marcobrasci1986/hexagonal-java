package be.avidoo.hexagonal.output.audit.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditJpaRepository extends JpaRepository<AuditJpaEntity, Long> {
}
