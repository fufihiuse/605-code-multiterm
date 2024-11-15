package exam2_2241;

import java.io.*;

public class Serialization_2241 implements Serializable {
    transient Integer value = 0;

    Serialization_2241 read() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.save"));) {
            Serialization_2241 o = (Serialization_2241) in.readObject();
            System.out.println(o.value);
            setValue(o, 1);
            System.out.println(o.value);
        } catch (Exception e) { }
        return this;
    }

    Serialization_2241 write() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.save"));) {
            Serialization_2241 o = new Serialization_2241();
            out.writeObject(o);
        } catch (Exception e) { }
        return this;
    }

    public static void setValue(Serialization_2241 o, Integer v) {
        o.value = v;
    }

    public static void main (String args[] ){
        new Serialization_2241().write().read();
    }
}

// 1. What is the output of this program?

//null
//1

// 2. What does the "transient" used keyword implies?

// Field will not be serialized.
// Field default value is set when deserialized object is created.
