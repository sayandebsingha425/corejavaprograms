package com.practice.lang;

public class ShallowCloningDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Dog d = new Dog(10);
        Cat c = new Cat(100, d);
        System.out.println("Original object: " + c.i + " " + c.d.j);
        Cat clonec= (Cat)c.clone();
        System.out.println("Cloned object: " + clonec.i + " " + clonec.d.j);
         clonec.d.j=20;
         System.out.println("After changing the value of dog in cloned object: " + clonec.i + " " + clonec.d.j);
         System.out.println("Original object after changing the value of dog in cloned object: " + c.i + " " + c.d.j);
    }
}

class Cat implements Cloneable

{
    int i;
    Dog d;
    public Cat(int i, Dog d) {
        this.i = i;
        this.d = d;
    }
    public Cat clone() throws CloneNotSupportedException
    {
        return (Cat)super.clone();
    }
   
}