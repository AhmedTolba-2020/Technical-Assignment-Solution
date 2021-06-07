package StepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDef_UI {
	
	public static WebDriver driver;
	public static String NewNum = ""+(int)(Math.random()*Integer.MAX_VALUE);
	public static String EmailAddress = "EmailTest"+NewNum+"@test.io";
	public static Properties prop;
	
	
	@Before
	public void Setup() throws IOException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		prop = new Properties();
	    FileInputStream fis = new FileInputStream ("..\\TrivagoAssignment\\src\\test\\java\\Config\\config.properties");
		 prop.load(fis);
	}
	
	@Given("^User navigates to weekend trivago website$")
	public void user_navigates_to_weekend_trivago_website() throws IOException {
		HomePage hpage = new HomePage(driver);
		hpage.SetUpChrome("URL");
	}

	@When("^Set \"([^\"]*)\" in destination field$")
	public void set_in_destination_field(String arg1) throws Throwable {
		HomePage hpage = new HomePage(driver);
		hpage.SearchForDestination();
	}

	@And("^Select the period time$")
	public void Select_the_period_time() throws Exception {
		HomePage hpage = new HomePage(driver);
		hpage.SelectTime();
		hpage.AdultSelection();
	}

	@When("^Click on View Deal$")
	public void Click_on_View_Deal()throws Exception {
		HomePage hpage = new HomePage(driver);
		hpage.ClickOnDeal();
	}

	@Then("^user navigates to the right page$")
	public void user_navigates_to_the_right_page() throws Exception {
		HomePage hpage = new HomePage(driver);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://weekend.trivago.co.uk"));
	}
	
	@After
	public void tearDown() {
    driver.close();
   
	}
	
}