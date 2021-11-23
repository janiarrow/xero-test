# xero-test application

This test suite contains a user story that has test scenarios on adding an ANZ NZ account to the xero account.

This app was implemented using via eclipse with java, selenium, junit and cucumber frameworks. 

Steps to run the test suite
1. Download and install java 8.
2. Setup jdk bin path as an environment system variable.
3. Download maven and setup maven bin path as an environment system variable.
4. Open cmd and run "mvn tests" to execute test methods.
5. To view report - go to target - htmlreport - index.html

If the chrome driver doesn't support the version in your machine, then:
* Download chrome driver that's compatible to your chrome browser
* Place it in /src/test/resources/drivers directory.
* Update config.properties file with the driver name.