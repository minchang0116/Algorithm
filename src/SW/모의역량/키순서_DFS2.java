package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서_DFS2 {

	static int N, M, adj[][], radj[][];
	static int cnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			adj = new int[N+1][N+1]; // 자신보다 큰 관계 저장
			radj = new int[N+1][N+1]; // 자신보다 작은 관계 저장
			StringTokenizer st = null;
			
			int i,j;
			for(int m=0; m<M; m++) {
				st= new StringTokenizer(in.readLine(), " ");
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				radj[j][i] = adj[i][j] = 1;
			}
			
			int answer = 0;
			for(int k=1; k<=N; k++) {
				cnt = 0;
				dfs(k, adj, new boolean[N+1]);
				dfs(k, radj, new boolean[N+1]);
				if(cnt == N-1) answer++;
			}
			System.out.println("#"+t+" "+answer);
			
		}
	}
	//자신보다 큰 학생 따라 탐색
	private static void dfs(int k, int[][] adj , boolean[] visited) { // 탐색의 출발 학생번호
		visited[k] = true;
		for(int i=1; i<=N; i++) {
			if(adj[k][i]==1 && !visited[i]) {
				cnt++;
				dfs(i, adj, visited);
			}
		}
	}

	

}
