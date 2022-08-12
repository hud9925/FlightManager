Please open the "MainApplication.java" file in the src folder in intelliJ, then run the program by right-clicking
on the "MainApplication.java" module and clicking run (or pressing Ctrl + Shift + F10).

This will start the program, and you can follow the prompts on the terminal afterwards.

Any data that you add will be automatically saved in the UserDatabase.csv file after you are done with the program,
as long as you exit from the main menu. If you terminate your run, it does not save the data (flight/user/...)

Any Users saved before will be automatically loaded anytime you start the program, so you can log-in using
their username and password. To access the Admin controls, please login with the username "Administrator" and password "admin123."
Please do not delete this account, as only admins are capable of add new admins (can't register as an admin by yourself).

Note on Payment Methods: Card numbers have to be 16 digits long, and pins have to be 3 digits.
While the program will save/load your payment method, it currently will not do anything with it. Loyalty points are also 
saved/loaded, however currently there is no option for exclusive flights. These will be features that will have more 
functionality given a larger scope of the project (time). 

Note that most input prompts are case-sensitive.
Currently the GUI only has the login/register pages, for admin and customers.

Classes are organized based on Clean Architecture.
