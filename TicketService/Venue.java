package TicketService;

import java.io.*;

public class Venue {
	private
		int numOfSeats;
		int availableSeats = 0;
		Seat[] totalSeats;
		int [] heldSeatIndexes;
		
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
		void holdSeats(String name, int [] seatList){
			for(int seatIndex = 1; seatIndex <= seatList[0]; seatIndex ++){
				totalSeats[seatList[seatIndex]].setHold(name);
				if(availableSeats > 0){
					availableSeats --;
				}
			}

			// copy array for later usage
			heldSeatIndexes = seatList.clone();
		}

		void releaseHold(){
			for(int index = 1; index <= heldSeatIndexes[0]; index ++){
				totalSeats[heldSeatIndexes[index]].free();
				if(availableSeats <= numOfSeats){
					availableSeats ++;
				}
			}
		}

		
		// check seat availability
		int [] checkAvailability(int amount){
			int [] openSeats = null;
			
			if(amount < availableSeats) {
				openSeats = new int[amount + 1];
				
				for(int index = 0, osIndex = 1; index < numOfSeats && osIndex <= amount; index++){
					if(totalSeats[index].isAvailable(index)){
						openSeats[osIndex] = index;
						osIndex ++;
						openSeats[0] ++;
					}
				}
			}
			
			return openSeats;
		}
		
		// reserve customer's seat
		void reserveSeats(String name, int [] seatList){
			for(int seatIndex = 1; seatIndex <= seatList[0]; seatIndex ++){
					totalSeats[seatList[seatIndex]].setReserved(name);
					if(availableSeats > 0){
						availableSeats --;
					}
			}
		}
}
