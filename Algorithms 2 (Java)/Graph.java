import java.lang.Math;

public class Graph {
	public static void main(String[] args) {}
}

class UndirectedGraph {
	final int V;
	public Stack<Integer>[] A;
	public boolean[] marked = new boolean[V];
	public int[] edgeTo = new int[V];

	public UndirectedGraph(int V) {
		this.V = V;
		A = (Stack<Integer>[]) new Object[V];
		for(int x = 0; x < V; x++) marked[x] = false;
	}
	public void addEdge(int v, int w) {
		A[v].push(Integer.valueOf(w));
		A[w].push(Integer.valueOf(v));
	}
	public void dfs(UndirectedGraph G, int v) {
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
	public void bfs(UndirectedGraph G, int v) {
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


