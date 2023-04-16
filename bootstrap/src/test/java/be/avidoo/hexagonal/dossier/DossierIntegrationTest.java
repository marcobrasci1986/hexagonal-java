package be.avidoo.hexagonal.dossier;

import be.avidoo.hexagonal.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * TODO Clean DB after Integration Tests
 */
public class DossierIntegrationTest extends AbstractIntegrationTest {

    @Test
    void maakDossierAan() throws Exception {
        final var response = mockMvc.perform(post("/api/dossier"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);

    }
}
