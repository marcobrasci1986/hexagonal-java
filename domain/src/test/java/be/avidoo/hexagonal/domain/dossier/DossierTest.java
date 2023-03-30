package be.avidoo.hexagonal.domain.dossier;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DossierTest {

    @Test
    void initialDossier() {
        Dossier initialDossier = Dossier.builder()
                .id(DossierId.builder().value(1L).build())
                .build();

        assertThat(initialDossier.getId().getValue()).isEqualTo(1L);
        assertThat(initialDossier.getDossierFase()).isEqualTo(DossierFase.CREATED);
    }

    @Test
    void equality() {
        Dossier dossier1 = Dossier.builder()
                .id(DossierId.builder().value(1L).build())
                .build();

        Dossier dossier2 = Dossier.builder()
                .id(DossierId.builder().value(1L).build())
                .build();

        assertThat(dossier1).isEqualTo(dossier2);
    }
}