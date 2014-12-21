public class PriorityQueueTest {
	public static void main(String[] args) {
		//BinaryHeap test
		System.out.println("BinaryHeap Test");
		BinaryHeap pq1 = new BinaryHeap();
		System.out.println(pq1.isEmpty());	//return true - check
		System.out.println(pq1.toString());	// return top [] bottom - check
		pq1.insert(5);
		pq1.insert(7);
		pq1.insert(9);
		pq1.insert(8);
		pq1.insert(10);
		pq1.insert(11);
		System.out.println(pq1.toString());	//return [5, 7, 9, 8, 10, 11] - check
		pq1.insert(4);
		System.out.println(pq1.toString()); // return [4, 7, 5, 8, 10, 11, 9] - check 
		//insert() and percolateUp() work, checked with duplicates
		
		pq1.deleteMin();
		System.out.println(pq1.toString());	//return [5, 7, 9, 8, 10, 11] - check
		//deleteMin() and percolateDown() work, checked with duplicates
		System.out.println(pq1.findMin());	//return 5 - check
		pq1.insert(5);
		System.out.println(pq1.toString());	//return [5, 7, 5, 8, 10, 11, 9] - check
		pq1.insert(3);
		System.out.println(pq1.toString());	//return [3, 5, 5, 7, 10, 11, 9, 8] - check
		System.out.println(pq1.deleteMin());//return 3 - check
		System.out.println(pq1.toString());	//return [5, 5, 8, 7, 10, 11, 9] - check
		pq1.deleteMin();
		System.out.println(pq1.toString());	//return [5, 7, 8, 9, 10, 11] - check
		pq1.insert(21);
		pq1.insert(8);
		pq1.insert(16);
		pq1.insert(2);
		System.out.println(pq1.toString());	//return [2, 5, 8, 8, 7, 11, 21, 9, 16, 10] - check
		pq1.deleteMin();
		System.out.println(pq1.toString());	//return [5, 7, 8, 8, 10, 11, 21, 9, 16] - check
		pq1.deleteMin();
		System.out.println(pq1.toString());	//return [7, 8, 8, 9, 10, 11, 21, 16] - check
		pq1.deleteMin();
		System.out.println(pq1.toString());	//return [8, 8, 11, 9, 10, 16, 21] - check
		
		//ThreeHeap test
		System.out.println("ThreeHeap Test");
		ThreeHeap pq2 = new ThreeHeap();
		pq2.insert(5);
		pq2.insert(7);
		pq2.insert(10);
		pq2.insert(15);
		System.out.println(pq2.toString());	//return [5, 7, 10, 15] - check
		pq2.insert(4);
		System.out.println(pq2.toString());	//return [4, 5, 10, 15, 7] - check
		pq2.insert(8);
		System.out.println(pq2.toString());	//return [4, 5, 10, 15, 7, 8] - check
		pq2.insert(3);
		System.out.println(pq2.toString()); //return [3, 4, 10, 15, 7, 8, 5] - check
		//insert() and percolateUp() seem to be working correctly
		
		pq2.deleteMin();
		System.out.println(pq2.toString());	//return [4, 5, 10, 15, 7, 8] - check
		pq2.deleteMin();
		System.out.println(pq2.toString());	//return [5, 8, 10, 15, 7] - check
		pq2.insert(5);
		System.out.println(pq2.toString());	//return [5, 5, 10, 15, 7, 8] - check
		pq2.insert(9);						
		System.out.println(pq2.toString());	//return [5, 5, 10, 15, 7, 8, 9] - check
		pq2.deleteMin();
		System.out.println(pq2.toString());	//return [5, 7, 10, 15, 9, 8] - check
		pq2.deleteMin();
		System.out.println(pq2.toString());	//return [7, 8, 10, 15, 9] - check
		pq2.deleteMin();
		System.out.println(pq2.toString());	//return [8, 9, 10, 15] - check
		pq2.deleteMin();
		System.out.println(pq2.toString());	//return [9, 15, 10] - check
		pq2.deleteMin();
		System.out.println(pq2.toString());	//return [10, 15] - check
		pq2.deleteMin();
		System.out.println(pq2.toString());	//return [15] - check
		pq2.deleteMin();
		System.out.println(pq2.toString());	//return [] - check
		System.out.println(pq2.isEmpty());	//return true - check
		//percolateDown() works
		
		//MyPQ test
		System.out.println("MyPQ test");
		MyPQ pq3 = new MyPQ();
		pq3.insert(6);
		pq3.insert(4);
		pq3.insert(10);
		pq3.insert(3);
		pq3.insert(5);
		System.out.println(pq3.deleteMin());	//return 3 - check
		System.out.println(pq3.deleteMin());	//return 4 - check
		System.out.println(pq3.deleteMin());	//return 5 - check
		System.out.println(pq3.deleteMin());	//return 6 - check
		System.out.println(pq3.deleteMin());	//return 10 - check
	}
}