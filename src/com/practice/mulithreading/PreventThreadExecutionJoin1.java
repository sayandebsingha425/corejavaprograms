package com.practice.mulithreading;

public class PreventThreadExecutionJoin1 {
    public static Thread mt ;
    public static void main(String[] args) {
        Runnable r = ()-> {
            for(int i=0; i<5; i++)
            {
                try {
                    mt.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Thread 1: " + i);
                
            }
        };
        mt = Thread.currentThread();
        Thread t1 = new Thread(r);
        t1.start();

        for(int i=0; i<5; i++)
        {
            System.out.println("main Thread: " + i);
            
        }
    }

}
