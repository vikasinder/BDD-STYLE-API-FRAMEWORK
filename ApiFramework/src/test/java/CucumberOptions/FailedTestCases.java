package CucumberOptions;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt",glue="stepDefinations",
monochrome=true,  
plugin= {"html:target/cucumber.html",
		})

//dryRun=True is just used to check whether step DefinItions are there or not
public class FailedTestCases extends AbstractTestNGCucumberTests {

//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios()
//		{
//			return super.scenarios();
//		}
//	
}
