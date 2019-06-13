package automationPractice;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by User on 03/11/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features/",
        tags ="@invalidEmail",
        format = "html:target/CucumberHTMLReports")
public class RunCucumberTests {


}
