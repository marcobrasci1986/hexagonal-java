package be.avidoo.hexagonal.input.dossier.mapper;

import be.avidoo.hexagonal.application.dossier.ports.input.command.UpdateDossierCommand;
import be.avidoo.hexagonal.input.dossier.web.UpdateDossierDto;
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
