package be.avidoo.hexagonal.application.dossier.ports.input.command;

import be.avidoo.hexagonal.application.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;


@Getter
public class UpdateDescriptionCommand extends SelfValidating<UpdateDescriptionCommand> {

    private final UUID id;
    @NotNull
    private final String newDescription;
    @NotNull
    private final String oldDescription;

    @Builder
    public UpdateDescriptionCommand(UUID id, String newDescription, String oldDescription) {
        this.id = id;
        this.newDescription = newDescription;
        this.oldDescription = oldDescription;

        this.validateSelf();
    }
}
