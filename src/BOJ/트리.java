package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Node tree[] = new Node[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new Node();
		}

		int rootNode = 0;
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (value == -1) {
				rootNode = i;
			} else {
				tree[value].child.add(i);
			}

		}
		answer = 0;
		int removeNum = Integer.parseInt(br.readLine());
		if (rootNode == removeNum) {
			System.out.println(0);
		} else {
			removeDfs(rootNode, tree, removeNum);
			dfs(rootNode, tree, removeNum);
			System.out.println(answer);

		}
	}

	private static void removeDfs(int curNum, Node[] tree, int removeNum) {
		for (int i = 0; i < tree[curNum].child.size(); i++) {
			if (tree[curNum].child.get(i) == removeNum) {
				tree[curNum].child.remove(i);
				return;
			} else {
				removeDfs(tree[curNum].child.get(i), tree, removeNum);
			}
		}
	}

	static int answer;

	private static void dfs(int curNum, Node[] tree, int removeNum) {
		for (int i = 0; i < tree[curNum].child.size(); i++) {
			dfs(tree[curNum].child.get(i), tree, removeNum);
		}

		if (tree[curNum].child.isEmpty()) {
			answer++;
		}
	}

	static class Node {
		ArrayList<Integer> child = new ArrayList<Integer>();
	}
}
