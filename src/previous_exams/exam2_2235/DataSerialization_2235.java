package exam2.exam2_2235;

import java.io.*;

public class DataSerialization_2235 {

    public static void main(String args[]) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("input2.txt"));
             DataInputStream in = new DataInputStream(new FileInputStream("input2.txt"));) {
            out.writeInt(42);
            out.writeDouble(0.01);
            out.writeBoolean(false);
            System.out.println(in.readInt());
            System.out.println(in.readBoolean());
            System.out.println(in.readDouble());
//            System.out.println(in.readDouble());

        } catch (IOException ef) {
            System.out.println("bam");
        }
    }
}

// 1. This is the output of this program:
//        42
//        true
//        -4.413197968756032E-287
// Explain why the original values written did not show up in the terminal (stdout)

// 2. If the commented line is uncommented, what will be the output of the program?
//        42
//        true
//        -4.413197968756032E-287
//        bam
