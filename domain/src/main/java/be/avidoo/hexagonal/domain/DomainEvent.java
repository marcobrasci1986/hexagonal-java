package be.avidoo.hexagonal.domain;

import java.time.LocalDateTime;

public interface DomainEvent {

    LocalDateTime getTimestamp();
}
