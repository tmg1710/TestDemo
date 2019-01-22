package gov.nsw.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class StepDefinition extends BaseClass {

	WebDriver driver;
	private ExtentReports report;
	private ExtentTest test;
	String pagename;
	String suburb;
	HomePage homepage;
	NumberPlate numberPlate;
	Properties prop = new Properties();
	



	@Before
	public void setup() throws FileNotFoundException, IOException {
		
		
		prop.load(new FileInputStream(System.getProperty("user.dir") +"//src//test//resources//User.properties"));
		driver = getDriver(prop.getProperty("driver"));
		
		driver.manage().window().maximize();
		
		homepage = new HomePage(driver);
		numberPlate = new NumberPlate(driver);
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");

	}

	@Given("^User Navigates to \"([^\"]*)\"$")
	public void User_Navigates_to(String url) {
		try {
			driver.get(url);
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Failed to Naviga to the specified URL");
		}
	}

	@When("^User is able to see the Home Page$")
	public void User_is_able_to_see_the_Home_Page() {

		try {
			if (homepage.verifySearchTab()) {

				test.log(LogStatus.PASS, "User is able to see the Home Page");

			}

			else

			{

				test.log(LogStatus.FAIL, "ser is not able to see the Home Page");
				throw new Exception();

			}
		}

		catch (Exception ex) {
			test.log(LogStatus.FAIL, "Test Failed");
		}

	}

	@When("^User Enters \"([^\"]*)\" on Search Tab$")
	public void User_Enters_on_Search_Tab(String valueOnSearchTab) {
		try {

		homepage.enterValueOnSearchTab(valueOnSearchTab);
		pagename = valueOnSearchTab;
		test.log(LogStatus.PASS, "User Enters value on Search Tab");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "User does not Enter value on Search Tab");
		}
	}

	@When("^User Clicks on Search Button$")
	public void User_Clicks_on_Search_Button() {
		try{homepage.clickOnSearch();
		test.log(LogStatus.PASS, "User Clicks on Search Button");
		}
	
	catch(Exception e)
	{
		test.log(LogStatus.FAIL, "User does not Click on Search Button");
	}
		}
	

	@When("^User Clicks on \"([^\"]*)\"$")
	public void User_Clicks_on(String pageLink) {
		homepage.clickOnPageLink(pageLink);

	}

	@Then("^Validate the navigation to appropriate page$")
	public void Validate_the_navigation_to_appropriate_page() {
		if (pagename.equalsIgnoreCase("Apply for a number plate"))

			if (numberPlate.validatetitle())
				test.log(LogStatus.PASS, "Navigated Apply for number Plate");
	}

	@When("^User Click on Locate us button$")
	public void User_Click_on_Locate_us_button() {
		homepage.clickOnLocateUs();

	}
	@Then("^Click on Locate us button$")
	public void Click_on_Locate_us_button() {
	    // Express the Regexp above with the code you wish you had
		homepage.clickOnLocateUs();

	}

	@When("^User Enters suburb \"([^\"]*)\"$")
	public void User_Enters_suburb(String suburb) {
		try {
			numberPlate.enterSub(suburb);
			this.suburb = suburb;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^Validate available service centre named as \"([^\"]*)\"$")
	public void Validate_available_service_centre_named_as(String serviceCentre) throws InterruptedException {
		if (numberPlate.validateServiceCentre(serviceCentre))

			test.log(LogStatus.PASS, "Navigated to the specified URL");

	}

	@After
	public void tearDown() {
		report.endTest(test);

		report.flush();
		driver.close();
		driver.quit();

	}
}
