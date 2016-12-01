package nvacheishvili.hw2;

import edu.princeton.cs.algs4.*;

public class UniqueBagBenchmark {
	
	// if you go to larger n, then you will run out of Java Heap space
	public static void main(String[] args) {
		System.out.println("Size\t Identical\t Add\t\t toArray\t contains\t remove \t intersects\t union\n");
		for (int n = 4; n <= 2097152; n *= 2) {
			
			// Create two bags of the integers [1, n]. Bag 'one' has all numbers
			// while bag two has odd numbers only.
			// Add the numbers in REVERSE ORDER otherwise this will take a LOOOOONG time.
			UniqueBag<Integer> one = new UniqueBag<Integer>();
			UniqueBag<Integer> two = new UniqueBag<Integer>();
			for (int k = n; k >=1; k--) {
				one.add(k);
				if (k % 2 == 1) { two.add(k); }
			}
			
			// at this point you can benchmark some operations:
			// size, identical, add, toArray, contains, remove, intersects, union
			// use StopWatch as you did before.
			
			//size
			Stopwatch stopwatch_one = new Stopwatch();
			one.size();
			double time_one = stopwatch_one.elapsedTime();
			//System.out.println(time_one);
			
			//identical
			StopwatchCPU stopwatch_one1 = new StopwatchCPU();
			one.identical(two);
			double time_identical = stopwatch_one1.elapsedTime();
			//System.out.println(time_identical);
			
			//add
			StopwatchCPU stopwatchone2 = new StopwatchCPU();
			one.add(n+1);
			double timeaddone = stopwatchone2.elapsedTime();
			//System.out.println(timeaddone);
			
			//toArray
			StopwatchCPU stopwatch_one3 = new StopwatchCPU();
			one.toArray();
			double toarrayone = stopwatch_one3.elapsedTime();
			//System.out.println(toarrayone);
			
			//contains
			StopwatchCPU stopwatch_one4 = new StopwatchCPU();
			one.contains(3);
			double contains_one = stopwatch_one4.elapsedTime();
			//System.out.println(contains_one);
			
			//remove
			StopwatchCPU stopwatch_one5 = new StopwatchCPU();
			one.remove(4);
			double remove_one = stopwatch_one5.elapsedTime();
			//System.out.println(remove_one);
			
			//intersects
			StopwatchCPU stopwatch6 = new StopwatchCPU();
			one.intersects(two);
			double intersects = stopwatch6.elapsedTime();
			//System.out.println(intersects);
			
			//union
			StopwatchCPU union = new StopwatchCPU();
			one.union(two);
			double union_time = union.elapsedTime();
			//System.out.println(union_time);
			
			StdOut.println(time_one + 
					"\t" + time_identical + 
					"\t\t" + timeaddone + 
					"\t\t" + toarrayone +
					"\t\t" + contains_one +
					"\t\t" + remove_one +
					"\t\t" + intersects +
					"\t\t" + union_time);
		}
	}
}
