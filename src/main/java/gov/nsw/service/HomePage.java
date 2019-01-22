package gov.nsw.service;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

    @FindBy(xpath="//input[@id='edit-contains']")
   
    WebElement searchTab;  
    @FindBy(xpath="//input[@id='edit-submit-site-search']")

    WebElement btnSearch;
  
    @FindBy(xpath="//a[@href='/transaction/apply-number-plate']")
    WebElement lnkApplyForPlate;
  
    @FindBy(xpath="//a[contains(text(),'Locate us')]")
    WebElement locateUs;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	/**
	 * @author Tresa
	 * @return
	 */
	public boolean verifySearchTab()
	{
		if(searchTab.isDisplayed() &&  searchTab.isEnabled() )
			return true;
		else
			
			return false;
					
	}

	/**
	 * @author Tresa
	 * @param valueOnSearchTab
	 */
	public void enterValueOnSearchTab(String valueOnSearchTab) {

	searchTab.sendKeys(valueOnSearchTab);
		
	}

	/**
	 *  @author Tresa
	 */
	public void clickOnSearch() {
		btnSearch.click();
		
	}
	
	/**
	 * @author Tresa
	 */
	public void clickOnLocateUs() {
		locateUs.click();
		
	}

	/**
	 * @author Tresa
	 * @param pageLink
	 */
	public void clickOnPageLink(String pageLink) {
		if(pageLink.equalsIgnoreCase("Apply for a number plate"))
		{lnkApplyForPlate.click();}
		
	}
	
	
	

}
