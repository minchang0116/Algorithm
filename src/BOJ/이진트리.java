package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진트리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()), null, null);
		while(true) {
			try {
				int input = Integer.parseInt(br.readLine());
				insertNode(root, input);
			}catch(Exception e) {
				break;
			}
		}
		postOrder(root);
	}
	
	private static void postOrder(Node root) {
		if(root.left != null)
			postOrder(root.left);
		if(root.right != null)
			postOrder(root.right);
		System.out.println(root.num);
	}

	private static void insertNode(Node cur, int input) {
		if(cur.num > input) {
			if(cur.left == null) {
				cur.left = new Node(input);
			}
			else {
				insertNode(cur.left, input);
			}
		}
		else {
			if(cur.right == null) {
				cur.right = new Node(input);
			}
			else {
				insertNode(cur.right, input);
			}
		}
	}

	private static class Node{
		int num;
		Node left;
		Node right;
		
		public Node(int num) {
			super();
			this.num = num;
		}
		public Node(int num, Node left, Node right) {
			super();
			this.num = num;
			this.left = left;
			this.right = right;
		}
		
	}
}
