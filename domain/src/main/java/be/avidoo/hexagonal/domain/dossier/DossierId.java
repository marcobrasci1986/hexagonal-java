package be.avidoo.hexagonal.domain.dossier;

import be.avidoo.hexagonal.domain.EntityId;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DossierId extends EntityId<Long> {

    @Builder
    public DossierId(Long value) {
        super(value);
    }
}
