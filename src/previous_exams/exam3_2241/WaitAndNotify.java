package exam3_2241;

public class WaitAndNotify extends Thread    {
    static Object o = new Object();
    static int counter = 0;
    int id;
    public WaitAndNotify(int id)  { this.id = id; o = new Object(); }
    public void run () {
        if ( id == 0 )  {
                new WaitAndNotify(1).start();
                new WaitAndNotify(2).start();
        }
        else synchronized ( o ) {
                System.err.println(id);
                try {
                        if ( counter == 0 ) {
                            counter = 1;
                            o.wait();
                        }
                }
                catch (  InterruptedException e ) { }
                System.err.println(id);
            }
    }
    public static void main (String[] args) {
        new WaitAndNotify(0).start();
    }
}

// 1. What are ALL the possible outputs of running this program?

// synchronized: 122wait..., 211wait...
// not synchronized: illegal monitor cases: 1exception, 12exception, 122exception
// not synchronized, wait cases: 122wait..., 211wait...

// 2. Is it possible that a thread is indefinitely in the
// WAITING state in one of this program's runs? Explain.

// Yes. If the second thread finishes the constructor
// before the first thread goes.
