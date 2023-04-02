package be.avidoo.hexagonal.domain.audit;

import be.avidoo.hexagonal.domain.AggregateRoot;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Audit extends AggregateRoot<AuditId> {

    private final String event;
    private final LocalDateTime timestamp;

    @Builder
    public Audit(AuditId id, String event, LocalDateTime timestamp) {
        super(id);
        this.event = event;
        this.timestamp = timestamp;
    }
}
