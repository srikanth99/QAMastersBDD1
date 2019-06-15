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
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
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
    public void selectSignInLink() {
        driver.findElement(By.cssSelector(".login")).click();
    }

    @When("^User enter email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void enterLoginCredentials(String email, String password) {
        driver.findElement(By.cssSelector("input[id='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[id='passwd']")).sendKeys(password);
    }

    @When("^User enter email as \"([^\"]*)\"$")
    public void enterCredentials(String email) {
        driver.findElement(By.cssSelector("input[id='email_create']")).sendKeys(email);
    }

    @Then("^User should be on the login page$")
    public void verifyUserIsOnLoginpage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("form[id='login_form']")).isDisplayed());
    }

    @Then("^User should see registration form$")
    public void verifyUserIsOnRegistrationpage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("form[id='create-account_form']")).isDisplayed());
    }

    @Then("^User should be login successfully$")
    public void isUserLoggedIn() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".info-account")).isDisplayed());
    }
    @Then("^User should be able to register successfully$")
    public void isUserEmailRegistered() {

    }
    @Then("^User should not be able to register successfully$")
    public void isUserEmailRegUnsucessfull() {
        //Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed());
    }

    @And("^User selects SignIn$")
    public void selectSignIn() {
     //@TODO scroll to the element and click
        driver.findElement(By.cssSelector("#SubmitLogin")).click();
    }

    @And("^User clicks create an account button$")
    public void clickCreateAccountBtn() {
        //@TODO scroll to the element and click
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
    }


    @And("^User should see his name as \"([^\"]*)\"$")
    public void user_should_see_his_name_as_something(String userName) {
    Assert.assertEquals(userName, driver.findElement(By.cssSelector(".account")).getText());
    }

    @And("^User should see full registration form$")
    public void isAccountCreationFormDisplayed() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#account-creation_form")).isDisplayed());
    }

    @And("^User should see account creation error message as \"([^\"]*)\"$")
    public void verifyErrorMessage(String errorMsg) {
        Assert.assertEquals(errorMsg, driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]/ol/li")).getText());
    }
}
