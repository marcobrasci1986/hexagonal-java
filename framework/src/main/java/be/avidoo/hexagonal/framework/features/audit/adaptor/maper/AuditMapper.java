package be.avidoo.hexagonal.framework.features.audit.adaptor.maper;

import be.avidoo.hexagonal.domain.audit.Audit;
import be.avidoo.hexagonal.domain.audit.AuditId;
import be.avidoo.hexagonal.framework.EntityMapper;
import be.avidoo.hexagonal.framework.features.audit.adaptor.output.jpa.AuditJpaEntity;
import org.springframework.stereotype.Service;

@Service
public class AuditMapper implements EntityMapper<Audit, AuditJpaEntity> {

    public AuditJpaEntity toJpaEntity(Audit audit) {
        return AuditJpaEntity.builder()
                .id(audit.getId().getValue())
                .event(audit.getEvent())
                .timestamp(audit.getTimestamp())
                .build();
    }

    public Audit toDomainEntity(AuditJpaEntity audit) {
        return Audit.builder()
                .id(AuditId.of(audit.getId()))
                .event(audit.getEvent())
                .timestamp(audit.getTimestamp())
                .build();
    }

}
