package exam3_2241;

public class ThreadsOnline extends Thread {
    static Object lock = new Object();
    int id;

    public ThreadsOnline(Object lock, int id) { this.lock = lock; this.id = id; }

    public void run () {
        synchronized (lock) {
            System.out.println(id);
            try { lock.wait(); } catch (InterruptedException e) {}
            System.out.println(id);
            lock.notify();
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        (new ThreadsOnline(lock, 1)).start();
        (new ThreadsOnline(lock, 2)).run();
    }
}

// 1 - In this program, is an IllegalMonitorStateException possible? Why?

// No

// 2 - What are the possible outputs of this program?

// always synchronized:
// 12wait...
// 21wait...
