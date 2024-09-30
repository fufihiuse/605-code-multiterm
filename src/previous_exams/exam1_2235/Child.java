package exam1.exam1_2235; //3

interface Required {
    default String sayHey() { return ""; };
}

abstract class Parent {
    public String scream() { return "hey\n"; }
}

public final class Child extends Parent implements Required {
    private final String info = "";
    public String sayHey() { super.scream(); return "ho\n"; }
    public String sayHo() { return this.scream(); }
    public static void main(String[] args) {
        Child a = new Child();
        System.out.println(a.sayHey() + a.sayHo());
    }
}

// Answer the following questions.

// 1. What is the output of the program run?

// 2. If the type of the local variable 'a' is changed from Child to Parent, what happens?

// 3. What advantage would there be to declare an immutable type class as final?

// 4. What happens if you replace the provided Required interface with the following one?
//interface Required {
//    String sayHey();
//}

