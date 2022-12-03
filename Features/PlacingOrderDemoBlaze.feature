
Feature: Adding items to cart and making payment in DemoBlaze
 
Background: 

		Given Lauching chrome browser
    When User opens url "https://www.demoblaze.com/" and clicking on signinlink
    And User enter valid user name "santha12345678" and password "1234"
    
Scenario Outline: Adding items to cart   

	##	Then In home page the username should be "Welcome santha12345678"
 	  Then click on laptop option, select "<item>" amd click on add to cart
    And click on ok button
    And close browser    
  
		Examples: 
			|item|
			|Nokia lumia 1520|
			|Samsung galaxy s6|
			|Nexus 6|
			|Sony xperia z5|
			|HTC One M9|

Scenario: Making Payment

 Then go to cart
 When clicking on place order 
  And Giving valid credentials and credit card details
  Then click on purchase option
    
  ##  Scenario: Placing order for laptop    
 	  ##Then In home page the username should be "Welcome santha12345678"
    ##And click on laptop option and click next, selecting MacBook air and click on Add to cart
    ##And click on ok button
    ##Then In home page the username should be "Welcome santha12345678"


