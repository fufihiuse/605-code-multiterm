package exam3_2241;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class UsingListsOnline {

	public static void main(String[] args) {
        Random rand = new Random();
		ArrayList<Integer> alist = new ArrayList<>();
		LinkedList<Integer> llist = new LinkedList<>();
        for(int i = 0; i < 1000; i++) {
            alist.add(rand.nextInt() % 1000);
            llist.add(rand.nextInt() % 1000);
        }

        alist.get(rand.nextInt() % 1000); // 1
        llist.get(rand.nextInt() % 1000); // 2

        alist.remove(alist.size()-1); // 3
        llist.remove(llist.size()-1); // 4
    }
}


// 1. What are the expected worst-case time complexity (in Big-O notation) of //1 and //2? Explain.

// O(1) and O(n)

// 2. What are the expected worst-case time complexity (in Big-O notation) of //3 and //4? Explain.

// O(1) and O(1)
