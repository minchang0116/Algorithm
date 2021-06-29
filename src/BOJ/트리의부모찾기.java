package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	
	static int parents[];
	static boolean check[];
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		check = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		check[1] = true;
//		dfs(1);
		bfs();
		for(int i=2; i<=N; i++) {
			System.out.println(parents[i]);
		}
		
	}
	private static void dfs(int n) {
		for(int i: list[n]) {
			if(check[i] == false) {
				check[i] = true;
				parents[i] = n;
				dfs(i);
			}
		}
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i: list[cur]) {
				if(check[i] == false) {
					check[i] = true;
					parents[i] = cur;
					q.offer(i);
				}
			}
		}
	}
}
