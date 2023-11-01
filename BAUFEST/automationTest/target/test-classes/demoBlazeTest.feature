#Author: rbarbosait@gmail.com
#Keywords Summary : Baufest Automation Test

@tag
Feature: Test demoBlaze web page
  I want to test some required actions through Google chrome

  @tag1_navigateToPage
  Scenario: Navigate to demoBlaze web
    Given I lunch Google Chrome browser
   	When I navigate to the url
    Then I validate the title of the web page
    
  @tag2_signUpUser
 Scenario: Sign up a new user
    Given I lunch Google Chrome browser 
    And Navigate to demoBlaze web
    When I signUp a new user
    Then I validate the user was created
    
    @tag3_logIn/logOffUser
  Scenario: LogIn LogOut with new user created 
    Given I lunch Google Chrome browser 
    And Navigate to demoBlaze web
    When I Login with user
    Then I validate the user logedIn
    When I LogOut with user
    Then I validate the user logedOut
    
    @tag4_signUpUser
  Scenario: Add product to cart and verify product at the cart
    Given I lunch Google Chrome browser 
    And Navigate to demoBlaze web
    And I Login with user 
    When I add a product/laptop to cart
    Then I validate the product/laptop was added to cart
    When I LogOut with user
    Then I LogIn and validate the product is at the cart
   
