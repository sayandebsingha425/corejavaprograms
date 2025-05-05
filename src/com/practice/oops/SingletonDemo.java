package com.practice.oops;

public class SingletonDemo {


    private SingletonDemo()
    {

    }
    private static SingletonDemo instance = null;
    public static SingletonDemo getSingletonDemo()
    {
        if(instance== null)
        {  
            instance= new SingletonDemo();
            return instance;
        }
        else
        {
            return instance;
        }
    }
    public static void main(String[] args) {
        
        SingletonDemo demo1 =  SingletonDemo.getSingletonDemo();
        SingletonDemo demo2 =  SingletonDemo.getSingletonDemo();
      System.out.println(demo1.hashCode());
      System.out.println(demo2.hashCode());
    }
}
