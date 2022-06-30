Feature: Selenium Test

  Scenario: Search a Character at the list
    Given Navigate to Search page https://dsternlicht.github.io/RESTool/#/characters?search=
    When Type on search box the value Arya
    And clicks on Submit
    Then shows a card which includes the name Arya, the real name Maisie, and current location Winterfell