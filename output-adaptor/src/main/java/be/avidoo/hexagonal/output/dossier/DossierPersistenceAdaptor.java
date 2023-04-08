package be.avidoo.hexagonal.output.dossier;

import be.avidoo.hexagonal.application.dossier.ports.output.DossierOutputPort;
import be.avidoo.hexagonal.application.dossier.ports.output.DossierJdbcOutputPort;
import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.domain.dossier.DossierId;
import be.avidoo.hexagonal.output.dossier.mappers.DossierMapper;
import be.avidoo.hexagonal.output.dossier.jdbc.DossierJdbcRepository;
import be.avidoo.hexagonal.output.dossier.jpa.DossierJpaEntity;
import be.avidoo.hexagonal.output.dossier.jpa.DossierJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DossierPersistenceAdaptor implements DossierOutputPort, DossierJdbcOutputPort {

    private final DossierJpaRepository dossierJpaRepository;
    private final DossierJdbcRepository dossierJdbcRepository;
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

    @Override
    public int updateDescription(String newDescription, String oldDescription) {
        return dossierJdbcRepository.updateDescription(newDescription, oldDescription);
    }
}
