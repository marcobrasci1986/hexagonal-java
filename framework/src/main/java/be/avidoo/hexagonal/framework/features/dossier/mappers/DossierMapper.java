package be.avidoo.hexagonal.framework.features.dossier.mappers;

import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;
import be.avidoo.hexagonal.framework.EntityMapper;
import be.avidoo.hexagonal.framework.features.dossier.data.DossierJpaEntity;
import org.springframework.stereotype.Service;

@Service
public class DossierMapper implements EntityMapper<Dossier, DossierJpaEntity> {

    public DossierJpaEntity toJpaEntity(Dossier dossier) {
        return DossierJpaEntity.builder()
                .id(dossier.getId().getValue())
                .dossierFase(dossier.getDossierFase())
                .description(dossier.getDescription())
                .build();
    }

    public Dossier toDomainEntity(DossierJpaEntity dossier) {
        return Dossier.builder()
                .id(DossierId.of(dossier.getId()))
                .dossierFase(dossier.getDossierFase())
                .description(dossier.getDescription())
                .build();
    }

}
