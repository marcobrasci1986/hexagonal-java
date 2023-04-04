package be.avidoo.hexagonal.application.dossier.ports.input;

import be.avidoo.hexagonal.application.dossier.ports.output.DossierOutputPort;
import be.avidoo.hexagonal.application.dossier.usecases.DossierUseCase;
import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;
import be.avidoo.hexagonal.domain.dossier.command.UpdateDossierCommand;
import be.avidoo.hexagonal.domain.dossier.events.DossierDeletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Transactional // Spring
@Service // Spring
public class DossierInputPort implements DossierUseCase {

    private final DossierOutputPort dossierOutputPort;
    private final ApplicationEventPublisher applicationEventPublisher;

    private final Clock clock;

    @Override
    public Dossier createDossier() {
        Dossier newDossier = Dossier.create(LocalDateTime.now(clock));
        dossierOutputPort.save(newDossier);

        return handleEvents(newDossier);
    }

    @Override
    public Dossier updateDossier(UpdateDossierCommand updateDossierCommand) {
        Dossier dossierToUpdate = dossierOutputPort.findById(
                DossierId.of(updateDossierCommand.getId())
        );

        Dossier updatedDossier = dossierToUpdate.update(updateDossierCommand);
        dossierOutputPort.save(updatedDossier);

        return handleEvents(updatedDossier);

    }

    @Override
    public void deleteDossier(DossierId dossierId) {
        dossierOutputPort.deleteById(dossierId);

        applicationEventPublisher.publishEvent(
                DossierDeletedEvent.builder()
                        .dossierId(dossierId)
                        .timestamp(LocalDateTime.now(clock))
                        .build()
        );
    }

    private Dossier handleEvents(Dossier updatedDossier) {
        updatedDossier.getEvents().forEach(applicationEventPublisher::publishEvent);
        updatedDossier.clearEvents();

        return updatedDossier;
    }
}
