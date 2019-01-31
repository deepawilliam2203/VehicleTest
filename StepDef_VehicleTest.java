package StepDefinition;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDef_VehicleTest {
	WebDriver driver;
	
	
	
	@Before
	public void setup_browser() {
		System.setProperty("webdriver.chrome.driver", "c:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}
	@After
	public void tearDown() throws InterruptedException {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}
	
	@Given("^user navigates to the insurance URL$$")
	public void user_navigates_to_insurance_URL() throws Throwable {
		driver.get("https://covercheck.vwfsinsuranceportal.co.uk/");
		//System.out.println("URL");
	}

	@When("^the user enters the registration number$")
	public void the_user_enters_the_Registration_number() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.id("vehicleReg")).sendKeys("OV12UYY");
		Thread.sleep(2000);
		driver.findElement(By.name("btnfind")).click();
		//System.out.println("when");
	}

	@Then("^the registration number should be displayed$")
	public void the_registration_number_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		String res = driver.findElement(By.className("result")).getText();
		if(res.contains("OV12UYY")) {
			assert (true);
			System.out.println("vehicle exists");
		}
		else if (res.contains("record not found"))
			assert (false);
		else
			assert (false);
			
		//System.out.println("Then");
	}
}
