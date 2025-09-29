package exam1_2245; //2

interface Yellable {
    default String scream() { return ""; };
    public static String helper() { return "Helping"; }
}

abstract class Parent implements Yellable {
    public String scream() { return "aaaaa"; } //MARKED1
}

public final class Daughter extends Parent {
    public String toString() { return super.toString(); }

    public static void main(String[] args) {
        Daughter d = new Daughter();
//        Parent p = new Parent(); //MARKED2
        System.out.println(d);
        System.out.println(Yellable.helper());
    }
}

// Answer the following questions.

// 1. In line with the comment //MARKED1, what happens if you change the access modifier to protected?

// can not override restricting modifier (from interface public default method)

// 2. What happens if you uncomment line marked with //MARKED2

// can not instantiate abstract class
