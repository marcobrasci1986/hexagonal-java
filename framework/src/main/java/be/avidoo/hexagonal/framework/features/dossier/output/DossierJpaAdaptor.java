package be.avidoo.hexagonal.framework.features.dossier.output;

import be.avidoo.hexagonal.application.dossier.ports.output.DossierOutputPort;
import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;
import be.avidoo.hexagonal.framework.features.dossier.data.DossierJpaEntity;
import be.avidoo.hexagonal.framework.features.dossier.mappers.DossierMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DossierJpaAdaptor implements DossierOutputPort {

    private final DossierJpaRepository dossierJpaRepository;
    private final DossierMapper dossierMapper;

    @Override
    public Dossier findById(DossierId dossierId) {
        DossierJpaEntity dossierJpaEntity = dossierJpaRepository.findById(dossierId.getValue()).orElseThrow();
        return dossierMapper.toDomainEntity(dossierJpaEntity);
    }

    @Override
    public void deleteById(DossierId dossierId) {
        dossierJpaRepository.deleteById(dossierId.getValue());
    }

    @Override
    public Dossier save(Dossier dossier) {
        DossierJpaEntity dossierJpaEntity = dossierMapper.toJpaEntity(dossier);
        DossierJpaEntity savedDossier = dossierJpaRepository.save(dossierJpaEntity);
        return dossierMapper.toDomainEntity(savedDossier);
    }
}
