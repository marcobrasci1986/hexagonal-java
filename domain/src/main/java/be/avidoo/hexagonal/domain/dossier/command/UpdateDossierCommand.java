package be.avidoo.hexagonal.domain.dossier.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class UpdateDossierCommand {

    private UUID id;
    private String description;
}
