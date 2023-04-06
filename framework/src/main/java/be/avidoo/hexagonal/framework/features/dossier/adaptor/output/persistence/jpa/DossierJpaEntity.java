package be.avidoo.hexagonal.framework.features.dossier.adaptor.output.persistence.jpa;

import be.avidoo.hexagonal.domain.dossier.DossierFase;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "dossier")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DossierJpaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "description")
    private String description;

    @Column(name = "dossierfase")
    @Enumerated
    private DossierFase dossierFase;

    @Builder
    public DossierJpaEntity(UUID id, String description, DossierFase dossierFase) {
        this.id = id;
        this.description = description;
        this.dossierFase = dossierFase;
    }
}
