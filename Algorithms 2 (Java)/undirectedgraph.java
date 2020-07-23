import java.lang.Math;

public class undirectedgraph {
	public static void main(String[] args) {
	
	}
}

class Graph {
	final int V;
	public Stack<Integer>[] A;
	public boolean[] marked = new boolean[V];
	public int[] edgeTo = new int[V];

	public Graph(int V) {
		this.V = V;
		A = (Stack<Integer>[]) new Object[V];
		for(int x = 0; x < V; x++) marked[x] = false;
	}
	public void addEdge(int v, int w) {
		A[v].push(Integer.valueOf(w));
		A[w].push(Integer.valueOf(v));
	}
	public void dfs(Graph G, int v) {
		Stack<Integer> S = new Stack<Integer>();
		S.push(Integer.valueOf(v));
		while(!S.isEmpty()) {
			int v = S.pop().intValue();
			for(Integer u : A[v]) {
				if(marked[u.intValue()] == false) {
					S.push(u);
					marked[u.intValue()] = true;
					edgeTo[u.intValue()] = v;
				}
			}
		}
	}
	public void bfs(Graph G, int v) {
		//Same implementation as DFS but with Queue
	}
}


