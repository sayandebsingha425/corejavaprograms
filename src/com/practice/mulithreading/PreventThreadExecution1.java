package com.practice.mulithreading;

public class PreventThreadExecution1  {



    public static void main(String[] args) {
       Runnable r = ()-> {
           for(int i=0; i<5; i++)
           {
               System.out.println("Thread 1: " + i);
              
           }
       };

       Thread t1 = new Thread(r);
       t1.start();
       
       for(int i=0; i<5; i++)
       {

           System.out.println("main Thread: " + i);
           Thread.yield();
          
       }
    }

}
