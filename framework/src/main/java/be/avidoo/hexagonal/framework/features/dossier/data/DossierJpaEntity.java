package be.avidoo.hexagonal.framework.features.dossier.data;

import be.avidoo.hexagonal.domain.dossier.DossierFase;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dossier")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DossierJpaEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "fase")
    @Enumerated
    private DossierFase dossierFase;

    @Builder
    public DossierJpaEntity(String description, DossierFase dossierFase) {
        this.description = description;
        this.dossierFase = dossierFase;
    }
}
