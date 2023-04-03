package be.avidoo.hexagonal.domain.dossier.events;

import be.avidoo.hexagonal.domain.DomainEvent;
import be.avidoo.hexagonal.domain.dossier.DossierId;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class DossierDeletedEvent implements DomainEvent {

    private final DossierId dossierId;
    private final LocalDateTime timestamp;

}
