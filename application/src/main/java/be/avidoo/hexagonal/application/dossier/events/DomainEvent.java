package be.avidoo.hexagonal.application.dossier.events;

import java.time.LocalDateTime;

public interface DomainEvent {

    LocalDateTime getTimestamp();
}
