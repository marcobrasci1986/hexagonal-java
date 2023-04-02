package be.avidoo.hexagonal.domain.audit;

import be.avidoo.hexagonal.domain.EntityId;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class AuditId extends EntityId<UUID> {

    public static AuditId of(UUID id) {
        return AuditId.builder().value(id).build();
    }

    public static AuditId create() {
        return AuditId.builder().value(UUID.randomUUID()).build();
    }

    @Builder
    public AuditId(UUID value) {
        super(value);
    }
}
