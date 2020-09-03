import java.lang.Math;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class milkpumping {
	public static void main(String[] args) {
        try {
			File in, out;
			Scanner I, O;
			String line = "";
			String[] val;
			int N, M;
			int to, from;
			int ratio, answer;
			FlowNetwork F;

			for(int file = 1; file <= 10; file++) {
	            in = new File("../pump/" + file + ".in");
				out = new File("../pump/" + file + ".out");
				I = new Scanner(in);
				O = new Scanner(out);
				line = "";
				line = I.nextLine();
				val = line.split(" ");
				N = Integer.parseInt(val[0]);
				M = Integer.parseInt(val[1]);
				F = new FlowNetwork(N);
				while(I.hasNextLine()) {
					line = I.nextLine();
					val = line.split(" ");
					to = Math.max(Integer.parseInt(val[0]), Integer.parseInt(val[1]));
					from = Math.min(Integer.parseInt(val[0]), Integer.parseInt(val[1]));
					F.addDirectedEdge(from, to, Integer.parseInt(val[2]), Integer.parseInt(val[3]));
				}
				F.dij(1);
				ratio = (int)(1000000 * ((double)(F.flowTo[N]) / (double)(F.cost[N])));
				answer = Integer.parseInt(O.nextLine());
				System.out.println(answer == ratio);
			}
        }
		catch(Exception e) { e.printStackTrace(); }
    }
}

class FlowNetwork {
	public final int V;
	public Stack<Pipe>[] F;
	public int[] cost;
	public int[] flowTo;
	public boolean[] visited;

	public FlowNetwork(int V) {
		this.V = V+1;
		cost = new int[V+1];
		flowTo = new int[V+1];
		visited = new boolean[V+1];
		F = (Stack<Pipe>[]) new Stack[V+1];
		for(int x = 1; x < V+1; x++) F[x] = new Stack<Pipe>();
	}
	public void addUndirectedEdge(int v, int w, int cost, int flow) {
		Pipe E = new Pipe(v,w,flow,cost);
		F[v].push(E);
		F[w].push(E);
	}
	public void addDirectedEdge(int v, int w, int cost, int flow) {
		Pipe E = new Pipe(v,w,flow,cost);
		F[v].push(E);
	}
	public void print() {
		Pipe P;
		Object[] i;
		for(int x = 1; x < F.length; x++) {
			i = F[x].getArray();
			for(Object O : i) {
				P = (Pipe) O;
				System.out.println(P.from() + " " + P.to());
			}
		}
	}
	public double getRatio(int[] f, int[] c, Pipe p) {
		int cost = p.getCost() + c[p.from()];
		int min_flow;
		if(p.from() == 1) min_flow = p.getFlow();
		else min_flow = Math.min(p.getFlow(), f[p.from()]);
		if(min_flow == 0) return 0;
		return (double)(min_flow) / (double)(cost);
	}
	public void dij(int source) {
		int heap_size = 0;
		double percent = 100;

		for(int x = 1, size = 0; x < V; x++) {
			size = F[x].getSize();
			if(size > 1) heap_size = Math.max(heap_size, size);
			flowTo[x] = 0;
			cost[x] = 0;
			visited[x] = false;
		}

		if(heap_size == 0) heap_size = 1;
		heap_size = V;
		System.out.println("\nheap_size = " + heap_size);
		percent = (double)(V - heap_size);
		percent = percent / (double)(V);
		percent *= 100;
		percent = (double)((int)percent);
		System.out.println("Saved " + percent + "% of space");

		BinaryHeap B = new BinaryHeap(heap_size);
		B.insert(source);
		while(!B.isEmpty()) {
			int v = B.deleteMin();
			visited[v] = true;
			Object[] i = F[v].getArray2();
			Pipe p;
			for(int x = 0; x < i.length && i[x] != null; x++) {
				p = (Pipe) i[x];
				int a = p.from(), b = p.to();
				double current, next;
				current = flowTo[b];
				if(current != 0) current = (double)(flowTo[b]) / (double)(cost[b]);
				current *= 1000000;
				next = getRatio(flowTo, cost, p);
				next *= 1000000;
				if(next > current) {
					cost[b] = p.getCost() + cost[a];
					flowTo[b] = Math.min(p.getFlow(), flowTo[a]);
					if(a == 1) flowTo[b] = p.getFlow();
					if(!visited[b]) B.insert(b);
				}
			}
		}
	}
}

class Pipe {
	private int a, b, flow, cost;

	public Pipe(int Q, int W, int F, int C) {
		a = Q;
		b = W;
		flow = F;
		cost = C;
	}
	public int from() { return a; }
	public int to() { return b; }
	public int getFlow() { return flow; }
	public int getCost() { return cost; }
}
