package BOJ.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main11724 {
	static int graph[][] = new int[1001][1001];
	static boolean check[] = new boolean[1001];
	static int N, M;

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = true;
		while (!q.isEmpty()) {
			int current = q.poll();
			for (int i = 1; i <= N; i++) {
				if (graph[current][i] == 0)
					continue;
				if (check[i] == false) {
					check[i] = true;
					q.add(i);
				}
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (check[i] == false) {
				bfs(i);
				result++;
			}
		}
		System.out.println(result);

	}

}
