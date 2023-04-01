package be.avidoo.hexagonal.domain.dossier;

import be.avidoo.hexagonal.domain.EntityId;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class DossierId extends EntityId<UUID> {

    public static DossierId of(UUID id) {
        return DossierId.builder().value(id).build();
    }

    public static DossierId create() {
        return DossierId.builder().value(UUID.randomUUID()).build();
    }

    @Builder
    public DossierId(UUID value) {
        super(value);
    }
}
