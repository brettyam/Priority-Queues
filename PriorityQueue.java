/**
 * Base interface for priority queue implementations for doubles. 
 * Throw exceptions as appropriate. 
 */
public interface PriorityQueue {
	/**
	 * Returns true if priority queue has no elements
	 *
	 * @return true if the priority queue has no elements
	 */
	public boolean isEmpty();


	/**
	 * Returns the number of elements in this priority queue.
	 *
	 * @return the number of elements in this priority queue.
	 */
	public int size();


	/**
	 * Returns the minimum element in the priority queue
	 *
	 * @return the minimum element 
         * @throws EmptyPQException if priority queue contains no elements
	 */
	public double findMin();


	/**
	 * Inserts a new element into the priority queue.
	 * Duplicate values ARE allowed.
	 *
	 * @param x element to be inserted into the priority queue.
	 */
	public void insert(double x);


	/**
	 * Removes and returns the minimum element from the priority queue.
	 *
	 * @return the minimum element
         * @throws EmptyPQException if priority queue contains no elements
	 */
	public double deleteMin();


	/**
	 * Resets the priority queue to appear as not containing
	 * any elements.
	 */
	public void makeEmpty();

}