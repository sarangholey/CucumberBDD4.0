# Author: Sarang Holey | sarangholey@gmail.com
# This file contain basic scenario's to check a status of application logo/banners

@ui @api @logo 
Feature: E-commerce Project Web Site logo Check

@appLogoDisplay
Scenario: Validate application logo is displayed
Given User navigated to the home application url
When User is on application landing page
Then Application logo is displayed

@landingPageImages @api @imgHttpStatus
Scenario: Validate application logo is displayed
Given User navigated to the home application url
When User is on application landing page
Then all images on landing page loaded with "200" status code