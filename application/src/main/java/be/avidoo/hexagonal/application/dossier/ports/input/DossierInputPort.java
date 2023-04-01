package be.avidoo.hexagonal.application.dossier.ports.input;

import be.avidoo.hexagonal.application.dossier.ports.output.DossierOutputPort;
import be.avidoo.hexagonal.application.dossier.usecases.DossierUseCase;
import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DossierInputPort implements DossierUseCase {

    private final DossierOutputPort dossierOutputPort;

    @Override
    public Dossier createDossier() {
        return dossierOutputPort.save(Dossier.create());
    }

    @Override
    public Dossier updateDossier(DossierId dossierId, String description) {
        Dossier dossierToUpdate = dossierOutputPort.findById(dossierId);

        return dossierToUpdate.updateDescription(description);
    }

    @Override
    public void deleteDossier(DossierId dossierId) {
        dossierOutputPort.deleteById(dossierId);
    }
}
