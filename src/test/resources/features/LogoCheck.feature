 #Author: Sarang Holey | sarangholey@gmail.com
 #This file contain basic scenario's to check a status of application logo

@logo 
Feature: E-commerce Project Web Site logo Check

  @appLogoDisplay
  Scenario: Validate application logo is displayed
    Given User navigated to the home application url
    When User is on application landing page
    Then Application logo is displayed