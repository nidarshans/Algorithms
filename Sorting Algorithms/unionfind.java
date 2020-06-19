import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class unionfind {
	public static void main(String[] args) {
		
	}
}

abstract class UF {
	public abstract void union(int p, int q);
	public abstract boolean connected(int p , int q);
}

class QuickFind extends UF {
	private int[] id;
	public quickfind(int N) {
		id = new int[N];
		for(int x = 0; x < N; x++) {
			id[x] = x;
		}	
	}
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i < id.length; i++) {
			if(id[i] == pid) id[i] = qid;
		}
	}
}

class QuickUnion extends UF {
	private int[] id;
	private int[] size;
	public quickunion(int N) {
		id = new int[N];
		size = new int[N];
		for(int i = 0; i < N; i++) {
		       	id[i] = i;
			size[i] = 1;
		}
	}
	private int root(int i) {
		while(i != id[i]) {
			/* Path compression: 
			 * id[i] = id[id[i]]; */
			i = id[i];
		return i;
	}
	public boolean connected(int p, int q) {
		return root(q) == root(p);
	}
	public void union(int p, int q) {
		int a = root(p);
		int b = root(q);
		/* weighted quick-union: attaches the smaller tree to the bigger
		 * tree. The max number of nodes to the botton node is given
		 * by log base 2 N, where N is the total # of nodes */
		if(a == b) return;
		if(size[a] < size[b]) {
			id[a] = b;
			size[b] += size[a];
		}
		else {
			id[b] = a;
			size[a] += size[b];
		}
	}
}

