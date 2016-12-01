package nvacheishvili;

import edu.princeton.cs.algs4.*;

// For HW4 you are asked to compare the number of comparisons made during 
// successive calls to 'deleteMax'. Note that in a MaxPQ there are also
// exchange operations, which do not occur in a BST; however, these are
// always fewer than the number of comparisons (as you can see from p. 316). 
public class CompareBSTandHeap {
	static Double[] generateData(int n) {
		Double[] vals = new Double[n];
		for (int i = 0; i < n; i++) {
			vals[i] = StdRandom.uniform();
		}
		return vals;
	}

	public static void main(String[] args) {
		
		float T = 512;   // run 512 trials

		StdOut.println("N\tRatio");
		for (int n = 4; n <= 65536; n*= 2) {
			
			// maximum ratio for the #of comparisons used by MaxPQ / #comparisons used by BST
			float maxRatio = 0;
			
			for (int t = 0; t <= T; t++) {
				MaxPQ<Double> mpq = new MaxPQ<Double>(n);
				BST<Double> bst = new BST<Double>();
				mpq.inspectedElementCount=0;
				bst.ElementInspection=0;
				Double[] data = generateData(n);
				for (double d : data) {
					mpq.insert(d);
					bst.insert(d);
				}

				// ready for the trial to start. You need to modify this code to repeatedly remove
				// the maximum value from each structure (one from the heap and one from the BST).
				// You must check that the same value is being retrieved from both for correctness.
				// note that you can only do this by first requesting the max() value from the BST.
				// Only count the number of comparisons within your delMax function.
				for(int i=0;i<data.length;i++){
					if(mpq.delMax().equals(bst.max())){
						bst.deleteMax();
					}
					else{
						System.out.println("They are not the same");
					}
				}
				float currentRatio = (float)mpq.inspectedElementCount/(float)bst.ElementInspection;
				if(maxRatio<currentRatio){
					maxRatio=currentRatio;
				}
			}
			System.out.println(n + "\t" + maxRatio);
		}
	}
}
