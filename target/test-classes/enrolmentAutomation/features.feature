Feature: Enrolling to Exlibris website

Scenario: Login with invalid credentials

Given I Opened the browser and navigate to Exlibris website
When I choose the Student/Staff option and click on the Accept button for terms
And entered wrong login credentials, click and validate the Login button and validate the error message

Scenario: Login with valid credentials
When I entered the valid credentials and click on the Login btton
Then I will reach on the Home page

Scenario: Exlibris enrolment

When I click on the Enrolement button and Your Details button and Personal Details button
And Store the date of birth value in a variable and change the Date of Birth
And  Add First Name, Last Name in the Parent's/Gurdian's section and emeil address in contact information and select Male as title
And Close the tile

Scenario: Verify enrolment details entered

When To verify I click on Enrolment->Your Details->Personal Details
And validate Date of Birth (shows updated date of birth)
And validate Parent's/Guardian's First Name and LastName
And validate Gender and Email Address

Scenario: Update enrolement details
And I update Date of Birth to the saved from variable
And updated First Name to Blank and Last Name to Blank and Genter Prefer not to say, Email to Blank and close the tile

Scenario: Logout

When I click on Angle button on the top right of the page and click on Log Out
Then I verify that user is logged out



