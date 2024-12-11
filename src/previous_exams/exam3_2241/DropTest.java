package exam3_2241;

import java.lang.Thread;
import java.util.*;

class Drop {
    private List<String> messages = new ArrayList<>();
    final static private Integer MAX = 3;

    synchronized public String take() {
            while (messages.size() == 0) { try { wait(); } catch (InterruptedException e) { } }
            notifyAll();
            return messages.remove(messages.size() - 1);
    }

    synchronized public void put(String message) {
            while (messages.size() == MAX) { try { wait(); } catch (InterruptedException e) {} }
            messages.add(message);
            notifyAll();
    }
}

public class DropTest {
    public static String p(String s) { System.err.println(s); return s;}

    public static void main(String[] args) {
        Drop drop = new Drop();
        Set<Runnable> runnables = new HashSet<>();
        Random seed = new Random();

        for (int i=0; i<3; i++) {
            Runnable consumer = () -> { while(true) drop.take(); };
            runnables.add(consumer);
            Runnable producer = () -> { while(true) drop.put(String.valueOf(seed.nextInt(2))); };
            runnables.add(producer);
        };

        for (Runnable r:runnables) (new Thread(r)).start();

    }
}

//This program compiles as is.


// 1. Is this program subject to a racing condition? Explain.

// no

//2. What happens if you change the messages field to static?

// nothing.
