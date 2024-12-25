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
Feature: Create Account

  @Register
  Scenario Outline: Successful User Registration
		Given I am on the home page
		When I click on Create an Account link
		And I should be redirected to the Create New Customer Account page
		And I enter <firstName>, <lastName>, <email> and <password>
		And I click Create an Account button
		Then I should be redirected to the My Account page
		And "Thank you for registering with Main Website Store." success message is displayed
		
    Examples: 
      | firstName | lastName	| 		email										| password  |
      | amit 			| shekhar		| amit13.shekhar@outlook.com 	|	$eleniuM	|
