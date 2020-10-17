package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 디저트카페 {
	static int N;
	static int map[][];
	static int dx[] = { 1,1,-1,-1}; // 오아, 왼아, 왼위, 오위
	static int dy[] = { 1,-1,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = -1;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited = new boolean[N][N];
					check = new boolean[101]; 
					visited[i][j] = true;
					check[map[i][j]] = true;
					sx = i;
					sy = j;
					dfs(i, j, 1, 0);
				}
			}
			System.out.println("#"+t+" "+ result);
		}
	}
	static int sx, sy, result;
	static boolean visited[][];
	static boolean check[];
	static void dfs(int x, int y, int cnt, int  d) {
		if(d == 4) {
			return;
		}
		int nx = x +dx[d];
		int ny= y +dy[d];
		if(nx <0 || nx >= N || ny <0 || ny >= N || visited[nx][ny] == true || check[map[nx][ny]] == true) {
			if(nx == sx && ny== sy) {
				result = Math.max(result, cnt);
			}
			return; // 더이상  갈수 없거나 시작점이면 종료
		}
		visited[nx][ny] = true;
		check[map[nx][ny]] = true;
		cnt++;
		dfs(nx, ny, cnt, d+1);
		dfs(nx, ny, cnt, d);
		visited[nx][ny] = false;
		check[map[nx][ny]] = false;
		
	}
}
