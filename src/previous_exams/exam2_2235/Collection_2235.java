package exam2.exam2_2235;
import java.util.*;

class Robot implements Comparable<Robot>{
    String model;
    Integer serialNumber;

    @Override
    public String toString() {
        return serialNumber+": "+model;
    }

    @Override
    public int compareTo(Robot o) {
        return o.serialNumber.compareTo(this.serialNumber);
    }

    Robot(String model, Integer serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
    }
}

public class Collection_2235<T> {
    public static void main(String[] args)	{
        List<Robot> robotList = new ArrayList<>();
        robotList.add(new Robot("R2D2",0401));
        robotList.add(new Robot("C3PO",0402));
        robotList.add(new Robot("BB8",2403));
        Collections.sort(robotList);
        System.out.println(robotList);

        Collection<Integer> treeSet = new TreeSet<>();
        for (int i=0; i<1000; i++) treeSet.add(i); //1

        Collection<Integer> arrayList = new ArrayList<>();
        for (int i=0; i<10; i++)
            for (int j=0; j<1000; j++)
                arrayList.add(i);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i:arrayList) map.put(i,map.get(i)==null?1:(Integer)map.get(i)+1); //2
        System.out.println(map.keySet().size());

    }
}

// 1. What is the output of this program?

//[2403: BB8, 258: C3PO, 257: R2D2]
//        10

// 2. How could you make the line marked with //1 faster?

// using hashsets

// 2 (alt). Explain what the line marked with in-line comment "//2" is performing.

// Using a Hashmap to store how many times each number from 0 to 999 appears in arrayList.

