package be.avidoo.hexagonal.framework.features.audit.jpa.output;

import be.avidoo.hexagonal.application.dossier.ports.output.AuditOutputPort;
import be.avidoo.hexagonal.domain.audit.Audit;
import be.avidoo.hexagonal.framework.features.audit.jpa.AuditJpaEntity;
import be.avidoo.hexagonal.framework.features.audit.maper.AuditMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuditJpaAdaptor implements AuditOutputPort {

    private final AuditJpaRepository auditJpaRepository;
    private final AuditMapper auditMapper;


    @Override
    public Audit save(Audit audit) {
        AuditJpaEntity auditJpaEntity = auditMapper.toJpaEntity(audit);
        AuditJpaEntity savedAudit = auditJpaRepository.save(auditJpaEntity);
        return auditMapper.toDomainEntity(savedAudit);
    }
}
