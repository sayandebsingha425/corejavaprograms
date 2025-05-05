package com.practice.mulithreading;

public class SleepAndInterruptDemo {

public static void main(String[] args) {
    
    Runnable r = ()-> {
        System.out.println("Child Thread Started..");
        System.out.println("Child Thread is working");
        try {
            for(int i =0; i<100;i++)
            {
                System.out.print(".");
                
            }
            System.out.println("Child Thread is going to sleep");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Child Thread Interrupted..");
        }
    };
    Thread t1 = new Thread(r);
    t1.start();
    System.out.println("Main Thread is interrupting Child Thread..");
    t1.interrupt();
    System.out.println("Main Thread's work is Ended..");
}
   

}

