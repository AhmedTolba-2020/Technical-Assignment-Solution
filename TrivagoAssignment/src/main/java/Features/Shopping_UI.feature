@UI
Feature: E2E Test For Registering hotel  
#As a user I want to register a hotel at Cairo so that I can enjoy at my weekend.
#-------------------------------------------------------------------------------
Scenario: Booking hotel at weekend vacation
Given User navigates to weekend trivago website
When Set "Leipzig" in destination field
And Select the period time
And Click on View Deal
Then user navigates to the right page
#------------------------------------------------------------------------------
