package be.avidoo.hexagonal.framework.features.dossier.adaptor.input.web;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.UUID;

public record UpdateDossierDto(UUID id, String description) {

    @JsonCreator
    @Builder
    public UpdateDossierDto(
            @JsonProperty("id") UUID id,
            @JsonProperty("description") String description) {
        this.id = id;
        this.description = description;
    }
}