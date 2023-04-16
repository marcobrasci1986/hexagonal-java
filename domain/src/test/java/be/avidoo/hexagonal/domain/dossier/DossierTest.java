package be.avidoo.hexagonal.domain.dossier;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class DossierTest {

    @Test
    void initialDossier() {
        UUID id = UUID.randomUUID();
        Dossier initialDossier = Dossier.builder()
                .id(DossierId.builder().value(id).build())
                .dossierFase(DossierFase.CREATED)
                .build();

        assertThat(initialDossier.getId().getValue()).isEqualTo(id);
        assertThat(initialDossier.getDossierFase()).isEqualTo(DossierFase.CREATED);
    }

    @Test
    void equality() {
        UUID id = UUID.randomUUID();
        Dossier dossier1 = Dossier.builder()
                .id(DossierId.builder().value(id).build())
                .build();

        Dossier dossier2 = Dossier.builder()
                .id(DossierId.builder().value(id).build())
                .build();

        assertThat(dossier1).isEqualTo(dossier2);
    }
}