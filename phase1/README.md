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
responsibilities into smaller, single-reason classes (e.g. git revision number bb17362f separating admin menu’s methods 
into separate classes). The Open/Closed principle was applied by having the instance 
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
50680faf. It was implemented for the UserTracker class to improve the retrieval of the
User database present in UserTracker (as it would give easier access to each individual User as opposed to the previous
design). Other design patterns such as the Facade pattern were considered for the implementation of Controller classes,
however ultimately the pattern was merged with clean architecture by having the controller and presenter both be a sort 
of "facade", which would dedicate work to Use Case classes and also respect the principles of clean architecture and 
SOLID.

- Code smells: There were quite a few dispensables to deal with, such as unused imports and redundant comments that were 
shortened. An example is git revision 3b448c4f where an unused variable was removed from the User class. There is also 
duplicated code in the Menus for prompting user inputs, these lines of code is refactored out to a separate Console 
class in c171670c. Duplicated toString method in child classes of User is also merged in 5034cc92. And abstract 
DatabaseConnector class was created in c5ecb742 to reduce code duplication in the gateway classes.

- Refactorings: The biggest refactoring that was done during the project was for the gateway that our program would use 
to write/read from a csv file. This refactoring was done by merging different save and load classes into one bigger 
abstract “DatabaseConnector” class (git revision 8a7346e) which allowed for better extension of the concepts of saving 
and loading for different trackers: FlightTracker and UserTracker connector classes → allowing for saving/loading 
different types of data to different types of files. Another major refactoring was the addition of controller classes 
and separating the presenter menus from their controllers which would assign the work to the use case classes 
(git revision cce73612) to accommodate clean architecture.

- Personal Contribution:
