package com.practice.mulithreading;

public class SynchronizationDemo {
   public static void main(String[] args) {
    Display d = new Display();
    Runnable r1 = ()-> {
        d.wish("Dhoni");
    };
    Runnable r2 = ()-> {
        d.wish("Yuvraj");
    };
    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.start();
    t2.start();
   }

}
class Display
{
    public synchronized void  wish(String name)
    {
      for(int i=0;i<5;i++)
      {
        System.out.println("Good Morning: "+ name);
      }
    }
}
