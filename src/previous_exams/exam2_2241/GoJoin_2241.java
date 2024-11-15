package exam2_2241;

import java.util.ArrayList;
import java.util.List;

public class GoJoin_2241 extends Thread {
        static int accumulator;

        public static synchronized void inc() { accumulator++; }

        public void run () { for (int i=0; i<1000; i++) inc(); }

        public static void main (String[] args) {
            List<GoJoin_2241> list = new ArrayList<>();
            for (int i=0; i<1000; i++) {
                GoJoin_2241 var = new GoJoin_2241();
                var.start();
                list.add(var);
            }
            try { for (GoJoin_2241 t:list) t.join(); } catch (Exception e) {} //1
            System.out.println(GoJoin_2241.accumulator);
        }
    }

// Answer the questions.

//1 - Is this program subject to racing conditions? Explain.

// No, static synchronized method is used

//2 - Will the line marked with "//1" result in an overall sequential execution?

// No, only main thread will be joining threads.
