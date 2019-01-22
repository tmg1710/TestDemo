
Feature: Verify that the application returns "Marrickville Service Centre" when searching for
locations for Sydney 2000.
	
	Scenario: Successfully verify
		Given User is able to see the Home Page
		When User Navigates to "https://www.service.nsw.gov.au/"
    And User Enters "Apply for a number plate" on Search Tab
    And User Clicks on Search Button
    And User Clicks on "Apply for a number plate"   
    Then Validate the navigation to appropriate page
    And Click on Locate us button
    When User Enters suburb "Newtown 2042"
    Then Validate available service centre named as "Marrickville Service"
    
    
    Scenario Outline: Successfully verify part 2
		Given User is able to see the Home Page
		When User Navigates to "https://www.service.nsw.gov.au/"
    And User Enters "Apply for a number plate" on Search Tab
    And User Clicks on Search Button
    And User Clicks on "Apply for a number plate"   
    Then Validate the navigation to appropriate page
    And Click on Locate us button
    When User Enters suburb "<Suburb Name>"
    Then Validate available service centre named as "<Service Centre>"
    
    Examples:
      |Suburb Name|Service Centre|
      |Sydney Domestic Airport 2020|Botany Service Centre|
      |Sydney Domestic Airport 2020|Rockdale Service Centre|
      |Surry Hills 2010|Haymarket Service Centre|
    

    
    
  