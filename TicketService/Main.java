package TicketService;

import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;
import java.io.*;

public class Main {
	private
	static Timer timer;

	public 
	static void cancelTimer(){
		timer.cancel();
	}
	static void restartTimer(){
		timer = new Timer();
	}

	public static void main(String [] args) {
		int numSeats = 0;
		String customerName;
		boolean endProgram = false;
		Scanner reader = new Scanner(System.in);
		Venue event;
		int availableSeats[];
		TimerTask timerTask = new MyTimerTask();
		timer = new Timer(true);

		// default number of seats
		if(args.length == 0){
			event = new Venue();
		}
		
		// user defined number of seats
		else if(args.length == 1){
			numSeats =  Integer.parseInt(args[0]);
			
			 // valid number of seats
			if (numSeats > 0){
				event = new Venue(numSeats);
			}
			
			// negative value passed in 
			else {
				System.out.println("Invalid number of seats");
				reader.close();
				return;
			}
		}
		 // invalid number of command line arguments
		else {
			System.out.println("Invalid arguments!");
			reader.close();
			return;
		}

		System.out.println("Welcome ");
		
		// get user options
		while(endProgram == false){
			System.out.println("Option1: Enter '1' for available seats");
			System.out.println("Option2: Enter '2' to hold seats for 90 seconds");
			System.out.println("Option3: Enter '3' to reserve a group of seats");
			System.out.println("Any other key to exist");

			System.out.println("Enter option: ");
			int input = reader.nextInt();
			
			// check options
			switch (input){
			case 1: 
				System.out.println("Avialable Seats: " + event.getAvailabeSeats());
				break;
			case 2: 
				System.out.println("Enter name: ");
				customerName = reader.next();				
				System.out.println("Enter number of seats to hold: ");
				input = reader.nextInt();
				availableSeats = event.checkAvailability(input);
				if(availableSeats != null){
					event.holdSeats(customerName, availableSeats);
					System.out.println("Hold Seat for 30 seconds");
					timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
				}
				else {
					System.out.println("*** Cannot complete order only " + event.getAvailabeSeats() + " seats available. \n ***");
				}
				break;				
			case 3:	
				System.out.println("Enter name: ");
				customerName = reader.next();
				System.out.println("Enter number of seats to reserve");
				input = reader.nextInt();
				availableSeats = event.checkAvailability(input);
				if(availableSeats != null){
					event.reserveSeats(customerName, availableSeats);
				}
				else {
					System.out.println("*** Cannot complete order only " + event.getAvailabeSeats() + " seats available. \n ***");
				}
				break;
			default: 
				System.out.println("Thanks, Have a good day");
				endProgram = true;	
				break;
			}
		}
		reader.close();
		return;
	} // main
}
