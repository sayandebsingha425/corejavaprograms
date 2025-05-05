package com.practice.mulithreading;

public class DeadLock2  extends Thread{
A a = new A();
B b = new B();

DeadLock2()
    {
        this.start();
        a.aMethod(b);
    }
    public void run()
    {
        b.bMethod(a);
    }
public static void main(String[] args) {
    
    
DeadLock2 d1 = new DeadLock2();

}
}

class A
{
public synchronized void aMethod(B b)
{
    System.out.println("Method A");
    System.out.println("calling disp method of B");
b.disp();
}
public synchronized void disp()
{
System.out.println("Disp Method A");
}
}
class B{
    public synchronized void bMethod(A a)
{
    System.out.println("Method B");
    System.out.println("calling disp method of A");
a.disp();
}
public synchronized void disp()
{
   System.out.println("Disp Method B"); 
}

}
