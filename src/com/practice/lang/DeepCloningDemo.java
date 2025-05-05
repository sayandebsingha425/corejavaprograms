package com.practice.lang;

public class DeepCloningDemo {
public static void main(String[] args) throws CloneNotSupportedException {
   
    Dog1 d = new Dog1(10);
        Cat1 c = new Cat1(100, d);
        System.out.println("Original object: " + c.i + " " + c.d.j);
        Cat1 clonec= (Cat1)c.clone();
        System.out.println("Cloned object: " + clonec.i + " " + clonec.d.j);
         clonec.d.j=20;
         System.out.println("After changing the value of dog in cloned object: " + clonec.i + " " + clonec.d.j);
         System.out.println("Original object after changing the value of dog in cloned object: " + c.i + " " + c.d.j);
   
}
}

class Cat1 implements Cloneable

{
    int i;
    Dog1 d;
    public Cat1(int i, Dog1 d) {
        this.i = i;
        this.d = d;
    }
    public Cat1 clone() throws CloneNotSupportedException
    {
        Dog1 d = new Dog1(this.d.j);
        Cat1 c = new Cat1(this.i, d);
        return c;
    }
   
}

class Dog1 {
    int j;

    public Dog1(int j) {
        this.j = j;
    }
}
