package nvacheishvili;

public class Test {
	public static void main(String[] args){
				//complement
				Graph emptyGraph = new Graph(5);
				System.out.println(emptyGraph.toString());
				System.out.println(emptyGraph.complement().toString());
				//connected
				Graph five = new Graph(5);
				five.addEdge(0, 1); 
				five.addEdge(1, 2);
				five.addEdge(2, 3);
				five.addEdge(3, 4);
				System.out.println(five.toString());
				System.out.println(five.complement().toString());
				System.out.println(five.connected());//true
				System.out.println(five.complement().connected());//true
		
	}
}
