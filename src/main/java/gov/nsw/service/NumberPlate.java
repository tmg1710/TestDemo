package gov.nsw.service;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NumberPlate {
	WebDriver driver;

    @FindBy(xpath="//h1[contains(text(),'Apply for a number plate')]")
   
    WebElement numberPlatePageHeader;  
    
    @FindBy(xpath="//input[@id='locatorTextSearch']")
    WebElement locatorSearch;
    
  
    @FindBy(xpath="//*[@id='locator']//button[@type='submit']")
    WebElement searchButton;
    
  
    @FindBy(xpath="//*[@id='locatorListView']//div[1]/a[@class='location__title']")
    WebElement firstServiceCentre;

	public NumberPlate(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	/**
	 * @author Tresa
	 * @param suburb
	 * @throws InterruptedException
	 */
	public void enterSub(String suburb) throws InterruptedException {

		
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[@id='locatorTextSearch']"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locatorSearch);
		locatorSearch.sendKeys(suburb);
		searchButton.click();
		
	}

	/**
	 * @author Tresa
	 * @param serviceCentre
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateServiceCentre( String serviceCentre) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id='locatorListView']//div[1]/a[@class='location__title']"))));
		
			return firstServiceCentre.getText().contains(serviceCentre);
		}

	/**
	 * @author Tresa
	 * @return
	 */
	public boolean validatetitle() {
		if(numberPlatePageHeader.isDisplayed())
			return true;
		else
			return false;
		
	}
		
	}
	
	
	

