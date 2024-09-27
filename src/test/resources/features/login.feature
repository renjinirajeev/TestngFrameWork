Feature: Login functionality

  Scenario Outline: verify user can login
    Given user opens the website
    Then verify user is on homePage
    When user login with valid credentials username "<username>" and password "<password>"
    Then verify user login successfully
      Examples:
      | username | password |
      | admin    | admin123 |