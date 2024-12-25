#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Customer Sign In

  @SignIn
  Scenario Outline: Customer sign in with valid credentials
    Given I am on the home page
    When I click on Sign In link
    And I should be redirected to the Customer Login page
    And I enter sign in information <email> and <password>
    And I click on Sign In button
    Then I should be redirected to Home page
    And Welcome user <fullName> is displayed

    Examples: 
      | email  											| password | fullName 		|
      | amit13.shekhar@outlook.com 	| $eleniuM | amit shekhar	|
