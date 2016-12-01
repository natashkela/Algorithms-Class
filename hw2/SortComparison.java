package nvacheishvili.hw2;

import edu.princeton.cs.algs4.*;

// Template to use for Question 1 on Homework 2
public class SortComparison {
	static Double[] generateData(int n) {
		Double[] vals = new Double[n];
		for (int i=0;i<n;i++){
			vals[i]=StdRandom.uniform();
		}
		return vals;
	}
	
	// These have been placed here so you can double check that each of the sorting algorithms
	// did indeed sort the data. Note: DO NOT CALL THIS FUNCTION WITHIN YOUR Stopwatch time period
	// when you are checking for the total elapsed time for the respective algorithm to complete
	static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
	static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
	
	// You are responsible for updating these values.
	//
	// [n][s][0] = best time for algorithm #s on a dataset of size n
	// [n][s][1] = fewest number of exch operations for algorithm #s on a dataset of size n
	// [n][s][2] = fewest number of less operations for algorithm #s on a dataset of size n
	static double[][][] results = new double[12][5][3];
	
	// Generates the table with the proper formatting. Use as is.
	public static void generateReport() {
		StdOut.println("Time Trials");
		StdOut.println("N\tInsert\tSelect\tMerge\tQuick\tQuickA\n");
		for (int n = 4, idx = 0; n <= 8192; n*= 2, idx++) {
			StdOut.println(n + "\t" + results[idx][0][0] + 
					"\t" + results[idx][1][0] + 
					"\t" + results[idx][2][0] + 
					"\t" + results[idx][3][0] +
					"\t" + results[idx][4][0]);
		}
		
		StdOut.println();
		StdOut.println("Exch Results");
		StdOut.println("N\tInsert\tSelect\tMerge\tQuick\tQuickA\n");
		for (int n = 4, idx = 0; n <= 8192; n*= 2, idx++) {
			StdOut.println(n + "\t" + (int)results[idx][0][1] + 
					"\t" + (int)results[idx][1][1] + 
					"\t" + (int)results[idx][2][1] + 
					"\t" + (int)results[idx][3][1] +
					"\t" + (int)results[idx][4][1]);
		}
		
		StdOut.println();
		StdOut.println("Less Results");
		StdOut.println("N\tInsert\tSelect\tMerge\tQuick\tQuickA\n");
		for (int n = 4, idx = 0; n <= 8192; n*= 2, idx++) {
			StdOut.println(n + "\t" + (int)results[idx][0][2] + 
					"\t" + (int)results[idx][1][2] + 
					"\t" + (int)results[idx][2][2] + 
					"\t" + (int)results[idx][3][2] +
					"\t" + (int)results[idx][4][2]);
		}
	}

	// I suggest it might be useful to have a helper method such as this, which properly updates
	// the results[n][entry][xxx] values where xxx is 0 for time, 1 for exchange, and 2 for less.
	// 
	// The purpose of this method is to ensure you record the minimum time, the fewest number of
	// exchanges, and the fewest number of comparison operations.
	static void updateEntry(int trial, int n, int entry, int exch, int less, double time) {
		
		if (trial!=0){
			if(results[n][entry][0]>time){
				results[n][entry][0]=time;
			}
			
			if(results[n][entry][1]>exch){
				results[n][entry][1]=exch;
			}
			
			if(results[n][entry][2]>less){
				results[n][entry][2]=less;
			}
		}
		else {
			results[n][entry][0]=time;
			results[n][entry][1]=exch;
			results[n][entry][2]=less;
		}
	}
	
	public static void main(String[] args) {
		
		// run for 10 trials
		int T = 10;
		for (int t = 0; t < T; t++) {
			for (int n = 4, idx = 0; n <= 8192; n*= 2, idx++) {
				
				// note idx is a value from 0 up to and including 12.
				// For each algorithm to be compared (InsertionSort,SelectionSort,MergeSort,QuickSort,QuickSortAlternate)
				// you must generate the data set to use, create a Stopwatch to measure the time, launch the 
				// sort request, record the elapsed time, validate that the array was actually sorted, and 
				// then update the appropriate entry with the recorded new values...
				Double ar[];
				
				ar = generateData(n);
				StopwatchCPU stopwatch = new StopwatchCPU();
				Insertion.sort(ar);
				double time = stopwatch.elapsedTime();
				if(!isSorted(ar)) {
					System.out.println("Did not work");
				}
				updateEntry(t,idx,0,Insertion.exchCount,Insertion.lessCount,time);
				
				
				ar = generateData(n);
				StopwatchCPU stopwatch1 = new StopwatchCPU();
				Selection.sort(ar);
				double time1 = stopwatch1.elapsedTime();
				if(!isSorted(ar)) {
					System.out.println("Did not work");
				}
				updateEntry(t,idx,1,Selection.exchCount,Selection.lessCount,time1);
				
				ar = generateData(n);
				StopwatchCPU stopwatch2 = new StopwatchCPU();
				Merge.sort(ar);
				double time2 = stopwatch2.elapsedTime();
				if(!isSorted(ar)) {
					System.out.println("Did not work");
				}
				updateEntry(t,idx,2,Merge.exchCount,Merge.lessCount,time2);
				
				
				ar = generateData(n);
				StopwatchCPU stopwatch3 = new StopwatchCPU();
				Quick.sort(ar);
				if(!isSorted(ar)) {
					System.out.println("Did not work");
				}
				double time3 = stopwatch3.elapsedTime();
				updateEntry(t,idx,3,Quick.exchCount,Quick.lessCount,time3);
				
				ar = generateData(n);
				StopwatchCPU stopwatch4 = new StopwatchCPU();
				QuickAlternate.sort(ar);
				if(!isSorted(ar)) {
					System.out.println("Did not work");
				}
				double time4 = stopwatch4.elapsedTime();
				updateEntry(t,idx,4,QuickAlternate.exchCount,QuickAlternate.lessCount,time4);
				
				
				}

			}
		
		
		// Once done, generate the report
		generateReport();
	}

}
