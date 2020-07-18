import java.lang.Math;

public class KdTree {
	public static Point root;
	public KdTree(double x, double y) {
		root = new Point(x,y);
		root.color = true;
	}
	public static void insert(Point p) {
		root = insert(root, p.x, p.y, root.color);
	}
	private static Point insert(Point P, double x, double y, boolean color) {
		if(P == null) return new Point(x,y,color);
		if(color == true) {
			if(x < P.x) P.left = insert(P.left,x,y,!P.color);
			else if(x > P.x) P.right = insert(P.right,x,y,!P.color);
			else {
				P.x = x;
				P.y = y;
				P.color = color;
			}
		}
		else {
			if(y < P.y) P.left = insert(P.left,x,y,!P.color);
                        else if(y > P.y) P.right = insert(P.right,x,y,!P.color);
                        else {
                                P.x = x;
                                P.y = y;
                                P.color = color;
                        }
		}
		return P;
	}
	public static void traverse(Point x) {
		if(x == null) return;
                traverse(x.left);
		System.out.println(x.x);
		System.out.println(x.y);
                System.out.println(x.color);
                traverse(x.right);
	}
	public static void main(String[] args) {
		KdTree K = new KdTree(0.7,0.2);
		K.insert(new Point(0.5,0.4));
		K.insert(new Point(0.2,0.3));
		K.insert(new Point(0.4,0.7));
		K.insert(new Point(0.9,0.6));
		System.out.println(K.root.x + " " + K.root.y);
		K.traverse(root);
	}
}

class Point {
	double x,y;
	boolean color;
	Point left, right;
	public Point(double a, double b) {
		x = a;
		y = b;
	}
	public Point(double a, double b, boolean c) {
		x = a;
		y = b;
		color = c;
	}
}
