package BOJ.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1707 {

	static int graph[][] = new int[20001][20001];
	static int check[] = new int[20001];
	static int N, M;
	static int T;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=1; t<=T; t++) {
		N = sc.nextInt();
		M = sc.nextInt();
		int a, b;
		
		for (int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		int f=1;
		check[1] = f;
		int flag = 0;
		outer: while (!q.isEmpty()) {
			int current = q.poll();
			for (int i = 1; i <= N; i++) {
				// 연결안되있으면 다음
				if (graph[current][i] == 0)
					continue;
				// 연결되있고 아직 방문안했으면
				if (check[i] == 0) {
					check[i] = check[current]*-1;
					q.add(i);
				}
				else if(check[i] == check[current]) {
					flag = 1;
					break outer;
				}
			}
		}
		if(flag == 1) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}
		
		}
	}
}
