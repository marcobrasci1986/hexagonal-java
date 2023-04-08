package be.avidoo.hexagonal.input.web.dossier;


import be.avidoo.hexagonal.application.dossier.DossierUseCase;
import be.avidoo.hexagonal.application.dossier.ports.input.command.UpdateDescriptionCommand;
import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.input.web.RestApiRoot;
import be.avidoo.hexagonal.input.web.dossier.dto.UpdateDescriptionDossierDto;
import be.avidoo.hexagonal.input.web.dossier.dto.UpdateDossierDto;
import be.avidoo.hexagonal.input.web.dossier.mapper.UpdateDossierCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8083/hexagonal/swagger-ui/index.html
 */
@RestController
@RequiredArgsConstructor
public class DossierController implements RestApiRoot {

    private final DossierUseCase dossierUseCase;
    private final UpdateDossierCommandMapper updateDossierCommandMapper;

    @PostMapping("/dossier")
    public ResponseEntity<Dossier> createDossier() {

        Dossier dossier = dossierUseCase.createDossier();

        return ResponseEntity.ok(dossier);

    }

    @PutMapping("/dossier")
    public ResponseEntity<Dossier> updateDossier(UpdateDossierDto updateDossierDto) {

        Dossier dossier = dossierUseCase.updateDossier(
                updateDossierCommandMapper.map(updateDossierDto)
        );

        return ResponseEntity.ok(dossier);

    }


    @PostMapping("/dossier-description")
    public ResponseEntity<Integer> updateDescriptionDossier(UpdateDescriptionDossierDto updateDossierDto) {

        int dossier = dossierUseCase.updateDescription(
                UpdateDescriptionCommand.builder()
                        .newDescription(updateDossierDto.newDescription())
                        .oldDescription(updateDossierDto.oldDescription())
                        .build()
        );

        return ResponseEntity.ok(dossier);

    }


}
