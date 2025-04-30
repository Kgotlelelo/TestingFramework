package webTest;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(value = Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature/assignment.feature",
        glue={"stepDefinitions"}
)
public class AssessmentRunner {}