package be.avidoo.hexagonal.framework.features.audit.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Audit")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuditJpaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "event")
    private String event;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Builder
    public AuditJpaEntity(UUID id, String event, LocalDateTime timestamp) {
        this.id = id;
        this.event = event;
        this.timestamp = timestamp;
    }
}
