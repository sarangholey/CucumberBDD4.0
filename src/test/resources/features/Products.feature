# Author: Sarang Holey | sarangholey@gmail.com
# This file contain scenario's to check a products page functionality

@productsPage
Feature: E-commerce Project Web Site Prodcuts Page Options

@prodSearch
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

@productAddToCart
Scenario: User is able to search for various products and add each type of products into cart
Given User navigated to the home application url
When user header over to products page
And User search following product from search box and add into cart
| ITEM 												|PRODUCT_NAME								| QUANTITY |
|Dress												|Printed Chiffon Dress			| 1				 |
|T-shirts											|Faded Short Sleeve T-shirts| 2				 |
|Casual												|Printed Dress							| 3				 |
Then User cart is updated with the products and quantity