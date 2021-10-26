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

Feature: Register an user

#Background :WebDriver is set
#Given Driver ChromeDriver
#When Initialised
#Then Chromdriver is initialised

  Scenario: Filling the Registration form
    Given url "http://demo.opencart.com/index.php?route=account/register"
    And registration details
    |Learn|IT|learnIt@tools|319-804-6082|password|NO|
    When I click on submit
    Then I validate the outcomes
    

 