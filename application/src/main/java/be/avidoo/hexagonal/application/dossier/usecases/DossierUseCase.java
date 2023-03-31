package be.avidoo.hexagonal.application.dossier.usecases;

import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;

public interface DossierUseCase {


    // Receive Commands return void
    // Receive Query return Query
    Dossier createDossier();

    Dossier updateDossier(DossierId dossierId, String description);

    void deleteDossier(DossierId dossierId);
}
