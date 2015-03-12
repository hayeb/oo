package assignment6;
/**
 * For maintaining lists of T-elements enabling
 * a structure suited for backwards traversal
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.2
 * @date 28-02-2015
 */
public class Node<T> implements Comparable<T>
{
    // the data field
    private T item;
    // a reference to the predecessor
    private Node<T> previous;

    /* A constructor that initializes each node
     * with the specified values
     * @param from the node preceding the current node
     * @param item the initial data item
     */
    public Node (Node<T> from, T item) {
        this.previous    = from;
        this.item        = item;
    }

    /* a getter for the item
     * @return item
     */
    public T getItem() {
        return item;
    }

    /*
     * a getter for the predecessor
     * @return previous
     */
    public Node<T> getPrevious() {
        return previous;
    }

    /*
     * determines the length of the current list
     * @return the length as an integer
     */
    public int length () {
        int length = 1;
        Node<T> prev = previous;
        while ( prev != null ) {
            prev = prev.previous;
            length++;
        }
        return length;
    }
    
    @Override
    public String toString() {
        if (previous == null) {
        	return length()  + ":\n" + item.toString();
        } else {
        	return previous.toString() +"\n" + length()  + ":\n" + item.toString();
        }      
    }

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return ((Comparable<T>) o).compareTo((item));
	}
}