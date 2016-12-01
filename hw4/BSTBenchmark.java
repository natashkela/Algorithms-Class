package nvacheishvili;

public class BSTBenchmark{
	// WHY IS THIS NOT WORKING?
	 //BST<Integer> binaryTree = new BST<Integer>();
	public static void main(String[] args) {
		for(int k=2; k<11; k++){
			Integer[] array = new Integer[(int)Math.pow(2,k)-1];
			for(int i=1;i<=Math.pow(2,k)-1;i++){
				array[i-1]=i;
			}
			BST<Integer> binaryTree = new BST<Integer>(array);
			System.out.println(array.length+"\t"+binaryTree.height());
		 }
		
	   } 
	
}
