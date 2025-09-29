package exam1_2245; //5

public class Cast extends CastMom {

    private int value = -10;
    private Cast(int value) { this.value = value; }
    public String toString() { return String.valueOf(value); }

    public static void main(String[] args) {
        CastMom a = new Cast(10);
        Cast b = (Cast) a;
        CastMom c = b;
        System.out.println(b.value + " " + c.value);
        System.out.println(b + " " + c);
    }
}

class CastMom {
    protected int value = 10;
    CastMom(int value) { this.value = value; }
    public CastMom() { this.value = 0; } //MARKED
    public String toString() { return String.valueOf(value); }
}

// Answer the following.

// 1. What is the output of this program?
//
// 10 0, 10 10

// 2. If line with //MARKED change the access modifier to private, what would happen?
//
// child constructor would not be able to call parent constructor
