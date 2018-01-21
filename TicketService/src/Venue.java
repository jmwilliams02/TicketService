package TicketService;

import java.io.*;

public class Venue {
	private
		int numOfSeats;
		int availableSeats = 0;
		Seat[] totalSeats;
		
	public
		Venue(){
			this(100);
		}
	
		Venue(int seats){
			numOfSeats = seats;
			totalSeats= new Seat[seats];
			
			for(int idx = 0; idx < seats; idx ++){
				totalSeats[idx] = new Seat();
				availableSeats++;
			}
		}

		// get available seats
		int getAvailabeSeats(){
			return availableSeats;
			
		}
	
		// hold seats for customer for 90 seconds
		boolean holdSeats(String name, int numberOfSeats){
			if(numberOfSeats > 0 && numberOfSeats <= availableSeats){
				int reserved = 0;
				
				while(reserved <= numberOfSeats){
					for(int index = 0; index < availableSeats; index++){
						if(totalSeats[index].isAvailable(index + 1)){
							totalSeats[index].setReserved(name);
						}
							
					}
				}
			}
			return true;
		}
		
		// check seat availability
		int [] checkAvailability(int amount){
			int [] openSeats = null;
			
			if(amount < numOfSeats) {
				openSeats = new int[amount + 1];
				
				for(int index = 0, osIndex = 1; index < numOfSeats && osIndex <= amount; index++, osIndex ++){
					if(totalSeats[index].isAvailable(index)){
						openSeats[osIndex] = index;
						openSeats[0] ++;
					}
				}
			}
			
			return openSeats;
		}
		
		// reserve customer's seat
		void reserveSeats(String name, int [] seatList){
			for(int index = 1; index <= seatList[0]; index ++){
					totalSeats[seatList[index]].setReserved(name);
					if(availableSeats > 0){
						availableSeats --;
					}
			}
		}
		
		void incrementAvailabeSeats(){
			
		}
		
		void decrementAvailabeSeats(){
			
		}
}
