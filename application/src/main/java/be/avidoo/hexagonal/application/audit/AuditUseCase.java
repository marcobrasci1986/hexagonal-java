package be.avidoo.hexagonal.application.audit;

import be.avidoo.hexagonal.domain.audit.Audit;
import be.avidoo.hexagonal.domain.audit.command.SaveAuditCommand;

public interface AuditUseCase {


    Audit save(SaveAuditCommand saveAuditCommand);
}
