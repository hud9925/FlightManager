Please open the "MainApplication.java" file in the src folder in intelliJ, then run the program by right-clicking
on the "MainApplication.java" module and clicking run (or pressing Ctrl + Shift + F10).

This will start the program, and you can follow the prompts on the terminal afterwards.

Any Users that you create will be automatically saved in the UserDatabase.csv file after you are done with the program.
Any Users saved before will be automatically loaded anytime you start the program, so you can log-in using
their username and password. To access the Admin controls, please login with the username "Administrator" and password "admin123."

Classes are organized based on Clean Architecture.

The TestSuite currently has several tests for the Use Cases. 
Note: These tests should be run one at a time, as there are static data maps that will preserve data between 
unit tests, which might affect the test's outcome.

Link to UML design file: [https://drive.google.com/file/d/1T2Uzcr9I8aQR9C_mC4lYmTdG9XlfxkJp/view?usp=sharing](https://drive.google.com/file/d/1T2Uzcr9I8aQR9C_mC4lYmTdG9XlfxkJp/view?usp=sharing)

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

Personal Contribution:

Mani: UML diagram, Implementation of Flight/Seat/Seatmap, UserMenu/AdminMenu (and their controllers). Implementation of gateway class (DatabaseConnector) and its subclasses. Written respective javadocs for each, some minor test cases.

Daniel: FlightTracker, GetFlightList, AddFlight, CancelFlight, FlightMenu, FightMenuController, PurchaseMenu, PurchaseMenuController(still in progress), SeatViewer,

Billy: Ticket (multiple git commits), SeatMap (minor fixes), ShowFlight (git c41b3f7), AdminFlight (git 8076ddf9), AdminFlightC (controller, git 8076ddf9), CancelMenu(git 8076ddf9), CancelMenuC (controller, git 8076ddf9), GetTicketList (git 8076ddf9), FlightNotFoundException (git 62e117b7). Wrote some Javadoc for some presenter/controller classes (not yet finished) (git 7b83906c). LoginMenu presenter bug fixes (git a49b14d2).

Taymoor: BuyTicket, CancelTicket, SeeAccountDetails and modifications to other UseCases. Additions to UserTracker and FlightTracker. JavaDoc modifications/additions for all Use Cases, Controllers, Presenters and remaining classes.

Karl: User and its subclasses (Additional methods for newly implemented features, bug fixes, some refactoring, and Javadoc), UserTracker (iterator design pattern implementation and Javadoc), Console, some menu classes (Refactor to use Console class to prompt for user input), Gateways (Some bug fixes, implement more robust database initialization process 53faff28, Refactor duplicated code to DatabaseConnector).
