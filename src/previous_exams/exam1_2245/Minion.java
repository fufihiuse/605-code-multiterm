package exam1_2245;

public class Minion {
    static final String MINION_NAME = "Minion";
    int count;
    int id;
    String name;
    Minion() { name = MINION_NAME + " " + ++count; }

    public String toString() { return name; }

    public static void main(String[] args) {
        Minion[] minions = new Minion[3];
        for (int i = 0 ; i < minions.length; i++) minions[i] = new Minion();
        for (Minion minion:minions) System.out.println(minion);
    }
}

// Answer the following questions

// 1. What is the output of this program

// Minion 1 x3

// 2. What happens if the constructor access modifier is changed to the default access? Explain.

// nothing, everything is the same class.