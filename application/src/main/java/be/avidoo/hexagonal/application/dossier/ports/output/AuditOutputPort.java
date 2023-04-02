package be.avidoo.hexagonal.application.dossier.ports.output;

import be.avidoo.hexagonal.domain.audit.Audit;

public interface AuditOutputPort {

    Audit save(Audit audit);

}
