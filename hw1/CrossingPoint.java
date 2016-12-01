package nvacheishvili.hw1;

public class CrossingPoint {
	
	public int intercol=0;
	public int interrow=0;
	boolean rowflag = false;
	boolean colflag = false;
	public int counter =0;
	public void locate (boolean [][]ar) {
		int c=0; 
		boolean breakouter = false;
		for (int col=0; col<ar[0].length;col++){
				if(ar[0][0]==true&&ar[0][1]==true){
					interrow=0;
					rowflag=true;
					for(int i=0;i<ar[0].length;i++){
						counter++; //rows!!!
						if(ar[1][i]==true){
							intercol=i;
							colflag=true;
							if(rowflag==true&&colflag==true){
								breakouter = true;
								break;
							}
						}
					}
				}
				
				else if (ar[0][0]==true&&ar[0][1]==false){
					counter++;
					intercol=0;
					c=1;
					colflag=true;
					if (rowflag==true&&colflag==true){
						break;
					}
				}
				else if(ar[0][0]==false){
					counter++;
					if(ar[0][col]==true){
					intercol=col;
					colflag=true;
						if(rowflag==true&&colflag==true){
							break;
						}
					}
				}
				if(breakouter)
					break;
			}
		for (int row=0;row<ar.length;row++){
			counter++;
			if(ar[row][c]==true){
				interrow=row;
				rowflag=true;
			}
			if(rowflag==true&&colflag==true){
				breakouter = true;
				break;
			}
			if(breakouter)
				break;
		}
		
		System.out.print("Crossing Point: ");
		System.out.print(interrow);
		System.out.print(", ");
		System.out.println(intercol);
		System.out.print("Loops needed for this is: ");
		System.out.println(counter);
	}
		
	
	 public static void main(String[] args) {
		 boolean [][] ar = {
		 { false, false, false, false, true, false, false, false },
		 { false, false, false, false, true, false, false, false },
		 { true,  true,  true,  true,  true, true,  true,  true },
		 { false, false, false, false, true, false, false, false },
		 };
		 //CrossingPoint cp = new CrossingPoint();
		 //cp.locate(ar);
		 new CrossingPoint().locate(ar);
		 //System.out.println("Loops needed for calculation is: " + String.valueOf(cp.counter));
	 }
	     

}
