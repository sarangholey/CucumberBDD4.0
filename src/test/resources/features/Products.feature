# Author: Sarang Holey | sarangholey@gmail.com
# This file contain scenario's to check a products page functionality

@roductsPage
Feature: E-commerce Project Web Site Prodcuts Page Options

@ProdSearch
Scenario Outline: User is able to search a product on the application
Given user navigate to the home application url
When user header over to products page
And  user redirected to products page with title as "Automation Exercise - All Products"
And url for the login page contains the "products" as keyword
And user search for a product "<product_name>"
And click on search button
Then from the product list the first product contain the "<product_name>" as keyword
Examples:
  |product_name|
  | White			 |
  | Top   		 |
  | Dress   	 |
  | Tshirt		 |