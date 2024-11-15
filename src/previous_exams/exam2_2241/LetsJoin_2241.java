package exam2_2241;

import java.util.ArrayList;
import java.util.List;

public class LetsJoin_2241 extends Thread {
        static int accumulator;

        public synchronized void inc() { accumulator++; }

        public void run () { for (int i=0; i<1000; i++) inc(); }

        public static void main (String[] args) {
            List<LetsJoin_2241> list = new ArrayList<>();
            for (int i=0; i<1000; i++) {
                LetsJoin_2241 var = new LetsJoin_2241();
                var.start();
                list.add(var);
            }
            try { for (LetsJoin_2241 t:list) t.join(); } catch (Exception e) {}
            System.out.println(LetsJoin_2241.accumulator);
        }
    }

// Answer the questions.

//1 - Is this program subject to racing conditions? Explain.

// Yes, instance synchronized method is used

//2 - Explain what would happen if the field accumulator would be private

// Nothing.
