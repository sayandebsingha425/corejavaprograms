package com.practice.lang;

public class EqualsMethodImpl {

    public static void main(String[] args) {
        Test t1 = new Test("Sayan");
        Test t2 = new Test("Sayan");
        System.out.println(t1.equals(t2));
        System.out.println(t1.equals(null));
        System.out.println(t1.equals(new Integer(0)));

       }
}

class Test{
String name;

public Test(String name) {
    this.name = name;
}
public boolean equals(Object object)
{
   
    try{
        Test t1 = (Test)object;
        Test t2 = this;
        if(t1.name.equals(t2.name))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    catch(Exception e)
    {
        return false;
    }
}
}
