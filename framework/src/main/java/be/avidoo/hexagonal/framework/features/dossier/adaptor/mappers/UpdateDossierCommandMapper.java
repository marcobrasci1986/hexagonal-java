package be.avidoo.hexagonal.framework.features.dossier.adaptor.mappers;

import be.avidoo.hexagonal.domain.dossier.command.UpdateDossierCommand;
import be.avidoo.hexagonal.framework.features.dossier.adaptor.input.web.UpdateDossierDto;
import org.springframework.stereotype.Service;

@Service
public class UpdateDossierCommandMapper {

    public UpdateDossierCommand map(UpdateDossierDto updateDossierDto) {
        return UpdateDossierCommand.builder()
                .id(updateDossierDto.id())
                .description(updateDossierDto.description())
                .build();
    }
}
