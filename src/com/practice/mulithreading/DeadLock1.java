package com.practice.mulithreading;

public class DeadLock1 {

    public static Thread mt ;
    public static void main(String[] args) {
        Runnable r = ()-> {
            for(int i=0; i<5; i++)
            {
                try {
                    System.out.println("Child Thread is waiting for Main Thread to finish...");
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
        System.out.println("Main Thread waiting for Child Thread...");
         try {
             t1.join();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
        for(int i=0; i<5; i++)
        {
            System.out.println("main Thread: " + i);
            
        }
    }
}
