package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최장경로 {
	
	static boolean visited[];
	static int grid[][];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			grid = new int [N+1][N+1]; // 정점이 1개면 1부터 시작 
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				grid[a][b] = 1;
				grid[b][a] = 1;
			}
			
			answer = 0;
			for(int i=1; i<N+1; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}
	
	static int answer;
	
	private static void dfs(int i, int count) {
		if(answer < count) answer = count;
		for(int j=1; j<N+1; j++) {
			if(grid[i][j] == 1 && visited[j] == false) {
				visited[j] = true;
				dfs(j, count+1);
				visited[j] = false;
			}
		}
	}
}
