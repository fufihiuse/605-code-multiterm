package inperson; //2

interface Contract {
    default String scream() { return ""; };
    static String helper() { return "Helping"; }
}

abstract class Parent {
    public String scream() { return "aaaaa"; } //MARKED1
}

public final class Child extends Parent implements Contract {
    public static void main(String[] args) {
        new Child().scream();
        System.out.println(Contract.helper());
    }
}

// Answer the following questions.

// 1. In line with the comment //MARKED1, what happens if you change the access modifier to private?

// Invalid modifier since Child can not access private parent members.

// 2. What is the output of this code?

// Helping (ps: return is not printed for scream())