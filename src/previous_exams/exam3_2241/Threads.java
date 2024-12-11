package exam3_2241;

public class Threads extends Thread {
    static Object lock = new Object();
    int id;

    public Threads(Object lock, int id) { this.lock = lock; this.id = id; }

    public void run () {
        synchronized (lock) {
            System.out.println(id);
            lock.notify();
            System.out.println(id);
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        (new Threads(lock, 1)).run();
        (new Threads(lock, 2)).run();
    }
}

// Answer the questions.
// 1 - What is the difference between calling run() and start()?

// start launches the thread, run just sets the code for the thread

// 2 - What are the possible outputs of this program?

// single thread (synchronized doesnt matter):
// 1122
