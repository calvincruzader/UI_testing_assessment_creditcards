# Test Plan and Execution of https://www.creditcards.com/

Hello! 

This is a fledgeling, multi-browser test suite for the URL https://www.creditcards.com/

The test plan for the test cases is in a .pdf in the /test_plan/ directory.

The automated test scripts in this repo can be run as follows: 
- git pull/git clone to local
- mvn clean install
	- this serves to get all the dependencies needed for the project, but if dependency issues persist, contact me at calvincruzader@gmail.com!
	- this should also automatically start up the test cases to be run. Alternatively, one can run from testng.xml file itself 

The tests themselves can be found at ./src/test/java/tests/CreditCardLandingPageTest.java


Enjoy! 
- Calvin 

