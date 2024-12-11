package exam3_2241;

import java.util.function.Function;

public class LambdaOnline {
    public static void main(String[] args) {
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return Integer.toBinaryString(integer);
            }
        };

        System.out.printf("Binary representation of %s is %s%n", 7, function.apply(7));
    }
}



// 1. Rewrite statement that declares variable 'function' using a lambda expression

// Function<Integer, String> function = (x) -> Integer.toBinaryString(x);

// 2. Rewrite statement that declares variable 'function' using a method reference

// Function<Integer, String> function = Integer::toBinaryString;
