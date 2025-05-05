package com.practice.mulithreading;

public class InterThreadCommunication extends Thread{
    int total;


    public void run()
    {
     synchronized(this)
     {
          for(int i=0;i<5;i++)
          {
            total =total+10;
          }
          this.notify();
     }
    }
    public static void main(String[] args) throws InterruptedException {
        InterThreadCommunication it = new InterThreadCommunication();
        it.start();
        synchronized(it)
        {
            it.wait();
            System.out.println("total is: "+it.total);
        }
    }
}
