import java.lang.Math;

public class graph {
	public static void main(String[] args) {
		UndirectedGraph M = new UndirectedGraph(6);
		M.addEdge(0,2);
		M.addEdge(0,5);
		M.addEdge(0,1);
		M.addEdge(1,2);
		M.addEdge(3,5);
		M.addEdge(3,2);
		M.addEdge(3,4);
		M.addEdge(2,4);
		M.bfs(0);
		for(int i : M.edgeTo) System.out.print(i + " ");
		/*
		for(Stack<Integer> s : M.A) {
			Object[] o = s.getArray();
			for(Object y : o) {
				Integer i = (Integer) y;
				System.out.print(i.intValue() + " ");
			}
			System.out.println();
		}
		*/
	}
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
