import java.lang.Math;

public class graph {
	public static void main(String[] args) {}
}

class Graph {
	final int V;
	public Stack<Integer>[] A;
	public boolean[] marked;
	public int[] edgeTo;
	public int[] distTo;

	public Graph(int V) {
		this.V = V;
		A = (Stack<Integer>[]) new Object[V];
		marked = new boolean[V];
		edgeTo = new int[V];
		distTo = new int[V];
		for(int x = 0; x < V; x++) marked[x] = false;
	}
	
	public void dfs(Graph G, int v) {
		Stack<Integer> S = new Stack<Integer>();
		S.push(Integer.valueOf(v));
		while(!S.isEmpty()) {
			int a = S.pop().intValue();
			Integer[] i = A[a].getArray();
			for(Integer u : i) {
				if(marked[u.intValue()] == false) {
					S.push(u);
					marked[u.intValue()] = true;
					edgeTo[u.intValue()] = a;
				}
			}
		}
	}
	
	public void bfs(Graph G, int v) {
		int count = 0;
		Queue<Integer> Q = new Queue<Integer>();
		Q.enqueue(Integer.valueOf(v));
		while(!Q.isEmpty()) {
			int a = Q.dequeue().intValue();
			Integer[] i = A[a].getArray();
			for(Integer u : i) {
				if(marked[u.intValue()] == false) {
					Q.enqueue(u);
					marked[u.intValue()] = true;
					edgeTo[u.intValue()] = a;
				}
			}
		}
	}
}

class UndirectedGraph extends Graph {
	public UndirectedGraph(int V) {
		super(V);
	}
	public void addEdge(int v, int w) {
		A[v].push(Integer.valueOf(w));
		A[w].push(Integer.valueOf(v));
	}
}

class DirectedGraph extends Graph {
	public DirectedGraph(int V) {
		super(V);
	}
	public void addEdge(int v, int w) {
		A[v].push(Integer.valueOf(w));
	}
}
