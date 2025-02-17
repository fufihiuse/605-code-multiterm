package inperson; //1

public class Args {
    private int value;
    Args change( int value ) { value -= 1; return this; }
    public String toString() { return String.valueOf(value); }

    public static void main(String args[] ) {
        Args a = new Args();
        System.out.println(a);
        Args b = a.change(a.value);
        System.out.println(a);
    }
}


// 1. Draw a memory model diagram showing all variables and object instances

// 2. What is the output of this program? // 0 0
