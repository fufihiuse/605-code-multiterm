package exam1_2245; //1

public class Args {
    private int value;
    Args init( int value ) { Args a = new Args(); a.value -= 1; return a; }
    public String toString() { return String.valueOf(value); }

    public static void main(String args[] ) {
        Args a = new Args();
        System.out.println(a);
        Args b = (new Args()).init(a.value);
        System.out.println(b);
    }
}


// 1. Draw a memory model diagram showing all variables and object instances



// 2. What is the output of this program?
//
// 0 -1
