package be.avidoo.hexagonal.domain.audit.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class SaveAuditCommand {

    private UUID id;
    private String event;
    private LocalDateTime timestamp;
}
