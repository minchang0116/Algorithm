package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서_DFS3 {

	static int N, M, adj[][];
	static int[] gtCnt, ltCnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(in.readLine()); // 학생수 : 정점수
			M = Integer.parseInt(in.readLine()); // 관계수 : 간선 수
			
			
			adj = new int[N+1][N+1];
			gtCnt = new int[N+1];
			ltCnt = new int[N+1];
			StringTokenizer st = null;
			
			int i,j;
			for(int m=0; m<M; m++) {
				st= new StringTokenizer(in.readLine(), " ");
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1;
			}
			
			
			int answer = 0;
			for(int k=1; k<=N; k++) {
				dfs(k, k, new boolean[N+1]);
			}
			for(int k=1; k<=N; k++) {
				if(gtCnt[k] + ltCnt[k] == N-1) answer++;
			}
			System.out.println("#"+t+" "+answer);
			
			
		}
	}
	// src보다 큰 학생 따라 탐색하며 src 자신이 누구보다 작은지도 함께 판단
	private static void dfs(int src, int cur, boolean[] visited) { // src: 출발 학생번호
		visited[cur] = true; // src < cur
		for(int i=1; i<=N; i++) {
			if(adj[cur][i]==1 && !visited[i]) { // src < cur < i
				gtCnt[src]++;
				ltCnt[i]++;
				dfs(src, i, visited);
			}
		}
	}
	

}
