package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)


@CucumberOptions(  monochrome = true,
                     
                     features = "src/test/resources/demoBlazeTest.feature",
                    
                     publish =true,
                        glue={"stepsDefinition"})

public class testRunnerFile {

}
