import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDefWeb"},
        features = {"src/test/resources/featureWeb"},
        plugin = {"pretty", "html:reports/cucumber-web.html", "json:reports/cucumber-web.json"},
        tags = "@web"
)
public class CucumberTestWeb {
    public CucumberTestWeb() {
    }
}
