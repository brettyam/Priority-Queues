//Brett Yamada, CSE 373 Winter 2014, Homework #3
//This class implements a priority queue ADT through the use of a binary min-heap.
//The min-heap is modeled by an array. The order of return is dependent on the 
//priority (the lower the value the higher the priority). Higher priority items
//return first and do not depend on when they were inserted like a normal queue would.
//Duplicates are allowed.

public class BinaryHeap implements PriorityQueue {
	private double[] minHeap; 	//array representation of the min-heap
	private int size;			//amount of elements in the priority queue
	
	//constructs the priority queue ADT
	public BinaryHeap() {
		this.minHeap = new double[10];
		this.size = 0;
	}
	
	//returns true if the priority queue has no elements
	public boolean isEmpty() {
		return (this.size == 0);
	}

	//returns the number of elements in the priority queue
	public int size() {
		return this.size;
	}

	//returns the minimum element in the priority queue
	public double findMin() {
		if (this.isEmpty()) {
			throw new EmptyPQException();
		}
		return this.minHeap[1];
	}

	//inserts a new element into the priority queue
	//duplicate values ARE allowed
	//the parameter x denotes the value to be inserted
	public void insert(double x) {
		this.size++;
		//resize if necessary
		if (this.size == this.minHeap.length) {
			double[] bigHeap = new double[this.minHeap.length * 2];
			for (int i = 0; i < this.minHeap.length; i++) {
				bigHeap[i] = this.minHeap[i];
			}
			this.minHeap = bigHeap;
		}
		int index = percolateUp(this.size, x);
		minHeap[index] = x;
	}

	//removes and returns the minimum element from the priority queue
	public double deleteMin() {
		if (this.isEmpty()) {
			throw new EmptyPQException();
		}
		double min = minHeap[1];
		int hole = percolateDown(1, minHeap[this.size]);
		minHeap[hole] = minHeap[this.size];
		this.size--;
		return min;
	}

	//resets the priority queue to appear as not containing any elements
	public void makeEmpty() {
		this.minHeap = new double[10]; 
		this.size = 0;
	}
	
	//returns a string representation of the min-heap as an array
	//excludes index 0
	public String toString() {
		if (this.isEmpty()) {
			return "top [] bottom";
		} else {
			String result = "top [";
			for (int i = 1; i < this.size; i++) {
				result += minHeap[i] + ", " ;
			}
			return result + minHeap[size] + "] bottom";
		}
	}
	
	//percolates a node up the min-heap, changing positions as necessary
	private int percolateUp(int hole, double val) {
		while (hole > 1 && val < minHeap[hole / 2]) {
			minHeap[hole] = minHeap[hole / 2];
			hole = hole / 2;
		}
		return hole;
	}
	
	//percolates a node down the min-heap, changing positions as necessary
	private int percolateDown(int hole, double val) {
		int left;
		int right;
		int target;
		
		while (2 * hole <= this.size) {
			left = 2 * hole;
			right = left + 1;
			if (right > this.size || minHeap[left] < minHeap[right]) {
				target = left;
			} else {
				target = right;
			}
			if (minHeap[target] < val) { 
				minHeap[hole] = minHeap[target];
				hole = target;
			} else {
				break;
			}
		}
		return hole;
	}
}