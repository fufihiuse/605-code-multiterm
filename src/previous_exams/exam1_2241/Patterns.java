package inperson; //4

import java.util.regex.Pattern;

public class Patterns {
    public static void main( String args[] ) {
//        String input = "22.AZ";
        String input = "22.AA";
//        String input = "";

//        String pattern0 = "a|aaa|aba|";
//        System.out.println(Pattern.matches(pattern0, input));
//
        String pattern1 = "[1-2]*[2-3]\\.[A|Z]+";
        String pattern2 = "[1-2]+[2-3]?\\..[A-Z]+";
        System.out.println(Pattern.matches(pattern1, input));
        System.out.println(Pattern.matches(pattern2, input));
    }
}

// Answer the following.

// 1. Provide TWO examples of inputs that simultaneously match BOTH following patterns.
// Patterns as presented as if they would be initialized in a String instance.
//"[1-2]*[2-3]\\.[A|Z]+"
//"[1-2]+[2-3]?\\..[A-Z]+"

// 2. Write down a pattern that would match the following inputs (one pattern for each input)
// "a", "aaa", "", "aba"
