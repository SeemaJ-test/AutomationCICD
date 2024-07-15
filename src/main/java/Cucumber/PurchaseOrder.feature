
@tag
Feature: purchase the order from ecommerce website 
  I want to use this template for my feature file

Background:
   Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of submitting order
    Given logged in with username <username> and password <password>
    When I add product to  <productName> to cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER"mesage is displyed on ConfirmationPage
    
    Examples: 
      | name                   |   password   | productName  |
      |xoweke7325@dalebig.com  |   Qwerty123  | ZARA COAT 3  |
      | name2 |     7 | Fail    |
