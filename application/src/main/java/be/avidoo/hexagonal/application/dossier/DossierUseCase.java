package be.avidoo.hexagonal.application.dossier;

import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;
import be.avidoo.hexagonal.domain.dossier.command.UpdateDossierCommand;

public interface DossierUseCase {


    // Receive Commands return void
    // Receive Query return Query
    Dossier createDossier();

    Dossier updateDossier(UpdateDossierCommand updateDossierCommand);

    void deleteDossier(DossierId dossierId);
}
