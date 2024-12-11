package exam3_2241;

import java.util.*;

class DropOnline {
    static private List<String> messages = new ArrayList<>();
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

public class DropTestOnline {
    public static String p(String s) { System.err.println(s); return s;}

    public static void main(String[] args) {
        DropOnline drop = new DropOnline();
        Set<Runnable> runnables = new HashSet<>();
        Set<Thread> threads = new HashSet<>();
        Random seed = new Random();

        for (int i=0; i<3; i++) {
            Runnable consumer = () -> { while(true) drop.take(); };
            runnables.add(consumer);
            Runnable producer = () -> { while(true) drop.put(String.valueOf(seed.nextInt(2))); };
            runnables.add(producer);
        };

        for (Runnable r:runnables) threads.add(new Thread(r));
        for (Thread t:threads) t.start();
        for (Thread t:threads) try { t.join(); } catch (Exception e) {};
    }
}

//This program compiles as is.

// 1. Is this program subject to a racing condition on the static field 'messages'? Explain.

// no

// 2. When will the main thread finish?

// never
