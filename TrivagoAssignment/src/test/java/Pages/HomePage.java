package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.Chromaticity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public static Properties prop;
	WebDriver driver;
	public HomePage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = new Properties();
	    FileInputStream fis = new FileInputStream ("..\\TrivagoAssignment\\src\\test\\java\\Config\\config.properties");
		 prop.load(fis);
		}
	
	@FindBy(xpath="//input[@type='search']")
	WebElement DestinationTxt;
	
	@FindBy(xpath="//div[@data-qa='button-inspiration-destination']")
	WebElement DestinationField;
	
	@FindBy(xpath="//span[@class='DestinationItem_label__1nzfS']")
	WebElement DestinationValue;
	
	@FindBy(css=".CalendarControl_calendar__2jbwl")
	WebElement Calendar;
	
	@FindBy(xpath="//div[@data-qa='button-inspiration-checkIn']")
	WebElement Checkin;
	
	@FindBy(xpath="//time[@datetime='2021-06-30']")
	WebElement CheckinData;
	
	@FindBy(xpath="//div[@data-qa='button-inspiration-checkOut']")
	WebElement CheckOut;
	
	@FindBy(xpath="//time[@datetime='2021-07-20']")
	WebElement CheckOutData;
	
	@FindBy(xpath="//div[@data-qa='button-inspiration-guest']")
	WebElement Guest;
	
	@FindBy(xpath="//div[@data-qa='guests-adults-input-minus']")
	WebElement Adult;
	
	@FindBy(xpath="//button[@data-qa='apply-guests']")
	WebElement SubmitAdult;
	
	@FindBy(xpath="//a[@title='Hotel Benn']")
	WebElement HotelName;
	
	@FindBy(xpath="//button[@class='Button_button__1uuDa Button_paddingVerticalMd__1vTMP Button_paddingHorizontalLg__2Fx6w Button_text-align-center__1iMY0 Button_white-space-nowrap__3UDn9 Button_variant-clickout__3X8IK Button_border-radius-sm__fIPfi']")
	WebElement DealButton;
	@FindBy(css=".uitk-button uitk-button-small uitk-button-fullWidth uitk-button-has-text uitk-button-primary uitk-gdpr-banner-btn")
	WebElement AcceptCookie;
	
	
	public void SearchForDestination() throws InterruptedException{
		DestinationField.click();
		DestinationTxt.clear();
		DestinationTxt.sendKeys(prop.getProperty("City"));
		Thread.sleep(4000);
//		Checkin.click();
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOf(Calendar));
//		wait.until(ExpectedConditions.visibilityOf(CheckinData)).click();
//		CheckOut.click();
//		wait.until(ExpectedConditions.visibilityOf(Calendar));
//		wait.until(ExpectedConditions.visibilityOf(CheckOutData)).click();
//		Thread.sleep(4000);
//		Guest.click();
//		Adult.click();
//		SubmitAdult.click();
//		Thread.sleep(4000);
//		wait.until(ExpectedConditions.visibilityOf(HotelName));
//		DealButton.click();
		
	}
	public void SelectTime() throws InterruptedException {
		Checkin.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(Calendar));
		wait.until(ExpectedConditions.visibilityOf(CheckinData)).click();
		CheckOut.click();
		wait.until(ExpectedConditions.visibilityOf(Calendar));
		wait.until(ExpectedConditions.visibilityOf(CheckOutData)).click();
		Thread.sleep(4000);
		}
	
	public void ClickOnDeal() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(HotelName));
		DealButton.click();
		}
	
	public void AdultSelection() throws InterruptedException {
		Guest.click();
		Adult.click();
		SubmitAdult.click();
		Thread.sleep(4000);
	}
	public void AcceptCookies() throws InterruptedException {
		Thread.sleep(4000);
		AcceptCookie.click();
		Thread.sleep(10000);
	}
	
	public void SetUpChrome(String url) {
		driver.get(prop.getProperty("URL"));
		}
	}


