package enrolmentAutomation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EnrolementStepsToExlibris 
{

	static WebDriver driver;
	static WebElement username;
	static WebElement password;
	static WebElement loginButton;
	static  String dateOfBirth;
	static WebElement enrolmentButton;
	static WebElement yourDetailsButton;
	static WebElement personalDetailsButton;
	static WebElement date;
	static WebElement gender;
	

@Given("^I Opened the browser and navigate to Exlibris website$")
public void i_Opened_the_browser_and_navigate_to_Exlibris_website() throws Throwable 
{
	System.setProperty("webdriver.chrome.driver", "C:/Users/ramesh mittal/workspace/new/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://m.campusm.org/campusm/");
}

@When("^I choose the Student/Staff option and click on the Accept button for terms$")
public void i_choose_the_Student_Staff_option_and_click_on_the_Accept_button_for_terms() throws Throwable 

{
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
// Click on Student/Staff 
	driver.findElement(By.xpath(ObjectRepository.STUDENTSTAFF_HEADER)).click();
	
// Accept the Terms
	driver.findElement(By.xpath(ObjectRepository.ACCEPT_TERMS)).click();

    
}

@Given("^entered wrong login credentials, click and validate the Login button and validate the error message$")
public void entered_wrong_login_credentials_click_and_validate_the_Login_button_and_validate_the_error_message() throws Throwable 
{
//Enter wrong credentials
	
	username = driver.findElement(By.id(ObjectRepository.USER_NAME));
	username.sendKeys("Swati");	
	password = driver.findElement(By.id(ObjectRepository.PASSWORD));
	password.sendKeys("abc123");
	
// Click and Validate Login button
	
    loginButton = driver.findElement(By.xpath(ObjectRepository.LOGIN_BUTTON));	
	System.out.println("Verification for Login button: "+loginButton.isDisplayed());
	loginButton.click();
	
// Verify that displayed error message is “Please try again.”
		
	String actual = driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();	
	System.out.println("Expected error is Please try again and the Actual error message displayed is: "+ actual);
    
}

@When("^I entered the valid credentials and click on the Login btton$")
public void i_entered_the_valid_credentials_and_click_on_the_Login_btton() throws Throwable 

{
// Clear the wrong user name and password and enter valid credentials
	
	    username.clear();
		username.sendKeys("joshua.c");
		
		password.clear();
		password.sendKeys("campusm");
		
		loginButton.click();
}

@Then("^I will reach on the Home page$")
public void i_will_reach_on_the_Home_page() throws Throwable 

{	
// Verify Home page 
	WebElement image= driver.findElement(By.xpath(ObjectRepository.IMAGE));
	System.out.println(image.isDisplayed());		
}

@When("^I click on the Enrolement button and Your Details button and Personal Details button$")
public void i_click_on_the_Enrolement_button_and_Your_Details_button_and_Personal_Details_button() throws Throwable 
{
   
// Click on the Enrolment button
		enrolmentButton = driver.findElement(By.xpath(ObjectRepository.ENROLMENT_BUTTON));
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(enrolmentButton)).click();
		
// Switch to Frame
		
		driver.switchTo().frame(ObjectRepository.FRAME);
		
// Click on Your details button
		
		yourDetailsButton = driver.findElement(By.xpath(ObjectRepository.YOURDETAILS_BUTTON));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(yourDetailsButton)).click();
		
//  Click on Personal details
		
		personalDetailsButton = driver.findElement(By.xpath(ObjectRepository.PERSONALDETAILS_BUTTON));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(personalDetailsButton)).click();
}

@When("^Store the date of birth value in a variable and change the Date of Birth$")
public void store_the_date_of_birth_value_in_a_variable_and_change_the_Date_of_Birth() throws Throwable

{
// Store Date of Birth value in a variable
	
	 date = driver.findElement(By.id(ObjectRepository.DATE));
     dateOfBirth = date.getAttribute("value"); 
    
    System.out.println( dateOfBirth);
    
// Change Date of Birth to 27-12-1990 
    date.clear();
    date.sendKeys("27-12-1990");
    
}

@When("^Add First Name, Last Name in the Parent's/Gurdian's section and emeil address in contact information and select Male as title$")
public void add_First_Name_Last_Name_in_the_Parent_s_Gurdian_s_section_and_emeil_address_in_contact_information_and_select_Male_as_title() throws Throwable

{
// Enter First Name as Demo and Last Name as User
	
	driver.findElement(By.id(ObjectRepository.FIRST_NAME)).sendKeys("Demo");	
	driver.findElement(By.id(ObjectRepository.LAST_NAME)).sendKeys("User");
	
// Enter email address 
	
	driver.findElement(By.id(ObjectRepository.EMAIL_ID)).sendKeys("demo.user@myemail.com");
	
// Select Gender as Male
	gender = driver.findElement(By.id(ObjectRepository.GENDER));
	Select selectGender = new Select(gender);
	selectGender.selectByVisibleText("Male");
    
}

@When("^Close the tile$")
public void close_the_tile() throws Throwable 
{	
	driver.switchTo().defaultContent();	
	driver.findElement(By.xpath(ObjectRepository.CLOSE_BUTTON)).click();	
}

@Given("^To verify I click on Enrolment->Your Details->Personal Details$")
public void to_verify_click_on_Enrolment_Your_Details_Personal_Details() throws Throwable
{
    Thread.sleep(5000);
// Click on the Enrolment button
 		enrolmentButton = driver.findElement(By.xpath(ObjectRepository.ENROLMENT_BUTTON));
 		WebDriverWait wait = new WebDriverWait(driver, 40);
 		wait.until(ExpectedConditions.elementToBeClickable(enrolmentButton)).click();
 		
// Switch to Frame
 		
 		driver.switchTo().frame("web2AekFrame");
 		
 // Click on Your details button
 		
 		yourDetailsButton = driver.findElement(By.xpath(ObjectRepository.YOURDETAILS_BUTTON));
 		wait = new WebDriverWait(driver, 30);
 		wait.until(ExpectedConditions.elementToBeClickable(yourDetailsButton)).click();
 		
 //  Click on Personal details
 		
 		personalDetailsButton = driver.findElement(By.xpath(ObjectRepository.PERSONALDETAILS_BUTTON));
 		wait = new WebDriverWait(driver, 30);
 		wait.until(ExpectedConditions.elementToBeClickable(personalDetailsButton)).click();
 }

@Given("^validate Date of Birth \\(shows updated date of birth\\)$")
public void validate_Date_of_Birth_shows_updated_date_of_birth() throws Throwable 

{
	String expectedDate = "1990-12-27";
	String actualDate = driver.findElement(By.id(ObjectRepository.DATE)).getAttribute("value");	
	System.out.println("Expected result is true while actual result is: "+expectedDate.equals(actualDate));
   
}

@Given("^validate Parent's/Guardian's First Name and LastName$")
public void validate_Parent_s_Guardian_s_First_Name_and_LastName() throws Throwable 

{
	String expectedFirstName =driver.findElement(By.id(ObjectRepository.FIRST_NAME)).getAttribute("value");
	String actualFirstName = "Demo";
	System.out.println("Expected result for first name is true while actual result is: "+expectedFirstName.equals(actualFirstName));
	
	String expectedLastName = driver.findElement(By.id(ObjectRepository.LAST_NAME)).getAttribute("value");
	System.out.println("Expected result for last name is User while actual result is: "+expectedLastName);

}

@Given("^validate Gender and Email Address$")
public void validate_Gender_and_Email_Address() throws Throwable 

{
	String expectedEmailid = driver.findElement(By.id(ObjectRepository.EMAIL_ID)).getAttribute("value");
	String actualEmailid   ="demo.user@myemail.com";
	System.out.println("Expected result for email id is true while actual result is: "+expectedEmailid.equals(actualEmailid));
	
	
    
}

@Given("^I update Date of Birth to the saved from variable$")
public void i_update_Date_of_Birth_to_the_saved_from_variable() throws Throwable

{
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebElement date1 = driver.findElement(By.id(ObjectRepository.DATE));
	
	
	SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-mm-dd");
	Date myDate = newDateFormat.parse(dateOfBirth);
	newDateFormat.applyPattern("dd-mm-yyyy");
	String myDateString = newDateFormat.format(myDate);	
	date1.sendKeys(myDateString);
	
	
	
	
}

@Given("^updated First Name to Blank and Last Name to Blank and Genter Prefer not to say, Email to Blank and close the tile$")
public void updated_First_Name_to_Blank_and_Last_Name_to_Blank_and_Genter_Prefer_not_to_say_Email_to_Blank_and_close_the_tile() throws Throwable 

{
// Update First name, Last Name and email to blank
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	Actions act=new Actions(driver);
	act.click(driver.findElement(By.name(ObjectRepository.FIRSTNAME))).sendKeys(Keys.chord(Keys.CONTROL,"a")).sendKeys(Keys.BACK_SPACE).build().perform();;	
	act.click(driver.findElement(By.name(ObjectRepository.LASTNAME))).sendKeys(Keys.chord(Keys.CONTROL,"a")).sendKeys(Keys.BACK_SPACE).build().perform();;	
	act.click(driver.findElement(By.name(ObjectRepository.EMAIL))).sendKeys(Keys.chord(Keys.CONTROL,"a")).sendKeys(Keys.BACK_SPACE).build().perform();;	

// Change Gender to Prefer not to say
	
	gender = driver.findElement(By.id(ObjectRepository.GENDER));
	Select changeGender = new Select(gender);
	changeGender.selectByVisibleText("Perfer not to say");
	

// Close the Tile 
	
	driver.switchTo().defaultContent();
    driver.findElement(By.xpath(ObjectRepository.BACK_BUTTON)).click();
    driver.findElement(By.xpath(ObjectRepository.BACK_BUTTON)).click();	
	act.sendKeys(Keys.ESCAPE).build().perform();;	
    
}

@When("^I click on Angle button on the top right of the page and click on Log Out$")
public void i_click_on_Angle_button_on_the_top_right_of_the_page_and_click_on_Log_Out() throws Throwable 
{
     driver.findElement(By.xpath(ObjectRepository.ANGLE_BUTTON)).click();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.findElement(By.xpath(ObjectRepository.LOGOUT)).click();
    

}

@Then("^I verify that user is logged out$")
public void i_verify_that_user_is_logged_out() throws Throwable 
{
	Thread.sleep(5000);
	String expectedURL = "https://m.campusm.org/campusm/home#select-profile";
	String actualURL = driver.getCurrentUrl();
	System.out.println("Expected result is true while actual result is: "+expectedURL.equals(actualURL));	
	driver.close();
}

}
