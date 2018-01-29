package TicketService;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
    public void run(){
        completeTask();
    }

    private void completeTask(){
        try {
            Thread.sleep(10*3000);
            Main.cancelTimer(); 
            Main.timerExpired();         
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

