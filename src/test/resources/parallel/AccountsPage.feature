Feature: Accounts page Feature

Background:
Given user has already logged in application
|username|password|
|vinod@gmail.com|Kkuma125@|

@accounts
Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

@accounts
Scenario: Accounts Section Count
Given user is on Accounts page
Then user gets accounts section
|ADD MY FIRST ADDRESS|
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|Home|
And accounts section count should be 6