package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ㅎㅎ
public class 키순서 {
	static int map[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = null;
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			map= new int[N+1][N+1];
			for(int i=0; i<M; i++) {
				st= new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
				map[b][a] = -1;
			}
			
			for(int i=1; i<=N; i++) {
				dfs(i, i,new boolean[N+1]);
			}
			
			int result =0;
			for(int i=1; i<=N; i++) {
				int sum = 0;
				for(int j=1; j<=N; j++) {
					if(map[i][j] != 0)
						sum++;
				}
				if(sum == N-1) {
					result++;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
	private static void dfs(int start, int a, boolean visited[]) {
		for(int b=1; b<=N; b++) {
			if(start==b) continue;
			if(map[a][b] == 1 && visited[b] == false) {
				visited[b] = true;
				map[start][b] = 1;
				map[b][start] = -1;
				dfs(start, b, visited);
			}
		}
	}
}
