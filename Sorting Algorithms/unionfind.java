import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class unionfind {
	public static void main(String[] args) {
		
	}
}

abstract class uf {
	public abstract void union(int p, int q);
	public abstract boolean connected(int p , int q);
}

class quickfind extends uf {
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

class quickunion extends uf {
	private int[] id;
	public quickunion(int N) {
		id = new int[N];
		for(int i = 0; i < N; i++) id[i] = i;
	}
	private int root(int i) {
		while(i != id[i]) i = id[i];
		return i;
	}
	public boolean connected(int p, int q) {
		return root(q) == root(p);
	}
	public void union(int child, int parent) {
		id[root(child)] = root(parent);
	}
}

