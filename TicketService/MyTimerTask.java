package TicketService;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
    public void run(){
        System.out.println("Timer started");
        completeTask();
        System.out.println("Timer finished");
    }

    private void completeTask(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

