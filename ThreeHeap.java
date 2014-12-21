//Brett Yamada, CSE 373 Winter 2014, Homework #3
//This class implements a priority queue ADT through the use of a "three-heap".
//In the three-heap, a node is allowed to have up to three children and is modeled
//by an array. It still behaves like a normal priority queue: the order of return 
//is dependent on the priority (the lower the value the higher the priority). 
//Higher priority items return first and do not depend on when they were inserted 
//like a normal queue would. Duplicates are allowed.

public class ThreeHeap implements PriorityQueue {
	private double[] threeHeap;	//array representation of the threeHeap
	private int size;			//amount of elements in the priority queue

	//constructs the priority queue ADT
	public ThreeHeap() {
		this.threeHeap = new double[10];
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
		return this.threeHeap[1];
	}

	//inserts a new element into the priority queue
	//duplicate values ARE allowed
	//the parameter x denotes the value to be inserted
	public void insert(double x) {
		this.size++;
		//resize if necessary
		if (this.size == this.threeHeap.length) {
			double[] bigHeap = new double[this.threeHeap.length * 2];
			for (int i = 0; i < this.threeHeap.length; i++) {
				bigHeap[i] = this.threeHeap[i];
			}
			this.threeHeap = bigHeap;
		}
		int index = percolateUp(this.size, x);
		threeHeap[index] = x;	
	}

	//removes and returns the minimum element from the priority queue
	public double deleteMin() {
		if (this.isEmpty()) {
			throw new EmptyPQException();
		}
		double min = threeHeap[1];
		int hole = percolateDown(1, threeHeap[this.size]);
		threeHeap[hole] = threeHeap[this.size];
		this.size--;
		return min;
		
	}

	//resets the priority queue to appear as not containing any elements
	public void makeEmpty() {
		this.threeHeap = new double[10];
		this.size = 0;
	}
	
	//returns a string representation of the three-heap as an array
	//excludes index 0
	public String toString() {
		if (this.isEmpty()) {
			return "top [] bottom";
		} else {
			String result = "top [";
			for (int i = 1; i < this.size; i++) {
				result += threeHeap[i] + ", " ;
			}
			return result + threeHeap[size] + "] bottom";
		}
	}
	
	//percolates a node up the three-heap, changing positions and necessary
	private int percolateUp(int hole, double val) {
		while (hole > 1 && val < threeHeap[(hole + 1) / 3]) {
			threeHeap[hole] = threeHeap[(hole + 1) / 3];
			hole = (hole + 1) / 3;
		}
		return hole;
	}
	
	//percolates a node down the three-heap, changing positions as necessary
	private int percolateDown(int hole, double val) {
		int left;
		int mid;
		int right;
		int target;
		
		while (3 * hole - 1 <= this.size) {
			left = hole * 3 - 1;
			mid = left + 1;
			right = left + 2;
			if (mid > this.size ||
			(threeHeap[left] < threeHeap[mid] && threeHeap[left] < threeHeap[right])) {
				target = left;
			} else if (right > this.size ||
			threeHeap[mid] < threeHeap[left] && threeHeap[mid] < threeHeap[right]){
				target = mid;
			} else {
				target = right;
			}
			if (threeHeap[target] < val) { 
				threeHeap[hole] = threeHeap[target];
				hole = target;
			} else {
				break;
			}
		}
		return hole;
	}
}