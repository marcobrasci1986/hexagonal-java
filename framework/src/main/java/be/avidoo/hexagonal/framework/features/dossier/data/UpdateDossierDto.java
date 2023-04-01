package be.avidoo.hexagonal.framework.features.dossier.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class UpdateDossierDto {

    private UUID id;
    private String description;
}
