package CucumberOptions;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinations",
monochrome=true,  tags="@Test1 or Test2",
plugin= {"html:target/cucumber.html","rerun:target/failed_scenarios.txt"
		})

//dryRun=True is just used to check whether step DefinItions are there or not
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios()
//		{
//			return super.scenarios();
//		}
//	
}
