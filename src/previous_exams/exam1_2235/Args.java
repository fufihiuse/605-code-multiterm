package exam1.exam1_2235;

public class Args {
    static void poke( String[] arg ) { arg[1] += "go"; }  // MARKED

    public static void main(String args[] ) {
        String[] array = {"dont","go"};
        System.out.println(array[1]);
        poke(array);
        System.out.println(array[1]);
    }
}

// 1. Explain in detail what is happening in line //MARKED.

// 2. Still about the same line, is it syntactically valid?

// 3. What is the output of this program?

// 4. Draw a memory model diagram showing all object instances and variables of this program
