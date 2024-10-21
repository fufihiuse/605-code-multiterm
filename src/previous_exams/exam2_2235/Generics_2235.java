package exam2.exam2_2235;

abstract class Parent_2235<T> {
    T aT;
    private void go(T aT) {
        System.out.println("parent");
    };
}

interface Interface_2235<T> {
    default void go(T aT) {
        System.out.println("interface");
    };
}

public class Generics_2235<T> extends Parent_2235<T> implements Interface_2235<T> {
    public void go(T aT)	{ System.out.print("child"); }
    public void set(T aT) { this.aT = aT; }
    public static void main(String args[])	{
        Parent_2235 a = new Generics_2235<Integer>();
        Generics_2235 b = (Generics_2235) a; //1
//        b.set("yo"); //2
        System.out.println((String)b.aT);
    }
}


// This program compiles as is.
// 1. Is the type-parameter being checked in line commented with //1?

//No, we used a raw type

// 2. What will happen if we set the type-parameter in the same line to Integer, e.g.:
// Generics_2235<Integer> b = (Generics_2235<Integer>) a; //1

//compilation error, incompatible type parameter

// 3. What will be the output of the program as is?

// null

// 4. What will be the output of the program if we uncomment line marked with //2?

//yo
