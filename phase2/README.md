Please open the "MainApplication.java" file in the src folder in intelliJ, then run the program by right-clicking
on the "MainApplication.java" module and clicking run (or pressing Ctrl + Shift + F10).

This will start the program, and you can follow the prompts on the terminal afterwards.

Any Users that you create will be automatically saved in the UserDatabase.csv file after you are done with the program.
Any Users saved before will be automatically loaded anytime you start the program, so you can log-in using
their username and password. To access the Admin controls, please login with the username "Administrator" and password "admin123."
Note that most input prompts are case-sensitive (to be fixed later).

Classes are organized based on Clean Architecture.

The TestSuite currently has several tests for the Use Cases. 
Note: **These tests should be run one at a time** as there are static data maps that will preserve data between 
unit tests, which might affect the test's outcome.