package CucumberDemo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
@CucumberOptions(
        features = "src/test/java/Resources/DemoTest.feature",
        glue = "CucumberDemo",
        plugin = {"pretty","html:target/cucumber-report.html"},
        dryRun = false

)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
