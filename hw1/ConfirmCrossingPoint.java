package nvacheishvili.hw1;


public class ConfirmCrossingPoint {
	
	// change this to be a 5x7 array that confirms the maximum number
	// of array locations to be investigated. 
	public static void main(String[] args) {
		
		// CHANGE THIS
		boolean [][] ar =  {
				{ true, false, false, false, false, false, false },
				{ true, false, false, false, false, false, false },
				{ true, false, false, false, false, false, false },
				{ true, false, false, false, false, false, false },
				{ true,  true,  true,  true,  false, true,  true },
		};
		
		boolean [][] array = {
				{false, false, false, false, true, false},
				{false, false, false, false, true, false},
				{false, false, false, false, true, false},
				{true, true, true, true, true, true},
		};
		
		boolean[][] ar1 = {
				{true, true, true, true},
				{false, false, true, false},
				{false, false, true, false},
		};
		
		// confirm
		new CrossingPoint().locate(ar);
		new CrossingPoint().locate(array);
		new CrossingPoint().locate(ar1);
		 
	}
}
