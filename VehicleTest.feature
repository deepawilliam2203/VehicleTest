Feature: Check vehicle exists or not
Scenario: When a registration number is given, and find vehicle button is clicked, the cover start and cover end date of the vehicle should be displayed
Given user navigates to the insurance URL
When the user enters the registration number 
Then the registration number should be displayed
