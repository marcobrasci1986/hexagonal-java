package be.avidoo.hexagonal.application.audit.ports.input;

import be.avidoo.hexagonal.application.audit.ports.output.AuditOutputPort;
import be.avidoo.hexagonal.application.audit.AuditUseCase;
import be.avidoo.hexagonal.domain.audit.Audit;
import be.avidoo.hexagonal.domain.audit.AuditId;
import be.avidoo.hexagonal.domain.audit.command.SaveAuditCommand;
import be.avidoo.hexagonal.domain.dossier.events.DossierCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Transactional
@Service
public class AuditService implements AuditUseCase {

    private final AuditOutputPort auditOutputPort;

    @EventListener
    public void handleDossierCreatedEvent(DossierCreatedEvent dossierCreatedEvent) {

        this.save(
                SaveAuditCommand.builder()
                        .id(UUID.randomUUID())
                        .event(dossierCreatedEvent.getClass().getSimpleName())
                        .timestamp(dossierCreatedEvent.getTimestamp())
                        .build()
        );

    }

    @Override
    public Audit save(SaveAuditCommand saveAuditCommand) {

        Audit audit = Audit.builder()
                .id(AuditId.of(saveAuditCommand.getId()))
                .event(saveAuditCommand.getEvent())
                .timestamp(saveAuditCommand.getTimestamp())
                .build();


//        if (saveAuditCommand.getEvent().equals("DossierCreatedEvent")) {
//            throw new RuntimeException("Test if TX works. Dossier should not be saved.");
//        }

        return auditOutputPort.save(audit);
    }
}
