package nvacheishvili.hw3;

public class ValueSameIndex {
	/** 
	 * Given index values, lo and hi, which are inclusive to the array, a,
	 * return index such that a[idx] = idx.
	 * 
	 * If no such index exists, then return -1.
	 */
	public static int index (int[] a, int lo, int hi) {
		// fill in your code here
		while(lo<=hi){
			int mid = lo+(hi-lo)/2;
			if(a[mid]<mid){
				hi=mid-1;
			}
			else if(a[mid]>mid){
				lo=mid+1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {-3, -1, 0, 4, 5, 9, 10};
		System.out.println(index(a,0,6));
		int[] b = {-3, -1, 0, 3, 5, 9, 10};
		System.out.println(index(b,0,6));
		int[] c = {0};
		System.out.println(index(c,0,0));
		int[] d = {-3, -1, 0, 4, 5, 9, 10,7};
		System.out.println(index(d,0,7));
	}
}
