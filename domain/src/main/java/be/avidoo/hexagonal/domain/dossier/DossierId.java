package be.avidoo.hexagonal.domain.dossier;

import be.avidoo.hexagonal.domain.EntityId;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DossierId extends EntityId<Long> {

    public static DossierId of(Long id) {
        return DossierId.builder().value(id).build();
    }

    @Builder
    public DossierId(Long value) {
        super(value);
    }
}
