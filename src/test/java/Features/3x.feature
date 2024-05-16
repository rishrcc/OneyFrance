Feature: 3x with weak authentication - Consultation des pages

  @Coordonnees
  Scenario Outline: Verify that after logging in with existing 3x user, the details are correct on Mes Coordonnees

    Given I am logged in with <username> and <password> on weak authentication
    And I am seeing my first name from <fullname> on dashboard
    When I click on coordonnees
    Then I should see the <fullname>

    Examples:
      | fullname     | username  | password |
      | Adem LAMBERT | 306137191 | 12345    |

  @Dashboard
  Scenario Outline: Verify that after logging in with existing 3x user, the details are correct on Dashboard

    Given I am logged in with <icon> user on weak authentication
    Then I should see <product> on the side menu
    And I should see <product> and <icon> on the main page
    And I should expect to see <product> and <number_of_installments> installments under Mes prochains prelevements

    Examples:
      | product                                                 | icon | number_of_installments |
      | Mon paiement 3x Oney chez VAD2 EN PROTOCOLE CB2A DIRECT | 3x   | 2                      |


  @MesProduits
  Scenario Outline: Verify that after logging in with existing 3x user, the details are correct on Mes Produits

    Given I am logged in with <icon> user on weak authentication
    When I click on product from the side menu
    Then I should see <title> as title
    And I should see <subtitle> as subtitle
    And I should see <icon> as logo
    And I should see <number_of_installments> as number of installments in the payment information


    Examples:
      | title                | subtitle                           | icon | number_of_installments |
      | Mon paiement 3x Oney | chez VAD2 EN PROTOCOLE CB2A DIRECT | 3x   | 2                      |


  @ChangeCard
  Scenario Outline: Verify that after logging in with existing 3x user, the details are correct when changing the carte de prelevement

    Given I am logged in with <icon> user on weak authentication
    When I click on product from the side menu
    And I click on change card
    Then I should be able to see <product> and the <icon> on the change of card screen
    And I should be able to cancel the change on the card

    Examples:
      | product                                           | icon |
      | Paiement en 3x chez VAD2 EN PROTOCOLE CB2A DIRECT | 3x   |

    
  @Echeanciers
  Scenario Outline: Verify that after logging in with existing 3x user, the details are correct on Echeanciers main page

    Given I am logged in with <icon> user on weak authentication
    When I click on echeancier
    Then I should be able to see <product> and the <icon> on the echeancier main screen
    And I should see echeancier initial and echeancier actualise

    Examples:
      | product                                                 | icon |
      | Mon paiement 3x Oney chez VAD2 EN PROTOCOLE CB2A DIRECT | 3x   |

  @Echeanciers @Initial
  Scenario Outline: Verify that after logging in with existing 3x user, the details are correct on Echeanciers Initial page

    Given I am logged in with <icon> user on weak authentication
    When I click on echeancier
    And I click on echeancier initial
    Then I should be able to see <product> and the <number_of_installments> on the echeancier initial screen

    Examples:
      | product                                                 | icon | number_of_installments |
      | Mon paiement 3x Oney chez VAD2 EN PROTOCOLE CB2A DIRECT | 3x   | 2                      |

  @Echeanciers @Actualise
  Scenario Outline: Verify that after logging in with existing 3x user, the details are correct on Echeanciers Actualise page

    Given I am logged in with <icon> user on weak authentication
    When I click on echeancier
    And I click on echeancier actualise
    Then I should be able to see <product> on the echeancier actualise screen

    Examples:
      | product                                                 | icon |
      | Mon paiement 3x Oney chez VAD2 EN PROTOCOLE CB2A DIRECT | 3x   |

    @ProchainsPrevelements
    Scenario Outline: Verify that after logging in with existing 3x user, the details are correct on Prochains Prelevements page

      Given I am logged in with <icon> user on weak authentication
      When I click on prochains prelevements
      Then I should be able to see <product> and the <icon> on the prochain prelevements screen

      Examples:
        | product                                                 | icon |
        | Mon paiement 3x Oney chez VAD2 EN PROTOCOLE CB2A DIRECT | 3x   |