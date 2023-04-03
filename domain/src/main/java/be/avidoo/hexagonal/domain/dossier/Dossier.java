package be.avidoo.hexagonal.domain.dossier;

import be.avidoo.hexagonal.domain.AggregateRoot;
import be.avidoo.hexagonal.domain.dossier.command.UpdateDossierCommand;
import be.avidoo.hexagonal.domain.dossier.events.DossierCreatedEvent;
import be.avidoo.hexagonal.domain.dossier.events.DossierUpdatedEvent;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Dossier extends AggregateRoot<DossierId> {

    private String description;
    private final DossierFase dossierFase;


    public static Dossier create() {
        return Dossier.builder()
                .id(DossierId.create())
                .dossierFase(DossierFase.CREATED)
                .registerCreateEvent(true)
                .build();
    }

    /**
     * Use registerCreateEvent if you want to register the CreatedEvent, should only be used when the Entity is created and not when the Entity is recreated from the DB.
     */
    @Builder
    private Dossier(DossierId id, DossierFase dossierFase, String description, boolean registerCreateEvent) {
        super(id);
        this.description = description;
        this.dossierFase = dossierFase;

        if (registerCreateEvent) {
            this.addEvent(
                    DossierCreatedEvent.builder()
                            .dossierId(this.getId())
                            .timestamp(LocalDateTime.now())
                            .build()
            );
        }
    }

    public Dossier update(UpdateDossierCommand updateDossierCommand) {
        this.description = updateDossierCommand.getDescription();
        this.addEvent(
                DossierUpdatedEvent.builder()
                        .dossierId(this.getId())
                        .timestamp(LocalDateTime.now())
                        .build()
        );
        return this;
    }

}
