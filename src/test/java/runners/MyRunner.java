package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        format = {"pretty","json:target/cucumber.json"},
        tags = {"@runit,@run","~@ignore"},
        glue = {"bindings"}
)


public class MyRunner {

}