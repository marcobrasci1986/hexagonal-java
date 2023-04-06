package be.avidoo.hexagonal.application.dossier.ports.output;

public interface DossierJdbcOutputPort {

    int updateDescription(String newDescription, String oldDescription);
}
