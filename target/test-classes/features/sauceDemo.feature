Feature: Check checkout feature

  Scenario: Check checkout process for norma user
    Given I am on main page
    When I login as normal user
    Then Product page is opened
    When I make order
    Then I have successful order message