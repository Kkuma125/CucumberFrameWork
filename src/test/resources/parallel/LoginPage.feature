Feature: Login Page Feature

Scenario: Login Page Title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot Password Link Exist
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with Correct Credentials
Given user is on login page
When user enters  username "vinod@gmail.com"
And user enters password "Kkuma125@"
And user clicks on login button
Then user gets the title of the page
And page title should be "My account - My Store"



