package exam2_2241;

public class Threads_2241 extends Thread {
    static Object lock = new Object();
    int id;

    public Threads_2241(Object lock, int id) { this.lock = lock; this.id = id; }

    public void run () {
        synchronized (lock) {
            try{ if (id == 1) sleep(100); } catch (InterruptedException e) {}
            System.out.println(id);
            System.out.println(id);
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        (new Threads_2241(new Object(), 1)).start();
        (new Threads_2241(new Object(), 2)).start();
    }
}

// Answer the questions.

// 1. Will the threads ever be synchronized using the same object? Explain.

//Yes, it is possible. t1 runs after t2 constructor finishes.

// 2. How many different unique outputs this program can generate?

//All variations are possible