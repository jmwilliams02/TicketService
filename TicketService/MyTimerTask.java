package TicketService;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
    public void run(){
        completeTask();
    }

    private void completeTask(){
        try {
            Thread.sleep(10*3000);
            System.out.println("Release seats");  
            Main.cancelTimer(); 
            Main.restartTimer();         
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

