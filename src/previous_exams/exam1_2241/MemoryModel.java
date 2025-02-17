package inperson; //3

public class MemoryModel {
    int o = 2;
    MemoryModel(int init) { o = init; }
    MemoryModel() { MemoryModel i = new MemoryModel(); i.o = 3;}

    public MemoryModel copy(MemoryModel o) {
        o.o = this.o;
        return this;
    }

    public String toString() { return String.valueOf(o); }

    public static void main(String[] args) {
//        MemoryModel y = new MemoryModel(); //MARKED
        MemoryModel o = new MemoryModel(1);
        System.out.println(o);
        System.out.println(o.o);
        System.out.println(o.copy(new MemoryModel(0)));

    }
}

// Answer the following.

// 1. What is the output of this program? // 1 1 1

// 2. If the line marked with //MARKED is uncommented, what would happen?

// nothing changes
