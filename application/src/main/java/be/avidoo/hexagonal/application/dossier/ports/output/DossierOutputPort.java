package be.avidoo.hexagonal.application.dossier.ports.output;

import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;

import java.util.List;

public interface DossierOutputPort {

    Dossier findById(DossierId dossierId);

    void deleteById(DossierId dossierId);

    Dossier save(Dossier dossier);

    List<Dossier> findAll();
}
