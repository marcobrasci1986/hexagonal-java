package be.avidoo.hexagonal.dossier;

import be.avidoo.hexagonal.application.dossier.ports.output.DossierOutputPort;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RequiredArgsConstructor
public class DossierIntegrationBddTest {

    private final DossierOutputPort dossierOutputPort;
    private final MockMvc mockMvc;


    @Given("There are no Dossier")
    public void thereAreNoDossier() {
        assertThat(dossierOutputPort.findAll().size()).isEqualTo(0);
    }

    @When("^I create a new Dossier$")
    public void the_client_issues_GET_version() throws Throwable {
        final var response = mockMvc.perform(post("/api/dossier"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn()
                .getResponse();


        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Then("There is a new Dossier")
    public void thereIsANewDossier() {
        assertThat(dossierOutputPort.findAll().size()).isEqualTo(1);
    }


}
