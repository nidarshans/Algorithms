package alg1;
import java.lang.Math;

public class BinaryTree {
	public Node root;
	private int N = 0;
	public BinaryTree(int r) {
		root = new Node(r);
		N++;
	}
	public BinaryTree(){}
	public void insert(int val) {
		root = insert(root, val);
		N++;
	}
	private Node insert(Node x, int val) {
		if(x == null) return new Node(val);
		if(val < x.data) x.left = insert(x.left, val);
		else if(val > x.data) x.right = insert(x.right, val);
		else x.data = val;

		//Following operations for Red-Black BST

		/*
		if(h.right.color && !h.left.color) h = rotateLeft(h);
		if(h.left.color && h.left.left.color) h = rotateRight(h);
		if(h.left.color && h.right.color) flipColors(h);
		*/

		return x;
	}
	public void traverse(Node x) {
		if(x == null) return;
		traverse(x.left);
		System.out.println(x.data);
		traverse(x.right);
	}

	//Functions below are for Red-Black BST

	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = true;
		return x;
	}
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = true;
		return x;
	}
	private void flipColors(Node h) {
		h.color = true;
		h.left.color = false;
		h.right.color = false;
	}
}

class Node {
	public int data;
	public Node left, right;
	public boolean color; //True for RED, False for BLACK
	public Node(int v) {
		data = v;
		left = right = null;
	}
}
