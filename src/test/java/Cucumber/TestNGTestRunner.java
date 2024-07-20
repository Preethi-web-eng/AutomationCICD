package Cucumber;

@io.cucumber.testng.CucumberOptions(features="src/test/java/Cucumber",glue="RahulshettyUdemy.stepDefinitions",
monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends io.cucumber.testng.AbstractTestNGCucumberTests {

}
