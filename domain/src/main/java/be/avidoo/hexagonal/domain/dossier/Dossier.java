package be.avidoo.hexagonal.domain.dossier;

import be.avidoo.hexagonal.domain.AggregateRoot;
import be.avidoo.hexagonal.domain.dossier.events.DossierCreatedEvent;
import be.avidoo.hexagonal.domain.dossier.events.DossierUpdatedEvent;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Dossier extends AggregateRoot<DossierId> {

    private String description;
    private final DossierFase dossierFase;


    /**
     * Static creation function to create the Aggregate root, also registers the creation Event.
     */
    public static Dossier create(LocalDateTime now) {
        Dossier dossier = Dossier.builder()
                .id(DossierId.create())
                .dossierFase(DossierFase.CREATED)
                .build();

        dossier.registerEvent(
                DossierCreatedEvent.builder()
                        .dossierId(dossier.getId())
                        .timestamp(now)
                        .build()
        );

        return dossier;
    }

    /**
     * Use registerCreateEvent if you want to register the CreatedEvent, should only be used when the Entity is created and not when the Entity is recreated from the DB.
     */
    @Builder
    private Dossier(DossierId id, DossierFase dossierFase, String description) {
        super(id);
        this.description = description;
        this.dossierFase = dossierFase;
    }

    public Dossier update(String description) {
        this.description = description;
        this.registerEvent(
                DossierUpdatedEvent.builder()
                        .dossierId(this.getId())
                        .timestamp(LocalDateTime.now())
                        .build()
        );
        return this;
    }

}
