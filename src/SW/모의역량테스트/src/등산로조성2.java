package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조성2 {
	static int N, K,answer;
	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new boolean[N][N];
			int maxHeight = 0;
			answer =0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, temp);
					map[i][j] = temp;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxHeight) {
						visit[i][j] = true;
						dfs(i, j, 1, false);
						visit[i][j] = false;
					}
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static boolean visit[][];
	private static void dfs(int r, int c, int length, boolean flag) {
		answer = Math.max(answer,length);
		for (int d = 0; d < 4; d++) {
			int nx = r + dx[d];
			int ny = c + dy[d];
			if(nx<0||nx>=N || ny<0||ny>=N ||visit[nx][ny] == true) {
				continue;
			}
			if(map[nx][ny] >= map[r][c]) { // 자기보다 높으면
				if(flag == false &&map[nx][ny] - map[r][c] +1<= K) { // 깎을수 있으면
					int temp = map[nx][ny];
					map[nx][ny] = map[r][c] -1;
					visit[nx][ny] = true;
					dfs(nx,ny,length+1, true);
					visit[nx][ny] = false;
					map[nx][ny] = temp;
				}
				else {
					continue;
				}
			}else { // 자기보다 낮으면
				visit[nx][ny] = true;
				dfs(nx,ny,length+1, flag);
				visit[nx][ny] = false;
			}
		}
	}
}
