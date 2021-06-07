package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "..\\\\TrivagoAssignment\\src\\main\\java\\Features"
				,glue={"StepDefinition"},
						plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},
                dryRun=false,
                monochrome = true
                )

public class TestRunner {

	
	@AfterClass
	public static void setup()
	{
	Reporter.setSystemInfo("User Name", "Ahmed Tolba");
	Reporter.setSystemInfo("Application Name", "Trivago Test Assignment");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
	
	
	
	
}
