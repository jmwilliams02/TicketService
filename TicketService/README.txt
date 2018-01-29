Ticket Service

A simple ticket service application that discovers, holds and reserves seat based off the end-user request.

Getting Started

A copy of the application copy can be obtained from GITHUB https://github.com/jmwilliams02/TicketService/tree/dev.

Prerequisites
To run the application you will need to install JDK 1.8 or greater.


Starting Application
There are two ways to run this application.  First is to run the Main.class from the command line without passing in an argument in
which case a default value of 100 seat venue will be created.  Second, the user can pass a command line argument when the Main.class
is run to determine how many seats to create for the venue. 

After the application is started the seats are order in a sequential order ranking from the best available.

 ------|| Stage || ------
 ------------------------
12 10 8 6 4 2 1 3 5 7 9 11
13
25
37

The user will be able to perform 3 transactions:
1.  Get the number of available seats.
2.  Find and hold the best seat available.
3.  Reserve a specific group of seats by the customer.

Assumptions:
1.  No external database to hold customer request.
2.  A seat hold time of 90 seconds
3.  Only one hold permitted.
3.  When the hold time expires the seat will be re-open for purchase
4.  After seats have been reserved the cannot be freed
3.  Only one user can use the application, additional user will require a restart.
