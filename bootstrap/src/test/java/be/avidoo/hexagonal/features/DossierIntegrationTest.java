package be.avidoo.hexagonal.features;

import be.avidoo.hexagonal.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DossierIntegrationTest extends AbstractIntegrationTest {


    @Test
    void maakDossierAan() throws Exception {
        final var response = mockMvc.perform(post("/api/dossier"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }
}
