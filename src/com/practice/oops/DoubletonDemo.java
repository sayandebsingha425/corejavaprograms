package com.practice.oops;

public class DoubletonDemo {

    private static DoubletonDemo d1 = null;
    private static DoubletonDemo d2= null;
    private DoubletonDemo()
    {
        
    }
    public static DoubletonDemo getDoubletonDemo()
    {
        if(d1 == null)
        {
            d1 = new DoubletonDemo();
            return d1;
        }
        else if(d2== null)
        {
            d2 = new DoubletonDemo();
            return d2;
        }
        else
        {
            if(Math.random() > 0.5)
            {
                return d1;
            }
            else
            {
                return d2;
            }
        }
    }
    public static void main(String[] args) {
        

        DoubletonDemo d1 = DoubletonDemo.getDoubletonDemo();
        DoubletonDemo d2 = DoubletonDemo.getDoubletonDemo();  
        DoubletonDemo d3 = DoubletonDemo.getDoubletonDemo();
        DoubletonDemo d4 = DoubletonDemo.getDoubletonDemo();  
        System.out.println(d1.hashCode()); 
        System.out.println(d2.hashCode()); 
        System.out.println(d3.hashCode()); 
        System.out.println(d4.hashCode()); 

    }
}
