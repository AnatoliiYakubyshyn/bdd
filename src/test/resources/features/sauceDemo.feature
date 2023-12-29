Feature: Check checkout feature

  Scenario: Check checkout process for norma user
    Given I am on main page
    When I login as normal user
    Then Product page is opened
    When I make order
    Then I have successful order message

  Scenario: Check sum of order is correct for user with id 2
    Given I am on main page
    When I login as "6" user
    Then Product page is opened
    When I proceed to checkout overview
    Then I have correct total sum

