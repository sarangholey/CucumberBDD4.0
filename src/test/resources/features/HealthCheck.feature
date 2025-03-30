# Author: Sarang Holey | sarangholey@gmail.com
# This file contain basic scenario's to check a status of application
# All test realed to smoke testing included in this feature file

@ui @healthckeck @smoke
Feature: E-commerce Project Web Site Health Check

@appUrlRedirection
Scenario: Validate application is redirecting to correct url
Given User navigated to the home application url
When User is on application landing page
Then Application url is redirected to "https://automationexercise.com/"

@titleCheck
Scenario: Validate application title is correct
Given User navigated to the home application url
When User is on application landing page
Then Application title is "Automation Exercise"