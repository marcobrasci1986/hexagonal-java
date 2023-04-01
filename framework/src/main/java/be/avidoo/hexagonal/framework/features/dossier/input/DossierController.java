package be.avidoo.hexagonal.framework.features.dossier.input;


import be.avidoo.hexagonal.application.dossier.usecases.DossierUseCase;
import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.framework.features.Api;
import be.avidoo.hexagonal.framework.features.dossier.dto.UpdateDossierDto;
import be.avidoo.hexagonal.framework.features.dossier.mappers.UpdateDossierCommandMapper;
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
public class DossierController implements Api {

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


}
