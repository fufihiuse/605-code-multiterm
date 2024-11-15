package exam2_2241;

import java.io.*;

class Dummy {}

public class DataSerialization_2241 implements Serializable {
    Integer value = 0;
    transient Dummy dummy = new Dummy();

    DataSerialization_2241 read() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.save"));) {
            DataSerialization_2241 o = (DataSerialization_2241) in.readObject();
            System.out.println(o.value);
            setValue(this, 1);
            System.out.println(o.value);
        } catch (Exception e) { }
        return this;
    }

    DataSerialization_2241 write() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.save"));) {
            DataSerialization_2241 o = new DataSerialization_2241();
            out.writeObject(o);
        } catch (Exception e) { }
        return this;
    }

    public static void setValue(DataSerialization_2241 o, Integer v) {
        o.value = v;
    }

    public static void main (String args[] ){
        new DataSerialization_2241().write().read();
    }
}

// 1. What is the output of this program?

//0
//0

// 2. If the field "dummy" is no longer transient, what will happen?

//Serialization fails