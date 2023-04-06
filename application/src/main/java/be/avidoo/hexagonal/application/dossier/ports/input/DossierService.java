package be.avidoo.hexagonal.application.dossier.ports.input;

import be.avidoo.hexagonal.application.ApplicationService;
import be.avidoo.hexagonal.application.dossier.DossierUseCase;
import be.avidoo.hexagonal.application.dossier.ports.input.command.UpdateDescriptionCommand;
import be.avidoo.hexagonal.application.dossier.ports.input.command.UpdateDossierCommand;
import be.avidoo.hexagonal.application.dossier.ports.output.DossierOutputPort;
import be.avidoo.hexagonal.application.dossier.ports.output.DossierJdbcOutputPort;
import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;
import be.avidoo.hexagonal.domain.dossier.events.DossierDeletedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;


@Transactional
@Service
public class DossierService extends ApplicationService<Dossier> implements DossierUseCase {

    private final DossierOutputPort dossierOutputPort;
    private final DossierJdbcOutputPort dossierJdbcOutputPort;
    private final Clock clock;

    public DossierService(
            ApplicationEventPublisher applicationEventPublisher,
            DossierOutputPort dossierOutputPort,
            DossierJdbcOutputPort dossierJdbcOutputPort,
            Clock clock
    ) {
        super(applicationEventPublisher);
        this.dossierOutputPort = dossierOutputPort;
        this.dossierJdbcOutputPort = dossierJdbcOutputPort;
        this.clock = clock;
    }

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

        Dossier updatedDossier = dossierToUpdate.update(updateDossierCommand.getDescription());
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

    @Override
    public int updateDescription(UpdateDescriptionCommand updateDossierCommand) {
        return dossierJdbcOutputPort.updateDescription(
                updateDossierCommand.getNewDescription(),
                updateDossierCommand.getOldDescription()
        );
    }


}
