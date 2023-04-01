package be.avidoo.hexagonal.framework.features.dossier.mappers;

import be.avidoo.hexagonal.domain.dossier.command.UpdateDossierCommand;
import be.avidoo.hexagonal.framework.features.dossier.data.UpdateDossierDto;
import org.springframework.stereotype.Service;

@Service
public class UpdateDossierCommandMapper {

    public UpdateDossierCommand map(UpdateDossierDto updateDossierDto) {
        return UpdateDossierCommand.builder()
                .id(updateDossierDto.getId())
                .description(updateDossierDto.getDescription())
                .build();
    }
}
