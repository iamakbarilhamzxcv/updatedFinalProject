import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/cucumber-api.html", "json:reports/cucumber-api.json"},
        glue = {"stepDefApi"},
        features = {"src/test/resources/featureApi"},
        tags = "@api"
)
public class CucumberTestApi {
    public CucumberTestApi() {
    }
}
