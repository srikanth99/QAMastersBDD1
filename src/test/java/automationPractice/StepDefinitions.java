package automationPractice;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 03/11/2017.
 */
public class StepDefinitions {
    static WebDriver driver;
    String baseURL = "http://automationpractice.com";

    //pre-condition for test scenario
    //open the browser and open the baseURL
    @Before
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //post condition for test scenario
    //close the browser
    @After
    public void closeBrowser() {
        driver.close();
    }

    @Given("^User is on the home page$")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("My Store"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#search_query_top")).isDisplayed());
    }

    @When("^User selects SignIn link$")
    public void selctSignInLink() {
        driver.findElement(By.cssSelector(".login")).click();
    }

    @When("^User enter email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void enterLoginCredentials(String email, String password) {
        driver.findElement(By.cssSelector("input[id='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[id='passwd']")).sendKeys(password);
    }

    @Then("^User should be on the login page$")
    public void verifyUserIsOnLoginpage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("form[id='login_form']")).isDisplayed());
    }

    @Then("^User should be login successfully$")
    public void isUserLoggedIn() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".info-account")).isDisplayed());
    }

    @And("^User selects SignIn$")
    public void selectSignIn() {
     //@TODO scroll to the element and click
        driver.findElement(By.cssSelector("#SubmitLogin")).click();
    }

    @And("^User should see his name as \"([^\"]*)\"$")
    public void user_should_see_his_name_as_something(String userName) {
    Assert.assertEquals(userName, driver.findElement(By.cssSelector(".account")).getText());
    }
}
