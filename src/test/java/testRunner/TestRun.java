package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
              //  features="@target/rerun.txt",
              //  features={"./features/"}, // executes all features files
                features = {"./features/Login.feature" , "./features/AccountRegistration.feature"},
              //features = {"./features/LoginDDT.feature" },
             //  features = {"./features/AccountRegistration.feature" },
                glue = "stepDefinitions",
                dryRun=false,
               // tags = "@sanity" // all sanity scenarios will be executed
                //tags = "@sanity" and "@regression" //Scenarios tagged with sanity and regression will be executed
                //tags ="@sanity" or "@regression" //Scenarios tagged with sanity or regression will be executed
                //tags ="@sanity" and not "@regression" // Only scenarios with sanity will be executed
               monochrome = true,
                plugin= {"pretty",
                        //"html:reports/myreport.html",
                        "html:reports/myreport.html",
                       // "json:reports/myreport.json",
                        "rerun:target/rerun.txt",    //Mandatory to capture failures
                }

        )
public class TestRun {


}
