package be.avidoo.hexagonal.input.web.dossier.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.UUID;

public record UpdateDescriptionDossierDto(UUID id, String newDescription, String oldDescription) {

    @JsonCreator
    @Builder
    public UpdateDescriptionDossierDto(
            @JsonProperty("id") UUID id,
            @JsonProperty("newDescription") String newDescription,
            @JsonProperty("oldDescription") String oldDescription
    ) {
        this.id = id;
        this.newDescription = newDescription;
        this.oldDescription = oldDescription;
    }
}
