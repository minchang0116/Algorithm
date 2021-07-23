package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int inDegree[] = new int[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> adj[] = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
		}
		
		for(int i=1; i<=N; i++) {
			for(int v : adj[i]) {
				inDegree[v]++;
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		StringBuilder result = new StringBuilder();
		for(int i=1; i<=N; i++) {
			if(q.isEmpty()) {
				return;
			}
			int cur = q.poll();
			result.append(cur).append(" ");
			
			for(int v : adj[cur]) {
				inDegree[v]--;
				if(inDegree[v] == 0) q.offer(v);
			}
		}
		System.out.println(result.toString());
	}
}
