package com.practice.serialization;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustSerializationDemo {
    public static void main(String[] args) throws Exception {
      FileOutputStream fos = new FileOutputStream("xyz.ser");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
        Cred c = new Cred(1,"Sayan");
        oos.writeObject(c);

        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("xyz.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Cred cd2= (Cred)ois.readObject();
        System.out.println(cd2.id + " " + cd2.password);

    }
}


class Cred implements Serializable
{
int id;
transient String password;
public Cred(int id, String password) {
    this.id = id;
    this.password = password;
}
private void writeObject(ObjectOutputStream oss)
{
    try {
        oss.defaultWriteObject();
        String ePassWord = password+1234;
        oss.writeObject(ePassWord);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
private void  readObject(ObjectInputStream ois)
{
    try{
    ois.defaultReadObject();
    String ePassWord = (String)ois.readObject();
    String password = ePassWord.substring(0, ePassWord.length()-4);
}
catch(Exception e)
{
    e.printStackTrace();
   
}

}
}