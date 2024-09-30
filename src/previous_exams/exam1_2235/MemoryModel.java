package exam1.exam1_2235;//package exam1; //1

public class MemoryModel {

    int i = 1;
    static int o = 0;
    MemoryModel m;
    MemoryModel(int o) {}

    static private MemoryModel inc(MemoryModel o) {
        o.o += 1;
        return o;
    }

    private MemoryModel inc() {
        i++;
        return this;
    }

    public String toString() { return String.valueOf(i); }

    public static void main(String[] args) {
        MemoryModel a = new MemoryModel(1);
        System.out.println(a.m);
        a.m = a;
        a.m.inc(a);
        System.out.println(a.m);
        a.m.inc().inc(a);
        System.out.println(a);
    }
}

// Answer the following.

// 1. What is the output of this program?

// 2. Will private method inc() be callable from the main method? Explain.