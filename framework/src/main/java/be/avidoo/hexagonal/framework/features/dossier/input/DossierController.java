package be.avidoo.hexagonal.framework.features.dossier.input;


import be.avidoo.hexagonal.application.dossier.usecases.DossierUseCase;
import be.avidoo.hexagonal.domain.dossier.Dossier;
import be.avidoo.hexagonal.framework.features.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DossierController implements Api {

    private final DossierUseCase dossierUseCase;

    @PostMapping("/dossier")
    public ResponseEntity<Dossier> createDossier() {

        Dossier dossier = dossierUseCase.createDossier();

        return ResponseEntity.ok(dossier);

    }


}
