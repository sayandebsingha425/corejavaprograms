package com.practice.mulithreading;

public class SynchronizeDemo2 {
public static void main(String[] args) {
    Disp d = new Disp();
    MyThread t1 = new MyThread(d,"Dhoni");
    MyThread t2 = new MyThread(d, "Yuvraj");
    t1.start();;
    t2.start();

}
}

class MyThread extends Thread
{
Disp d;
String name;
MyThread(Disp d, String name)
{
this.d = d;
this.name = name;
}
public void run()
{
    d.disp(name);
}
}
class Disp{
    public  synchronized void disp(String name)
    {
      for(int i =0; i<5;i++)
      {
        System.out.println("Good Morning: "+name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      }
    }
}
