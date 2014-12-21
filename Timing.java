//Brett Yamada, CSE 373 Winter 2014, Homework #3
//This class is used to time some of the run-times for the methods used
//in BinaryHeap.java, ThreeHeap.java, and MyPQ.java.

public class Timing {
	public static final int NUM_TIMINGS = 5;
	
	public static void main(String[] args) {
		PriorityQueue test = new MyPQ();
		
		int n = 40000;
		for (int timing = 0; timing < NUM_TIMINGS; timing++) {
			//long startTime = System.nanoTime();
			for (int i = 0; i < n; i++) {
				test.insert((double) Math.random() * 100.00);
			}
			//long endTime = System.nanoTime();
			
			long startTime = System.nanoTime();
			for (int i = test.size(); i > 0; i--) {
				test.deleteMin();
			}
			long endTime = System.nanoTime();
			
			long elapsedTime = endTime - startTime;
			//1 second = 1000000000 (10^9) nanoseconds.
			//System.out.println("Run #" + runs + ": " + elaspedTime + " nanoseconds or " +
							//elapsedTime/(1000000000.0) + " seconds elapsed");
			System.out.println(elapsedTime/(1000000000.0));
			//test.makeEmpty();
		}
	}
}