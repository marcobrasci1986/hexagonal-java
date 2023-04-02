package be.avidoo.hexagonal.application.dossier.ports.input;

import be.avidoo.hexagonal.application.dossier.events.DossierCreatedEvent;
import be.avidoo.hexagonal.application.dossier.ports.output.DossierOutputPort;
import be.avidoo.hexagonal.application.dossier.usecases.DossierUseCase;
import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;
import be.avidoo.hexagonal.domain.dossier.command.UpdateDossierCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Transactional
@Service
public class DossierInputPort implements DossierUseCase {

    private final DossierOutputPort dossierOutputPort;
    private final ApplicationEventPublisher applicationEventPublisher;

    private final Clock clock;

    @Override
    public Dossier createDossier() {
        Dossier savedDossier = dossierOutputPort.save(Dossier.create());

        applicationEventPublisher.publishEvent(
                DossierCreatedEvent.builder()
                        .dossierId(savedDossier.getId())
                        .timestamp(LocalDateTime.now(clock))
                        .build()
        );
        return savedDossier;
    }

    @Override
    public Dossier updateDossier(UpdateDossierCommand updateDossierCommand) {
        Dossier dossierToUpdate = dossierOutputPort.findById(
                DossierId.of(updateDossierCommand.getId())
        );

        Dossier updatedDossier = dossierToUpdate.update(updateDossierCommand);
        Dossier save = dossierOutputPort.save(updatedDossier);

        applicationEventPublisher.publishEvent(
                DossierCreatedEvent.builder()
                        .dossierId(save.getId())
                        .timestamp(LocalDateTime.now(clock))
                        .build()
        );

        return save;
    }

    @Override
    public void deleteDossier(DossierId dossierId) {
        dossierOutputPort.deleteById(dossierId);
    }
}
