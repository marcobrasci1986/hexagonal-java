package be.avidoo.hexagonal.application.dossier.ports.output;

public interface DossierUpdateOutputPort {

    int updateDescription(String newDescription, String oldDescription);
}
