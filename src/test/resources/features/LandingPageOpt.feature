# Author: Sarang Holey | sarangholey@gmail.com
# This file contain scenario's to check a status of application search functionality

@LandingPage
Feature: E-commerce Project Web Site Landing Page Options

@LandingPageHaderOptions
Scenario: Validate the different header options on the landing page of the application
Given user navigated to landing pag of the application with current url as "https://automationexercise.com/"
When the entire header section is visible
Then following options are available under the header section
| Home            |
| Products        |
| Cart            |
| Signup / Login  |
| Test Cases      |
| API Testing     |
| Video Tutorials |
| Contact us      |

@LandingPageHaderOptions
Scenario: Validate the different header options on the landing page of the application
Given user navigated to landing pag of the application with current url as "https://automationexercise.com/"
When the entire header section is visible
Then following options are available under the header sections
| HeaderLinkTxt		| HeaderLinkRedirectionPageTitle													|
| Home            | Automation Exercise 																		|
| Products        | Automation Exercise - All Products 											|
| Cart            | Automation Exercise - Checkout 													|
| Signup / Login  | Automation Exercise - Signup / Login 										|
| Test Cases      | Automation Practice Website for UI Testing - Test Cases |
| API Testing     | Automation Practice for API Testing 										|
| Video Tutorials | (212) AutomationExercise - YouTube 											|
| Contact us      | Automation Exercise - Contact Us 												|

@ValidateHeaderSection
Scenario: User is able to open the browser, navigate to the url and validate the header section elements of webpage
Given User Click on product button
When User redirected to product page with title as "Automation Exercise - All Products" 
And  User click on cart button 
And  User redirected to cart page with title as "Automation Exercise - Checkout"
And  User click on signup/login button
And  User redirect to the signup/login page with title as "Automation Exercise - Signup / Login"
And  User Click on test cases button
Then User verify Test page url "https://automationexercise.com/test_cases"
When User click on API Testing button
Then User verify "APIS LIST FOR PRACTICE" text is visible
When User cilck on Video Tutorials button
And  User redirected to you tube video page with url as  "https://www.youtube.com/c/AutomationExercise"
And  User click on contact us button of the header section
Then User verify the page title "Automation Exercise - Contact Us"