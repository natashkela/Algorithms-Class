package nvacheishvili;

// Complete this implementation which represents a Directed Graph using
// an Adjacency Matrix.

public class DiGraphMatrix {
	final int V;
	int E;
	double[][] weights;
	
	public DiGraphMatrix (int V) {
		this.V = V;
		this.E = 0;
		weights = new double[V][V];
		for (int i=0;i<V;i++){
			for(int j=0;j<V;j++){
				weights[i][j]=-1;
			}
		}
	}
	
	public void addEdge (int source, int target, double weight) {
		weights[source][target]=weight;
	}
	
	
	/** Returns information about given directed edge, or null if doesn't exist. */
	public DirectedEdge getEdge (int source, int target) {
		if(weights[source][target]==-1){
			return null;
		}
		else{
			DirectedEdge newDE = new DirectedEdge(source,target,weights[source][target]);
			return newDE;
		}
	}
	
	public Iterable<DirectedEdge> adj(int v) {
		// Hint: You could create a Queue of DirectedEdges, populating it from the
		// specific row of the matrix 'weights' and then return that. 
		
		Queue<DirectedEdge> E = new Queue<DirectedEdge>();
		for(int i=0;i<V;i++){
			if(v!=i&&weights[v][i]!=-1){
				DirectedEdge newDE = new DirectedEdge(v,i,weights[v][i]);
				E.enqueue(newDE);
			}
		}
		return E;
	}
	
	// Don't Bother to implement reverse() as shown on p. 569
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (DirectedEdge e : adj(v)) {
                s.append(e.toString());
            }
            s.append("\n");
        }
        return s.toString();
    }
	
}
