package be.avidoo.hexagonal.application.dossier.ports.input;

import be.avidoo.hexagonal.application.dossier.ports.output.DossierOutputPort;
import be.avidoo.hexagonal.application.dossier.usecases.DossierUseCase;
import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;
import be.avidoo.hexagonal.domain.dossier.command.UpdateDossierCommand;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Named
public class DossierInputPort implements DossierUseCase {

    private final DossierOutputPort dossierOutputPort;

    @Override
    public Dossier createDossier() {
        return dossierOutputPort.save(Dossier.create());
    }

    @Override
    public Dossier updateDossier(UpdateDossierCommand updateDossierCommand) {
        Dossier dossierToUpdate = dossierOutputPort.findById(
                DossierId.of(updateDossierCommand.getId())
        );

        return dossierToUpdate.update(updateDossierCommand);
    }

    @Override
    public void deleteDossier(DossierId dossierId) {
        dossierOutputPort.deleteById(dossierId);
    }
}
