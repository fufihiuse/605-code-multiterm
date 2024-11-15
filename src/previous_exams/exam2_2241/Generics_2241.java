package exam2_2241;

abstract class Parent_2241<T> {
    T aT;
    private void go(T aT) {};
}

interface Interface_2235<T> {
    void go(T aT);
}

public class Generics_2241<T> extends Parent_2241<T> implements Interface_2235<T> {
    public void go(T aT)	{ System.out.print("child"); }
    public void set(T aT) { this.aT = aT; }
    public static void main(String args[])	{
        Parent_2241 a = new Generics_2241<Integer>();
        Generics_2241 b = (Generics_2241) a;
        b.set("yo"); //1
        System.out.println((String)b.aT);
    }
}


// Answer the following.

// 1. Write an implementation for the class Parent_2241<T> that allows the code to
// compile without errors.

// 2. Explain why the line marked with "//1" will not generate a compile time error

//Use of raw type skips type checking.
