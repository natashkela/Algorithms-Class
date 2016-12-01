package nvacheishvili;

import edu.princeton.cs.algs4.In;

// skeletal structure for your HW5

public class Graph {
    
    final int V;
    int E;
    Bag<Integer>[] adj;
    
    /**
     * Initializes an empty graph with <tt>V</tt> vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  V number of vertices
     * @throws IllegalArgumentException if <tt>V</tt> < 0
     */
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /** Added this method for day20 to load graph from file. */
    public Graph (In in) {
    	this (in.readInt());
    	int E = in.readInt();
    	for (int i = 0; i < E; i++) {
    		int v = in.readInt();
    		int w = in.readInt();
    		addEdge (v,w);
    	}
    }

    public int V() { return V; }
    public int E() { return E; }


    /** Adds the undirected edge v-w to this graph. */
    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }


    /** Returns the vertices adjacent to vertex <tt>v</tt>. */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /** Returns the degree of vertex <tt>v</tt>. */
    public int degree(int v) {
        return adj[v].size();
    }

    /** Implement as part of HW5, Question 1. */
    public Graph complement() { 
    	Graph newGraph = completeGraph(V);
    	for(int i=0;i<V;i++){
    		for(int w:adj[i]){
    			newGraph.adj[i].remove(w);
    		}
    	}
    	newGraph.E=((V*(V-1))/2)-E;
    	return newGraph;
    }
    
    private Graph completeGraph(int V){
    	Graph newGraph = new Graph(V);
    	for (int i=0;i<V;i++){
    		for(int j=i+1;j<V;j++){
    			newGraph.addEdge(i,j);
    		}
    	}
    	return newGraph;
    }

    /** Implement as part of HW5, Question 1. */
    public boolean connected() { 
    	Bag<Integer> newBag = new Bag<Integer>();
    	if(connected(0,newBag).size == V){
    		return true;
    	}
    	else{
    	return false;
    	}
    }
    
    private Bag<Integer> connected(int v,Bag<Integer> visited){
    	 
    	for (int i : visited){//check if its visited
    		 if(v==i){
    			 return visited;
    		 }
    	 }
    	 visited.add(v);//if not add it
    	 for(int i : adj[v]){ 
    		 visited=connected(i,visited);
    	 }
    	 return visited;
    	 
    }
    
    /** Implement as part of HW5, Question 2. */
    public int status(int v) { 
    	Bag<Integer> newBag = new Bag<Integer>();
    	return status(v,0,newBag);
    }
    
    private int status(int v, int depth, Bag<Integer> visited){
    	for (int i : visited){//have we visited it?
    		if(i==v){
    			return 0;
    		}
    	}
    	//if not count
    	int status=depth;
    	for(int i : adj[v]){
    		status=status+status(i,depth+1,visited);
    	}
    	return status;
    }
    
    /** Implement as part of HW5, Question 2. */
    public boolean statusInjective() { 
    	int[] status = new int[V];
    	boolean statusInjective = true;
    	for(int i=0;i<V;i++){
    		status[i]=status(i);
    	}
    	for(int i=0;i<V-1;i++){
    		for(int j=i+1;j<V;j++){
    			if(status[i] == status[j]){
    				statusInjective=false;
    			}
    		}
    	}
    	return statusInjective;
    }
    
    /** Implement as part of HW5, Question 3. */
    public int findSafeVertex() { 
    	if(!connected()){
    		return -1;
    	}
    	Stack<Integer> visited = new Stack<Integer>();
    	boolean[] marked = new boolean[V];
    	for(int i=0;i<V;i++){
    		marked[i]=false;
    	}
    	vertex(0,visited,marked);
    	return visited.pop();
    }
    
    private void vertex(int v,Stack<Integer> visited,boolean[] marked){
    	visited.push(v);
    	for(int i: adj(v)){
    		if(!marked[i]){
    			marked[i]=true;
    			vertex(i,visited,marked);
    		}
    	}
    }

    /** Implement as part of HW5, Question 3. */
    public int diameter() {
    	if(!connected()){
    		return -1;
    	}
    	int diameter=-1;
    	for(int i=0;i<V;i++){
    		for(int j=i;j<V;j++){
    			int ecc = dist(i,j,i,0,Integer.MAX_VALUE,new Bag<Integer>());
    			if(diameter<ecc){
    				diameter=ecc;
    			}
    		}
    	}
    	return diameter;
    }
    
    private int dist(int i,int j, int v, int depth, int dist, Bag<Integer> visited){
    	if(depth<dist&&v==i){
    		dist=depth;
    		return dist;
    	}
    	for(int a:visited){
    		if(v==a){
    			return dist;
    		}
    	}
    	visited.add(v);
    	depth++;
    	for(int a:adj[v]){
    		dist=dist(i,j,a,depth+1,dist,visited);
    	}
    	return dist;
    }
    
    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
