package be.avidoo.hexagonal.output.persistence.audit;

import be.avidoo.hexagonal.application.audit.ports.output.AuditOutputPort;
import be.avidoo.hexagonal.domain.audit.Audit;
import be.avidoo.hexagonal.output.persistence.audit.jpa.AuditJpaEntity;
import be.avidoo.hexagonal.output.persistence.audit.jpa.AuditJpaRepository;
import be.avidoo.hexagonal.output.persistence.audit.jpa.mapper.AuditMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuditPersistenceAdaptor implements AuditOutputPort {

    private final AuditJpaRepository auditJpaRepository;
    private final AuditMapper auditMapper;


    @Override
    public Audit save(Audit audit) {
        AuditJpaEntity auditJpaEntity = auditMapper.toJpaEntity(audit);
        AuditJpaEntity savedAudit = auditJpaRepository.save(auditJpaEntity);
        return auditMapper.toDomainEntity(savedAudit);
    }
}
