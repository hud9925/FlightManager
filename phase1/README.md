Please open the "MainApplication.java" file in the src folder in intelliJ, then run the program by right-clicking
on the "MainApplication.java" module and clicking run (or pressing Ctrl + Shift + F10).

This will start the program, and you can follow the prompts on the terminal afterwards.

Any Users that you create will be automatically saved in the UserDatabase.csv file after you are done with the program.
Any Users saved before will be automatically loaded anytime you start the program, so you can log-in using
their username and password. To access the Admin controls, please login with the username "Administrator" and password "admin123."

Classes are organized based on Clean Architecture.

The TestSuite is currently un-finished with two temporary tests - they will be fixed and more will be added later.

Required additional notes on the program's design:

- SOLID principles: The Single Responsibility principle was applied through separating large classes that had multiple 
responsibilities into smaller, single-reason classes (e.g. git revision number bb17362f37fce75061cf68724f4890e5b34f9615 
separating admin menu’s methods into separate classes). The Open/Closed principle was applied by having the instance 
variables in Entity classes be private (but with getters/setters), as well as having controllers for each menu that 
allow for easier addition of other options. The Liskov Substitution principle was applied by having classes be abstract, 
so that the “child” class would instead extend the parent class by implementing the abstract methods (e.g. 
User → Admin/Customer classes and Database → Flight/UserConnector classes).

- Clean Architecture: Based on the dependency rule, source code should always point inwards, i.e: from less stable to 
more stable classes/policies. At the core of our program lies the innermost (domain) layer of code, which contains 
entities such as User/Flight/Ticket (the entities are essentially the basis of our program/higher level dependencies). 
The layer directly outside of the domain layer contains the application business rules which house the Use Cases, 
such as BuyTicket or SeeAccountDetails which manipulate entities. Keeping the dependency rule in mind, the entities have 
no knowledge of or dependency on the Use Cases. The source code always points inwards, as does the level of abstraction.

- Design patterns: The main design pattern that was implemented was the iterator pattern, implemented in git revision
50680faf155afee5a69be66e9370d02fcf2e37f8. It was implemented for the UserTracker class to improve the retrieval of the
User database present in UserTracker (as it would give easier access to each individual User as opposed to the previous
design). Other design patterns such as the Facade pattern were considered for the implementation of Controller classes,
however ultimately the pattern was merged with clean architecture by having the controller and presenter both be a sort 
of "facade", which would dedicate work to Use Case classes and also respect the principles of clean architecture and 
SOLID.

- Code smells:
- Refactorings: 
- Personal Contribution:
