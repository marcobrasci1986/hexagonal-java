package be.avidoo.hexagonal.application.dossier.ports.input.command;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UpdateDossierCommandTest {

    @Test
    void validateDescriptionNull() {

        ConstraintViolationException ex = assertThrows(ConstraintViolationException.class, () -> {
            UpdateDossierCommand.builder()
                    .id(UUID.randomUUID())
                    .build();
        });

        assertThat(ex.getMessage()).isEqualTo("description: Verplicht veld");

    }
}