Feature: Dossier

  Scenario: Maak een Dossier aan
    Given There are no Dossier
    When I create a new Dossier
    Then There is a new Dossier