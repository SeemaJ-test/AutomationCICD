package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/cucumber",glue="rahulshettyacademy.stepDefination",
monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests{

}
