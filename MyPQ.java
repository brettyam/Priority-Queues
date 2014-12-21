//Brett Yamada, CSE 373 Winter 2014, Homework #3
//This class implements a priority queue through the use of a linked list.
//It will be kept in sorted order; higher priority items appear at the front.
//The order of return is dependent on the priority (the lower the value the 
//higher the priority). Higher priority items return first and do not depend 
//on when they were inserted like a normal queue would. Duplicates are allowed.

public class MyPQ implements PriorityQueue {
	private ListNode front;	//the front element in the priority queue
	private int size;		//the amount of elements in the priority queue
	
	//support class that creates the next element to be inserted into the priority queue
	class ListNode {
		public ListNode next;	//the next element in the priority queue
		public double data; 	//the value to be kept track of
		
		//constructs the list node with a given value and next node
		public ListNode(double data, ListNode next) {
			this.data = data;
			this.next = next;
		}
		
		//constructs the list node with only a given value
		public ListNode(double data) {
			this(data, null);
		}
		
		//constructor the list node without parameters
		public ListNode() {
			this(0.0, null);
		}
	}
	
	//constructs the priority queue ADT
	public MyPQ() {
		this.front = null;
		this.size = 0;
	}
	
	//returns true if the priority queue has no elements
	public boolean isEmpty() {
		return (front == null); 
	}

	//returns the number of elements in the priority queue
	public int size() {
		return this.size;
	}

	//returns the minimum number in the priority queue
	public double findMin() {
		if (this.isEmpty()) {
			throw new EmptyPQException();
		}
		return this.front.data;
	}

	//inserts a new element into the priority queue
	//duplicate values ARE allowed
	//the parameter x denotes the value to be inserted
	public void insert(double x) {
		if (front == null) {
			front = new ListNode(x);
		} else if (x < front.data) {
			ListNode temp = front;
			front = new ListNode(x, temp);
		} else {
			ListNode current = front;
			while (current.next != null && current.next.data < x) {
				current = current.next;
			}
			ListNode temp = current.next;
			current.next = new ListNode(x, temp);
		}
		this.size++;
	}

	//removes and returns the minimum element in the priority queue
	public double deleteMin() {
		if (this.isEmpty()) {
			throw new EmptyPQException();
		}
		double min = front.data;
		front = front.next;
		this.size--;
		return min;	
	}

	//resets the priority queue to appear as not containing any elements
	public void makeEmpty() {
		this.front = null;
		this.size = 0;
	}
	
}