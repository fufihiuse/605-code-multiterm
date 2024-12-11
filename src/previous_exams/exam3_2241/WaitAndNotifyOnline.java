package exam3_2241;

public class WaitAndNotifyOnline extends Thread    {
    static Object o = new Object();
    static int counter = 0;
    int id;
    public WaitAndNotifyOnline(int id)  { this.id = id; o = new Object(); }
    public void run () {
        if ( id == 0 )  {
                new WaitAndNotifyOnline(1).start();
                new WaitAndNotifyOnline(2).start();
        }
        else synchronized ( o ) {
                System.err.println(id);
                try {
                        if ( counter == 0 ) {
                            counter = 1;
                            o.wait();
                        } else
                            o.notifyAll();
                }
                catch (  InterruptedException e ) { }
                System.err.println(id);
            }
    }
    public static void main (String args []) {
        new WaitAndNotifyOnline(0).start();
    }
}

// 1. What are ALL the possible outputs of running this program?

// synchronized: 1221, 2112
// not synchronized: illegal monitor cases: 1exception, 12exception, 122exception
// not synchronized, wait cases: 122wait..., 211wait...

// 2. Is it possible that a thread is indefinitely in the
// WAITING state in one of this program's runs? Explain.

// Yes. If the second thread finishes the constructor
// before the first thread goes.
