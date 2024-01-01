# Author: Sarang Holey | sarangholey@gmail.com
# This file contain scenario's to check login for different user into the application
# All test realed to smoke testing included in this feature file
@userlogin
Feature: E-commerce Project Web Site login user fuctionality

@LoginWithInvalidCredential
Scenario Outline: User login with three different  invalid emailId and password
Given User click on signup/login button
When  User redirect to the signup/login page with title as "Automation Exercise - Signup / Login"
And  user able to see "Login to your account" section on login page
And  User enter "<EmailId>" and "<password>"
And  User click on login button
Then User verify the error message "Your email or password is incorrect!"
Examples:
| EmailId                   | password  |
| tompeter0597@gmail.com    | test@0597 |
| johnnyDepp123@gmail.com   | test@123  |
| stephanieJoe444@gmail.com | test@444  |


@LoginWithValidCredential
Scenario Outline: User login with two different valid emailId and password
Given User click on signup/login button
When  User redirect to the signup/login page with title as "Automation Exercise - Signup / Login"
And   user able to see "Login to your account" section on login page
And   User enter valid "<ValidEmailId>" and "<Validpassword>" for login
And   User click on login button
Then  User verify with "<username>" just after Logged in as button 
And   User click on logout button
Examples:
| ValidEmailId            | Validpassword | username      |
|  ciwika1748@frandin.com | 123456.Abc    | Ryan Wick     |
|  ciwika1744@frandin.com | 123456.Abc    | James Richard |