
@tag
Feature: Cancelling the bets
  I want to use this template for my feature file

 Background:
	Given I landed on BCT Application

  @tag2
  Scenario Outline: Cancel a bet
    Given Logged in with username <username> and password <password>
    When Search with the betnumber <betnumber>
    Then cancel the bet with <comment>

    Examples: 
      | username      | password     | betnumber  |comment|
      | s.c.Bct.Admin | Welcome@1234 | 1ZKS4594KK |Test|
     