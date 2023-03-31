package be.avidoo.hexagonal.domain.dossier;

import be.avidoo.hexagonal.domain.AggregateRoot;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Dossier extends AggregateRoot<DossierId> {

    private String description;
    private final DossierFase dossierFase;

    @Builder
    public Dossier(DossierId id, DossierFase dossierFase, String description) {
        super(id);
        this.description = description;
        this.dossierFase = dossierFase;
    }


    public Dossier updateDescription(String description) {
        this.description = description;
        return this;
    }
}
