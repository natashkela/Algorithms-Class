package nvacheishvili.hw2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Proper Merge Sort from Sedgewick, 4ed
public class MergeSortThreeWay {
	static Comparable aux[];
	
    public static void sort(Comparable[] a) {
    	aux = new Comparable[a.length];
    	sort (a, 0, a.length-1);
    }
    
    // recursive helper function
    static void sort (Comparable[] a, int lo, int hi) {
    	if (hi <= lo) return;
    	
    	int left = lo + (hi-lo)/3;
    	int right = lo + 2*(hi-lo)/3;
    	
    	sort(a, lo, left);
    	sort(a, left+1, right);
    	sort (a, right+1,hi);
    	merge(a, lo, left, right, hi);
    }
    
    // merge sorted results a[lo..mid] with a[mid+1..hi] back into a
    static void merge (Comparable[] a, int lo, int left, int right, int hi) {
    	int i = lo;     // starting index into left sorted sub-array
    	int j = left+1;
    	int z = right+1;// starting index into right sorted sub-array
    	
    	// copy a[lo..hi] into aux[lo..hi]
    	for (int k = lo; k <= hi; k++) {
    		aux[k] = a[k];
    	}
    	//int min;
    	//int k =0;
    	// now comes the merge. Something you might simulate with flashcards
    	// drawn from two stack piles. This is the heart of mergesort. 
    	/*for (int k = lo; k <= hi; k++) {
    		/*if       (i > mid)               { a[k] = aux[j++]; }
    		else if  (j > hi)                { a[k] = aux[i++]; } 			<-------- For two way merge
    		else if  (less(aux[j], aux[i]))  { a[k] = aux[j++]; }
    		else                             { a[k] = aux[i++]; }*/
    	/*while(!((i==left)&&(j==right)&&(z==hi))){	
	    	if(less(a[i],a[j])&&less(a[i],a[z])){
	    			a[k] = a[i];
	    		}
	    	else if(less(a[j],a[i])&&less(a[j],a[z])){
	    			a[k]=a[j];
	    	}												<---------- Too much work try other thing
	    	else{
	    		a[k]=a[z];
	    	}
	    	k++;
    	}*/
    	/*for (int k = lo; k <= hi; k++) {
		if       (i > left)               { a[k] = aux[j++]; 
			//should have less statement here and compare j and z in array and increment j, else z
		}
		else if  (z > hi)                { a[k] = aux[j++]; }
		else if  (j > right)             { a[k] = aux[z++]; 
			//should have less statement here and compare i and z and increment i,else z
		}
		else if  (z > hi)                { a[k] = aux[i++]; 		<----- Should work but doesn't, try rewriting it
			//shuld have less statement here and compare i and j, increment i, else j
		}
		
		// NEED TO HAVE ANOTHER ELSE IS STATEMENTS WITH DOUBLE LESS &&ing 
		else if  (less(aux[j], aux[i]))  { a[k] = aux[j++]; }
		else                             { a[k] = aux[i++]; }*/
    	for (int k = lo; k <= hi; k++) {
			
	    		if (i > left && z > hi) {
					a[k] = aux[j++];
					}
	    		
	    		else if (i > left && j > right) {
					a[k] = aux[z++];
					}
				
				else if (j > right && z > hi) {
					a[k] = aux[i++];
					}
	    		
				else if (i > left) {
					
					if (less(aux[j], aux[z])) {
						a[k] = aux[j++];
						}
					
					else { 
						a[k] = aux[z++]; 
					}
				}
				
				else if (j > right) {
					if (less(aux[i], aux[z])){ 
						a[k] = aux[i++];
					}
					else {
						a[k] = aux[z++]; 
					}
				}
				
				else if (z > hi) {
					if (less(aux[i], aux[j])) {
						a[k] = aux[i++];
					}
					else a[k] = aux[j++]; 
				}
				
				else if (less(aux[i], aux[j])&&
						 less(aux[i], aux[z])) {
					a[k] = aux[i++];
					}
				else if (less(aux[j], aux[i])&&
						less(aux[j], aux[z])){
					a[k] = aux[j++];
					}
				else if (less(aux[z], aux[i])&&
						 less(aux[z], aux[j])){
					a[k] = aux[z++];
					}
			}
    }
    

   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    // print array to standard output a[lo..hi]
    private static void show(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            StdOut.println (a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; selection sorts them; 
     * and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
        String[] a = {"a","b","d","c","g","f","e"};
    	//String[] a = StdIn.readAllStrings();
        MergeSortThreeWay.sort(a);
        show(a, 0, a.length-1);
    }
}