abstract public class SortedStorage {

	private class Node 	{
		Node(String element)	{
			payLoad = element;
			left = right = null;
		}
		private Node  left;
		private Node  right;
		String payLoad= null;
	}
	Node  root;

	abstract public int howManyNulls();
	abstract public boolean includesNull();
	abstract public boolean delete(String element);
	abstract public boolean find(String element);
	abstract public boolean add(String element);
	abstract public String toString();

}

