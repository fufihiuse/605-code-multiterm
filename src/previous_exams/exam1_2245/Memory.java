package exam1_2245;

class MemoryParent {
    int o;
    MemoryParent() { o = 1; }
    MemoryParent(int o) { this.o = o; }
}

public class Memory extends MemoryParent {

    int o;
    Memory() { Memory x = new Memory(); x.o = 1;}
    Memory(int o) {
        super(o);
    }
    Memory(Memory o) {
        this.o = o.o;
    }

    public Memory change(Memory o) {
        this.o = o.o;
        return o;
    }

    public String toString() {
        return String.valueOf(super.o) + " " + String.valueOf(o);
    }

    public static void main(String[] args) {
        Memory o = new Memory(new Memory(3));
        System.out.println(o);
        System.out.println(o.change(o));
//        System.out.println(o.change(new Memory())); //MARKED
    }
}


// Answer the following.

// 1. What is the output of this program?

// 1 0, 1 0

// 2. If the line marked with //MARKED is uncommented, what would happen?

// infinite loop


