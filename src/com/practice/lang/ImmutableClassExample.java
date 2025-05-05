package com.practice.lang;

public class ImmutableClassExample {

    public static void main(String[] args) {
        
        Test1 t1 = new Test1(10);
        Test1 t2 = t1.modify(10);
        Test1 t3 = t1.modify(1000);
        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());
        System.out.println(t3.hashCode());
    }
}

class Test1
{
    int x;

    public Test1(int x) {
        this.x = x;
    }
    public Test1 modify(int x)
    {
        if(this.x == x)
        {
            return this;
        }
        else{
            return new Test1(x);
        }
    }
    
}
