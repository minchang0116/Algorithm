package SSAFY.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	
	static int N, M;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int preCheck = 0;
		int time =0;
		do {
			time++;
			visited = new boolean[N][M];
			dfs(0,0);
			preCheck = counting();
		}while(check());
		
		System.out.println(time);
		System.out.println(preCheck);
	}
	
	private static int counting() {
		int count=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) {
					count++;
					map[i][j] = 0;
				}
			}
		}
		return count;
	}

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean visited[][];
	private static void dfs(int x, int y) {
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] == true) continue;
			visited[nx][ny] = true;
			if(map[nx][ny] == 1) {
				map[nx][ny] = 2;
				continue;
			}
			dfs(nx, ny);
		}
	}
	private static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					return true;
				}
			}
		}
		return false;
	}
}
