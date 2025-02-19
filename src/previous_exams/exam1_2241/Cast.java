package inperson; //5

public class Cast extends CastMom {

    private int value = 0;
    private Cast(int value) { super(2*value); this.value = value; }
    public String toString() { return String.valueOf(value); }

    public static void main(String[] args) {
        CastMom a = new Cast(10);
        Cast b = (Cast) a;
        CastMom c = b;
        System.out.println(a.value + " " + b.value + " " + c.value);
        System.out.println(a + " " + b + " " + c);
    }
}

class CastMom {
    protected int value = 10; //MARKED
    CastMom(int value) { this.value = value; }
    public String toString() { return String.valueOf(value); }
}

// Answer the following.

// 1. What is the output of this program?

// 20 10 20, 10 10 10

// 2. If line with //MARKED change the access modifier to private, what would happen?

// Would not compile because the child main method does not have access to the private field of the parent class.
