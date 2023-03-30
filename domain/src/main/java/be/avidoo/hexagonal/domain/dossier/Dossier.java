package be.avidoo.hexagonal.domain.dossier;

import be.avidoo.hexagonal.domain.AggregateRoot;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Dossier extends AggregateRoot<DossierId> {

    private final DossierFase dossierFase;

    @Builder
    public Dossier(DossierId id) {
        super(id);
        this.dossierFase = DossierFase.CREATED;
    }
}
