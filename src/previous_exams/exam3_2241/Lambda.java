package exam3_2241;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {

        Supplier<List<Integer>> supplier = LinkedList::new; //1
        System.out.println(supplier.get().add(1));

    }
}



// 1. Rewrite the statement in //1 using a lambda expression

//Supplier<List<Integer>> supplier = () -> new LinkedList<>();

// 2. Rewrite the statement in //1 using an anonymous class

//Supplier<List<Integer>> supplier2 = new Supplier<List<Integer>>() {
//    @Override
//    public List<Integer> get() {
//        return new LinkedList<>();
//    }
//};