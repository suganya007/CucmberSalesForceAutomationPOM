
Feature: Login
Background:
    Given user go to "https://login.salesforce.com/"

  Scenario: login with correct username and no password
  
  	When user on "LoginPage"
    And user enters "sugan@enexus.com" in username field
    And "" in password field
    And user click on login button
    Then validate error message "Please enter your password."

   Scenario: rememberme check
    
    When user on "LoginPage"
    And user enters "sugan@enexus.com" in username field
    And "myTest@2022" in password field
    And select the rememberme checkbox
    And user click on login button
  	And user on "HomePage"
    And user click on logout button
  	When user on "LoginPage"
    Then validate username should be "sugan@enexus.com"

   Scenario: forgot password
    
      When user on "LoginPage"
  		And user clicks forgot password
  		And user enters "sugan@enexus.com" in username field in forgot password
  		And user click on continue button
  		Then validate the text message "Check Your Email"
  		
  Scenario: login with incorrect username and incorrect password
    
      When user on "LoginPage"
  	  And user enters "123" in username field
      And "22131" in password field
    	And user click on login button
   	  Then validate error message "Please check your username and password. If you still can't log in, contact your Salesforce administrator."