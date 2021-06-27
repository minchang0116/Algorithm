package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길 {
	static int M, N;
	static int map[][];
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		notGoal = new boolean[M][N];
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		visited[0][0] = true;
		dp[M - 1][N - 1] = 1;
		dfs(0, 0);
		System.out.println(dp[0][0]);

	}

	// 끝까지 탐색헀는데 목표지점까지 못 간 노드들은 탐색할 필요가 없다.
	static int dp[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static boolean visited[][];
	static boolean notGoal[][];
	
	private static int dfs(int x, int y) {
		if(notGoal[x][y] == true) {
			return 0;
		}
		if (x == M - 1 && y == N - 1) {
			cnt++;
			return dp[x][y];
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny] == true || map[nx][ny] >= map[x][y])
				continue;
			if(dp[nx][ny] > 0) {
				dp[x][y] += dp[nx][ny];
			}
			else{
				visited[nx][ny] = true;
				dp[x][y] += dfs(nx, ny);
				visited[nx][ny] = false;
			}
		}
		if(dp[x][y] == 0) { //0인채로 끝나면 해당 경로는 목표지점에 도달하지 못하는 경로이다.
			notGoal[x][y] = true;
		}
		return dp[x][y];
	}
}
