package com.practice.mulithreading;

public class PreventThreadExecutionJoin2 {
public static void main(String[] args) throws InterruptedException {
    Runnable r =()-> {
        for(int i=0;i<5;i++)
        {
            System.out.println(Thread.currentThread().getName() + " Thread 1: " + i);
        }
    };
    Thread t1= new Thread(r);
    t1.start();
    t1.join();
    for(int i=0;i<5;i++)
    {
        System.out.println(Thread.currentThread().getName() + " main Thread: " + i);
    }
}
}
