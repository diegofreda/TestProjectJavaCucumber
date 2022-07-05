Feature: Selenium Test

  Scenario Outline: Add a Character at the list
    Given Navigate to Search page https://dsternlicht.github.io/RESTool/#/characters?search=
    When clicks on +Add Item
    And enter a valid data: <THUMBNAIL>, <NAME>, <REAL NAME>, <LOCATION>, <ALIVE>
    And clicks on Submit Item
    And  Type on search box the value <NAME>
    And clicks on Search Submit
    Then shows a card which includes the name <NAME>, the real name <REAL NAME>, and current location <LOCATION>

    Examples:
      | THUMBNAIL      | NAME      | REAL NAME  | LOCATION      | ALIVE  |
      | THUMBNAIL TEST | Robert B  | Chespirito | Kings Landing |   NO   |


  Scenario: Search an existing Character at the list
    Given Navigate to Search page https://dsternlicht.github.io/RESTool/#/characters?search=
    When Type on search box the value Arya
    And clicks on Search Submit
    Then shows a card which includes the name Arya, the real name Maisie, and current location Winterfell