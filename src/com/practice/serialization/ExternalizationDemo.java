package com.practice.serialization;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizationDemo {
    public static void main(String[] args) {

        try{
     FileOutputStream fos = new FileOutputStream("de.ser");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      Credential c = new Credential(1,"Sayan",29);
        oos.writeObject(c);

        oos.close();
        fos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //De-serialization of Person object 
        System.out.println("De-serialization of Person object starts here");
        //While deserialization it will call no Arg constructor first and then readExternal method
               try{
        FileInputStream fis = new FileInputStream("de.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Credential cd2= (Credential)ois.readObject();
        System.out.println(cd2.id + " " + cd2.password+" "+cd2.age);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
class Credential implements Externalizable
{
    int id;
    String password;
    int age;
    public Credential(int id, String password, int age) {
        this.id = id;
        this.password = password;
        this.age = age;
    }

    
    
    public Credential() {
        System.out.println("No-Arg Constructor Called");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(password);
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
         id = in.readInt();
         password =  (String)in.readObject();
    }
    

}
