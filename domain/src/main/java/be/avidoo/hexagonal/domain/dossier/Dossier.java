package be.avidoo.hexagonal.domain.dossier;

import be.avidoo.hexagonal.domain.AggregateRoot;
import be.avidoo.hexagonal.domain.dossier.command.UpdateDossierCommand;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Dossier extends AggregateRoot<DossierId> {

    private String description;
    private final DossierFase dossierFase;


    public static Dossier create() {
        return Dossier.builder()
                .id(DossierId.create())
                .dossierFase(DossierFase.CREATED)
                .build();
    }

    @Builder
    public Dossier(DossierId id, DossierFase dossierFase, String description) {
        super(id);
        this.description = description;
        this.dossierFase = dossierFase;
    }


    public Dossier update(UpdateDossierCommand updateDossierCommand) {
        this.description = updateDossierCommand.getDescription();
        return this;
    }
}
