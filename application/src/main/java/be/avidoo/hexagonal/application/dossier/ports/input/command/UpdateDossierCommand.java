package be.avidoo.hexagonal.application.dossier.ports.input.command;

import be.avidoo.hexagonal.application.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;


@Getter
public class UpdateDossierCommand extends SelfValidating<UpdateDossierCommand> {

    private final UUID id;
    @NotNull
    private final String description;

    @Builder
    public UpdateDossierCommand(UUID id, String description) {
        this.id = id;
        this.description = description;

        this.validateSelf();
    }
}
