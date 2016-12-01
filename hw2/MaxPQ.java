package nvacheishvili.hw2;

public class MaxPQ<Key extends Comparable<Key>>
{
	public int counter;
	private Key[] pq; // heap-ordered complete binary tree
	private int N = 0; // in pq[1..N] with pq[0] unused
	public MaxPQ(){
		pq = (Key[]) new Comparable[2];
	}
	private void resize(int max){
		Key[] temp = (Key[]) new Comparable[max];
		for(int i=0;i<N+1;i++){
			temp[i]=pq[i];
		}
		pq=temp;
	}
	/*public MaxPQ(int maxN){ 
		pq = (Key[]) new Comparable[maxN+1]; 
		}*/
	public void resetCounter() {
		counter=0;
	}
	public boolean isEmpty(){ 
		return N == 0; 
		}
	public int size(){ 
		return N; 
		}
	public void insert(Key v){
		pq[++N] = v;
		swim(N);
		if(N+1==pq.length){
			resize(2*pq.length);
		}
	}
	public Key delMax(){
		 Key max = pq[1]; // Retrieve max key from top.
		 exch(1, N--); // Exchange with last item.
		 pq[N+1] = null; // Avoid loitering.
		 if(N>0&&N==pq.length/4){
			 resize(pq.length/2);
		 }
		 sink(1); // Restore heap property.
		 return max;
	}
	private void swim(int k){
		while (k > 1 && less(k/2, k)){
			 exch(k/2, k);
			 k = k/2;
		}
	}
	
	private void sink(int k){
		while (2*k <= N){
			 int j = 2*k;
			 if (j < N && less(j, j+1)) j++;
			 if (!less(k, j)) break;
			 exch(k, j);
			 k = j;
		}
	}
	private boolean less(int i, int j){ 
		counter++;
		return pq[i].compareTo(pq[j]) < 0; 
		}
	private void exch(int i, int j){ 
		Key t = pq[i]; 
		pq[i] = pq[j]; 
		pq[j] = t; 
		}
}