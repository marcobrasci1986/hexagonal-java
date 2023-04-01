package be.avidoo.hexagonal.framework.features.dossier;

import be.avidoo.hexagonal.application.dossier.ports.input.DossierInputPort;
import be.avidoo.hexagonal.application.dossier.ports.output.DossierOutputPort;
import be.avidoo.hexagonal.application.dossier.usecases.DossierUseCase;
import be.avidoo.hexagonal.framework.features.dossier.mappers.DossierMapper;
import be.avidoo.hexagonal.framework.features.dossier.output.DossierJpaAdaptor;
import be.avidoo.hexagonal.framework.features.dossier.output.DossierJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DossierConfiguration {
    public final DossierJpaRepository dossierMappeJpaRepository;
    public final DossierMapper dossierMapper;


    @Bean
    public DossierUseCase dossierUseCase() {
        return new DossierInputPort(dossierOutputPort());
    }

    @Bean
    public DossierOutputPort dossierOutputPort() {
        return new DossierJpaAdaptor(dossierMappeJpaRepository, dossierMapper);
    }
}
