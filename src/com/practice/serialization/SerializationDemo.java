package com.practice.serialization;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        //Serialazation of Person object
        // The object is converted into a byte stream and saved in a file   
        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Person p = new Person(1,"Sayan");
        oos.writeObject(p);

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person deSPerson = (Person)ois.readObject();
        System.err.println(deSPerson.a + " " + deSPerson.s);

        
    }


}

class Person implements Serializable
{
    int a;
    String s;
    public Person(int a, String s) {
        this.a = a;
        this.s = s;
    } 

}
