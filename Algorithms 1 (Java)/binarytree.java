import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class binarytree {
	public static void main(String[] args) {
		BinaryTree b = new BinaryTree(10);
		b.insert(20);
		b.insert(5);
		b.insert(22);
		b.insert(5);
		b.insert(1);
		b.traverse(b.root);
	}
}

class BinaryTree {
	public Node root;
	private int N = 1;
	public BinaryTree(int r) {
		root = new Node(r);
	}
	public void insert(int val) {
		root = insert(root, val);
	}
	private Node insert(Node x, int val) {
		if(x == null) return new Node(val);
		if(val < x.data) x.left = insert(x.left, val);
		else if(val > x.data) x.right = insert(x.right, val);
		else x.data = val;
		return x;
	}
	public void traverse(Node x) {
		if(x == null) return;
		traverse(x.left);
		System.out.println(x.data);
		traverse(x.right);
	}
}

class Node {
	public int data;
	public Node left, right;
	public Node(int v) {
		data = v;
		left = right = null;
	}
}

