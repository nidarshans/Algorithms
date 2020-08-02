import java.lang.Math;

public class G {
	public static void main(String[] args) {}
}

class Graph {
	private final int V;
	public Stack<Integer>[] A;
	private boolean[] marked;
	public int[] edgeTo;
	public int[] distTo;
	public int[] cc;
	public int[] scc;
	private int count;

	public Graph(int V) {
		this.V = V;
		A = (Stack<Integer>[]) new Stack[V];
		marked = new boolean[V];
		edgeTo = new int[V];
		distTo = new int[V];
		count = 0;
		//cc = new int[V];
		//scc = new int[V];
		for(int x = 0; x < V; x++) {
			marked[x] = false;
			A[x] = new Stack<Integer>();
		}
	}

	public void dfs(int v) {
		Stack<Integer> S = new Stack<Integer>();
		S.push(Integer.valueOf(v));
		count = 0;
		marked[v] = true;
		while(!S.isEmpty()) {
			int a = S.pop().intValue();
			Object[] i = A[a].getArray();
			for(Object o : i) {
				Integer u = (Integer) o;
				if(marked[u.intValue()] == false) {
					S.push(u);
					marked[u.intValue()] = true;
					edgeTo[u.intValue()] = a;
					// cc[u.intValue()] = count; CC for UndirectedGraph
				}
			}
		}
	}

	public void bfs(int v) {
		Queue<Integer> Q = new Queue<Integer>();
		Q.enqueue(Integer.valueOf(v));
		marked[v] = true;
		count++;
		while(!Q.isEmpty()) {
			int a = Q.dequeue().intValue();
			Object[] i = A[a].getArray();
			for(Object o : i) {
				Integer u = (Integer) o;
				if(marked[u.intValue()] == false) {
					Q.enqueue(u);
					marked[u.intValue()] = true;
					edgeTo[u.intValue()] = a;
					distTo[u.intValue()] = count;
				}
			}
			count++; //For shortest path
		}
		count = 0; //Reset count
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

class EdgeWeightedGraph {
	public final int V;
	public Stack<Edge>[] EG;
	public int[] edgeTo;
	public double[] distTo;
	public boolean[] visited;

	public EdgeWeightedGraph(int V) {
		this.V = V;
		EG = (Stack<Edge>[]) new Stack[V];
		for(int x = 0; x < V; x++) EG[x] = new Stack<Edge>();
	}
	public void addUndirectedEdge(int v, int w, int weight) {
		Edge E = new Edge(v,w,weight);
		EG[v].push(E);
		EG[w].push(E);
	}
	public void addDirectedEdge(int v, int w, int weight) {
		Edge E = new Edge(v,w,weight);
		EG[v].push(E);
	}
	public void dij(int source) {
		edgeTo = new int[V];
		distTo = new double[V];
		visited = new boolean[V];
		BinaryHeap B = new BinaryHeap(V);
		for(int x = 0; x < V; x++) {
			distTo[x] = 9999;
			visited[x] = false;
		}
		distTo[source] = 0;
		B.insert(source);
		while(!B.isEmpty()) {
			int v = B.deleteMin();
			visited[v] = true;
			Object[] i = EG[v].getArray();
			Edge e;
			for(Object o : i) {
				e = (Edge) o;
				int a = e.from(), b = e.to();
				if(distTo[b] > distTo[a] + e.getWeight()) {
					distTo[b] = distTo[a] + e.getWeight();
					edgeTo[b] = a;
					if(!visited[b]) B.insert(b);
					else B.decreasePriority(b);
				}
			}
		}
	}
}

class Edge {
	private int a,b;
	private double weight;

	public Edge(int q, int w, double e) {
		a = q;
		b = w;
		weight = e;
	}
	public int from() { return a; }
	public int to() { return b; }
	public double getWeight() { return weight; }
	public int compare(Edge e) {
		if(weight < e.getWeight()) return -1;
		else if(weight > e.getWeight()) return 1;
		else return 0;
	}
}
