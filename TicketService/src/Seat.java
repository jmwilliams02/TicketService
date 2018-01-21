package TicketService;

import java.util.Timer;

public class Seat {
	private
		static int seatIdx = 0;
		int seatNo;
		boolean available;
		String customer;
		Timer timer = new Timer();

	public
		Seat(){
			seatIdx ++;
			seatNo = seatIdx;
			available = true;
			customer = "TBD";
		}
		
	
		int getSeatNo(){
			return seatNo;
		}

		boolean isAvailable(int seatNo){
			return available;
		}

		boolean setReserved(String name){
			if(available == true){
				customer = name;
				available = false;
				return true;
			}
			else{
				return false;
			}
		}
		
		boolean setHold(String name){
			if(available == true){
				customer = name;
				available = false;
				return true;
			}
			else{
				return false;
			}
		}
		
		void free(){
			customer = "TBD";
			available = true;
		}
};
