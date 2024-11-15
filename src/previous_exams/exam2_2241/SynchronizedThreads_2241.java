package exam2_2241;

public class SynchronizedThreads_2241 extends Thread {
    static Object lock = new Object();
    int id;

    public SynchronizedThreads_2241(Object lock, int id) { this.lock = lock; this.id = id; }

    public void run () {
        synchronized (lock) {
            try{ if (id == 1) sleep(100); } catch (InterruptedException e) {}
            System.out.println(id);
            System.out.println(id);
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        (new SynchronizedThreads_2241(new Object(), 1)).start();
        (new SynchronizedThreads_2241(lock, 2)).start();
    }
}

// Answer the questions.

// 1. Is there any sequence of ids that is not a possible output? If yes, write an example.

//No. All combinations are possible.

// 2. Will the threads always be synchronized using the same object? Explain.

//No. Could be, could not be.