package be.avidoo.hexagonal.application.dossier.events;

import be.avidoo.hexagonal.domain.dossier.DossierId;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class DossierCreatedEvent implements DomainEvent {

    private final DossierId dossierId;
    private final LocalDateTime timestamp;

}