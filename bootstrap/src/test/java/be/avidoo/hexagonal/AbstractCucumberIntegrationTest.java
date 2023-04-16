package be.avidoo.hexagonal;

import be.avidoo.hexagonal.application.dossier.ports.output.DossierOutputPort;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

/**
 * Cannot be abstract! That wil result in this exception: CucumberBackendException: No test instance
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "be.avidoo.hexagonal")
@CucumberContextConfiguration
@ActiveProfiles({"test"})
@SpringBootTest(classes = {Main.class, CucumberTestConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(print = MockMvcPrint.DEFAULT)
public class AbstractCucumberIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected DossierOutputPort dossierOutputPort;
}
