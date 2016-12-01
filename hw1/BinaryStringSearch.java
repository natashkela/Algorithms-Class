package nvacheishvili.hw1;

import edu.princeton.cs.algs4.StdOut;

public class BinaryStringSearch {
	
	final int K;
	final String tokens;
	public static int counter=0;
	/**
	 * Construct search structure.
	 * @param initial
	 * @param K
	 */
	public BinaryStringSearch(String initial, int K) {
		this.K = K;
		this.tokens = initial;
	}
	
	
	/**
	 * Modify this code to return the rank of the token within the tokens string
	 * if it exists, otherwise return -1.
	 * 
	 * note that rank is to be a number from 0 up to and including N-1 where N
	 * is the number of tokens in the string.
	 * 
	 * Take inspiration from the cod on page 47 of the text.
	 * @param token   a string of exactly K characters
	 * @return    -1 if token does not exist in tokens string, otherwise rank of that
	 *            token in our tokens string
	 */
	public int rank (String token) {
		// your code here
		int low = 0;
		int high = ((this.tokens.length()+1)/(K+1))*(K+1)-1-1;//length-1
		while (low<=high){
			int mid = low + (high-low)/(2*(K+1));//token
			int middleIndex=mid*(K+1);//index
			//System.out.println(target.substring(middleIndex,middleIndex+K));
			//System.out.println(middleIndex);
			//token.compareTo(target.substring(middleIndex,middleIndex+K))<0)
			String sub = tokens.substring(middleIndex,middleIndex+K);
			//StdOut.println(sub+","+counter);
			int equals=isEqual(token,sub);
			if(equals<0){
				high = mid - 1;
			}
			//token.compareTo(target.substring(middleIndex,middleIndex+K))>0)
			else if(equals>0){
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int isEqual(String token,String middle){
		for(int i=0;i<token.length();i++){
			counter++;
			if(token.charAt(i)<middle.charAt(i)){
				return -1;
			}
			else if(token.charAt(i)>middle.charAt(i)){
				return 1;
			}
		}
		return 0;
		
	}
	
	
	// sample driver for your code.
	public static void main(String[] args) {
		String target = "ant apt awl box boy car cat dog man nap pot try you";
		int k = 3;
		//int N=(target.length()+1)/(k+1); //number of tokens
		String token = "car";
		BinaryStringSearch string = new BinaryStringSearch(target,k);
		int ranking = string.rank(token);
		if(ranking<0){
			System.out.println("We did not find it");
		}
		else {
			System.out.println(ranking);
			System.out.println("Number of Comparisons were: ");
			System.out.print(counter);
		}
	
		// insert statements to validate you can look for tokens that are present
		// as well as tokens that are not present.
		
	}
}
