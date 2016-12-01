package nvacheishvili.hw2;

import edu.princeton.cs.algs4.*;

// Q3 on Homeework 2
public class HeapExercise {

	static Double[] generateData(int n) {
		Double[] vals = new Double[n];
		for (int i = 0; i < n; i++) {
			vals[i] = StdRandom.uniform();
		}
		return vals;
	}

	// You are responsible for updating these values.
	//
	// [n][0] = fewest number of comparisons for delMax on heap of size n
	// [n][1] = most number of comparisons for delMax on heap of size n
	// [n][2] = fewest number of comparisons for insert on heap of size n
	// [n][3] = most number of comparisons for insert on heap of size n

	static int[][] results = new int[12][4];

	public static void generateReport() {
		StdOut.println("Heap Trials");
		StdOut.println("N\tDelMax\tInsert");
		for (int n = 4, idx = 0; n <= 8192; n*= 2, idx++) {
			StdOut.println(n + "\t" + results[idx][0]  + "\t" + results[idx][3]);
		}
	}

	// Update results, given information for the given trial, data size N, number of comparisons
	// during the delete operation and number of comparisons during the insert operation.
	private static void updateEntry(int trial, int n, int delComparisons, int insertComparisons) {
		if (trial!=0){
			if(results[n][0]>=delComparisons){
				results[n][0]=delComparisons;
			}

			if(results[n][3]>=insertComparisons){
				results[n][3]=insertComparisons;
			}

		}
		else {
			results[n][0]=delComparisons;
			results[n][3]=insertComparisons;
		}
	}

	public static void main(String[] args) {

		int T = 10;
		Double[] data;
		int delCount=0;
		int insertCount=0;
		for (int t = 0; t < T; t++) {
			for (int n = 4, idx = 0; n <= 8192; n*= 2, idx++) {
				data=generateData(n);
				MaxPQ pq = new MaxPQ();
				for (int i=0;i<n;i++){
					pq.insert(data[i]);
				}
				data = generateData(1000);
				for (int i=0;i<1000;i++){
					pq.resetCounter();
					double max = (Double) pq.delMax();
					delCount = pq.counter;
					pq.resetCounter();
					pq.insert(max);
					insertCount = pq.counter;
					updateEntry(t,idx,delCount,insertCount);
				}

			}
		}

		generateReport();
	}

}
