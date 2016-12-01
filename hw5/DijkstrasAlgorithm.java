package nvacheishvili;

// modify this for your solution.

public class DijkstrasAlgorithm {
	// TODO: The result of your computation is stored in these arrays.
	static double dist[];
	static int pred[];     // this is equivalent to edgeTo as discussed for DFS/BFS
	
	// conduct from this designated source vertex.
	public static void singleSourceShortestPath(DiGraphMatrix graph, int s) {
		dist=new double[graph.V];
		pred=new int[graph.V];
		boolean[] visited = new boolean[graph.V];
		for(int i=0;i<graph.V;i++){
			dist[i]=Integer.MAX_VALUE;
			pred[i]=-1;
			visited[i]=false;
		}
		boolean visitall=false;
		dist[s]=0;
		while(!visitall){
			int u=Integer.MAX_VALUE;
			for(int i=0;i<graph.V;i++){
				if(visited[i]==false&&dist[i]<u){
					u=i;
				}
			}
			if(dist[u]==Integer.MAX_VALUE){
				return;
			}
			visited[u]=true;
			for(DirectedEdge i: graph.adj(u)){
				double w = i.weight;
				double newLen = dist[u]+w;
				if(newLen<dist[i.to()]){
					dist[i.to()]=newLen;
					pred[i.to()]=u;
				}
			}
			visitall=true;
			for(int i=0;i<graph.V;i++){
				if(!visited[i]&&dist[i]!=Integer.MAX_VALUE){
					visitall=false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		DiGraphMatrix example = new DiGraphMatrix(5);
		example.addEdge(0, 1, 2);
		example.addEdge(0, 4, 4);
		example.addEdge(1, 2, 3);
		example.addEdge(2, 4, 1);
		example.addEdge(2, 3, 5);
		example.addEdge(3, 0, 8);
		example.addEdge(4, 3, 7);
		singleSourceShortestPath(example,0);
		for(int i=0;i<example.V;i++){
			System.out.println(dist[i]+" ");
		}
		
	}
}
