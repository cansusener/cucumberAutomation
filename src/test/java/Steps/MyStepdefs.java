package Steps;

import Base.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.UUID;

public class MyStepdefs extends BaseStep {
    String uuid = UUID.randomUUID().toString();


    @Given("^a web browser is at the home page$")
    public void aWebBrowserIsAtTheHomePage() {
        geturl();
    }

    @When("^the user click dropdown$")
    public void theUserClickDropdown() {
       //getRegister = By.xpath("//div[@id='myAccount']");
       //register = By.xpath("//a[@id='register']");
        findElementClick("myAccount",Paths.id);
    }

    @And("^user clicks on the registration item$")
    public void userClicksOnTheRegistrationItem() {
        findElementClick("//a[@id='register']",Paths.xPath);
    }

    @Then("^user sees the registration form$")
    public void userSeesTheRegistrationForm() {
        waitElement(findElement("//input[@type='email']",Paths.xPath,""),TimeOut.LOW);
    }

    @And("^user enters the email$")
    public void userEntersTheEmail() {
        //input[@id='txtEmail'] xpath hali
        findElement("txtEmail",Paths.id ,TimeOut.LOW).sendKeys("csu@hotmail.com");
        //devam et butonu
        findElementClick("//button[@id='btnSignUpSubmit']",Paths.xPath);

    }

    @And("^user enters the name$")
    public void userEntersTheName() {
        PageScrolldown();
        findElement("firstname",Paths.id,"").sendKeys("TestAd");
    }

    @And("^user enters the surname$")
    public void userEntersTheSurname() {
        findElement("lastname",Paths.id,"").sendKeys("TestSoyad");

    }

    @And("^user enters password$")
    public void userEntersPassword() {
        findElement("password-register",Paths.id,"").sendKeys("1A*"+ uuid);
    }


    @And("^user click submit button$")
    public void userClickSubmitButton() {
        findElementClick("form#form-user > div:nth-of-type(6) > button",Paths.cssSelector);
    }

    @And("^driver close$")
    public void driverClose() {
    }
}
