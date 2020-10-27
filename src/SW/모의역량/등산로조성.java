package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조성 {
	static int N, K;
	static int map[][];
	static int dx[] = {0,-1,0,1};
	static int dy[] = {-1,0,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int max = 0;
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max , map[i][j]);
				}
			}
			
			result=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(max == map[i][j]) {
						visited = new boolean[N][N];
						visited[i][j] = true;
						dfs(i, j, 1, 1);
						visited[i][j] = false;
					}
				}
			}
			
			System.out.println("#"+t+" "+result);
			
		}
	}
	// 하 상 우 좌
	static int result;
	static boolean visited[][];
	static void dfs(int x, int y, int chance, int depth) {
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx >=N || ny <0 || ny>= N || visited[nx][ny] == true) {
				continue;
			}
			if(map[nx][ny]< map[x][y]) { // 자기보다 작으면
				visited[nx][ny] = true;
				dfs(nx, ny, chance, depth+1);
				visited[nx][ny] = false;
			}
			else if(map[nx][ny] >= map[x][y] && chance == 1 && (map[nx][ny]- K) < map[x][y]) { // 크지만 1번의 기회가 있고 K가 자기보다 작으면
				int temp = map[nx][ny];
				map[nx][ny] = map[x][y] -1;
				visited[nx][ny] = true;
				dfs(nx, ny, chance-1, depth+1);
				map[nx][ny] = temp;
				visited[nx][ny] = false;
			}
		}
		result = Math.max(result, depth);
	}
}
