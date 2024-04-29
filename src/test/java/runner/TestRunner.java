package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/features"},
        plugin = {"pretty"},
        glue = {"stepdefinitions"},
        tags = "@Regression"


)
public class TestRunner extends AbstractTestNGCucumberTests {

//        @Override
//        @DataProvider(parallel = true)  // This enables parallel execution
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }
}
