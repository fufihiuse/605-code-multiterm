package exam1.exam1_2235; //5

class SubClass extends SuperClass {
    private int value = 0;
//    private SubClass() { super.value = value; }
    private void increment() { value++; }
    public String toString() { return String.valueOf(value); }
}

public class SuperClass {
    protected int value = 10;
//    SuperClass(int value) { this.value = value; } // MARKED
    public static void main(String[] args) {
//        System.out.println(new SubClass());
    }
}

// Answer the following.

// 1. This program has 2 problems. Identify and explain how to fix them.

// 2. Can the line with the comment "MARKED" be fully removed with no harm to the execution of this code? Why?
