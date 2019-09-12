package bindings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VehicleSearchStep {
    WebDriver driver;
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tushi\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("^An authorised user navigates to the covercheck website$")
    public void an_authorised_user_navigates_to_the_covercheck_website() throws Throwable
    {
        driver.get("https://covercheck.vwfsinsuranceportal.co.uk/");
        driver.manage().window().maximize();
    }

    @When("^The User  enters the desired registration number in the enter reg field$")
    public void the_User_enters_the_desired_registration_number_in_the_enter_reg_field() throws Throwable
    {
      driver.findElement(By.id("vehicleReg")).clear();
      driver.findElement(By.id("vehicleReg")).sendKeys("OV12UYY");
    }

    @When("^The user clicks on the find vehicle link$")
    public void the_user_clicks_on_the_find_vehicle_link() throws Throwable
    {
    driver.findElement(By.cssSelector("#page-container > .dlg-dealersearch-control > form > button > span")).click();
    }

    @Then("^the vehicle reg search result is displayed$")
    public void the_vehicle_reg_search_result_is_displayed() throws Throwable
    {
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("#page-container > div:nth-child(4) > div.result")).getText(),"Result for : OV12UYY");
        driver.close();
    }

    @When("^The User  enters an invalid registration number in the enter reg field$")
    public void the_User_enters_an_invalid_registration_number_in_the_enter_reg_field() throws Throwable {
        driver.findElement(By.id("vehicleReg")).clear();
        driver.findElement(By.id("vehicleReg")).sendKeys("14RT373");
    }

    @Then("^An error message is displayed$")
    public void an_error_message_is_displayed() throws Throwable {
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("#page-container > div.result")).getText(),"Sorry record not found");
        driver.close();
    }

    @When("^The User leaves registration number field blank$")
    public void the_User_leaves_registration_number_field_blank() throws Throwable {
        driver.findElement(By.id("vehicleReg")).clear();
        driver.findElement(By.id("vehicleReg")).sendKeys("");
    }

    @Then("^An error message is displayed \"([^\"]*)\"$")
    public void an_error_message_is_displayed(String errormessage) throws Throwable {
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("#page-container > .dlg-dealersearch-control > form > div")).getText(),"Please enter a valid car registration");
        driver.close();
    }


}