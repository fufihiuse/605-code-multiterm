package exam1.exam1_2235; //4

public class Super extends SuperParent {
    private int counter = 1;

    public Super inc(Super o) {
        super.counter -= 1;
        return o;
    }

    public SuperParent inc() {
        counter++;
        return this; // MARKED1
    }

    public String toString() { return String.valueOf(counter); }

    public static void main(String[] args) {
        Super child = new Super();
        SuperParent parent = child;
        System.out.println("" + parent.counter + " " + child.counter);
        parent.inc();
        child.inc((Super)parent);
        System.out.println("" + parent.counter + " " + child.counter);
    }
}

class SuperParent {
    protected int counter = -1;

    protected SuperParent inc() {
        counter--;
        return this;
    }
}
// Answer the following question.

// 1. What is the output of this code?

// 2. Is there a problem in line marked with //MARKED1? Explain.
