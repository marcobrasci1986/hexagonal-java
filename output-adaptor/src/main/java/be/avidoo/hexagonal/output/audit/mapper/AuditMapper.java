package be.avidoo.hexagonal.output.audit.mapper;

import be.avidoo.hexagonal.domain.audit.Audit;
import be.avidoo.hexagonal.domain.audit.AuditId;
import be.avidoo.hexagonal.output.EntityMapper;
import be.avidoo.hexagonal.output.audit.jpa.AuditJpaEntity;
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
