
Feature: Login page
  
Scenario: Perform login user valid credentials
   
 Given Lauching chrome browser
 When User opens url "https://www.demoblaze.com/" and clicking on signinlink
 And User enter valid user name "santha12345678" and password "1234"
 Then In home page the username should be "Welcome santha12345678"
 And click logout button