package exam2.exam2_2235;

import java.io.*;

public class Serialization_2235 implements Serializable {
    transient Integer value = 0;

    Serialization_2235 read() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.save"));) {
            Serialization_2235 o = (Serialization_2235) in.readObject();
            System.out.println(o.value);
            setValue(this, 1);
            System.out.println(o.value);
        } catch (Exception e) { }
        return this;
    }

    Serialization_2235 write() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.save"));) {
            Serialization_2235 o = new Serialization_2235();
            out.writeObject(o);
        } catch (Exception e) { }
        return this;
    }

    public static void setValue(Serialization_2235 o, Integer v) {
        o.value = v;
    }

    public static void main (String args[] ){
        new Serialization_2235().write().read();
    }
}

// 1. What is the output of this program?

//null
//null (notice the deserialized object is not passed as argument.

// 2. What does the "transient" used keyword implies?

// Field will not be serialized.
// Field default value is set when deserialized object is created.
