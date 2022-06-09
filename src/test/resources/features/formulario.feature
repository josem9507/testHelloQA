#language: en
  Feature: : register form
    I a new client
    I want to register my data
    to have my updated information
  Scenario: : Form registration with valid data
    Given that the DEMOQA website is available
    When register my data
    And I click on the button
    Then my data is displayed on the screen