package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 09:31 ~ 10:16
public class 파핑파핑_1868 {
	
	static int N;
	static char map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			// 0이면 주변 8방향에 숫자표시
			// 모두 표시후 0을 제외한 숫자 카운트 0이 있으면 1번만 더해줌
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if(map[i][j] == '.') {
						dfs(i, j);
					}
				}
			}
			
			int answer =0;
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if(map[i][j] == '0' && visited[i][j] == false) {
						visited[i][j] = true;
						dfs2(i, j);
						answer++;
					}
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] > '0' && map[i][j] <'9') {
						answer++;
					}
				}
			}
			
			System.out.println("#"+t+" "+ answer);
		}
	}
	
	static boolean visited[][];
	private static void dfs2(int x, int y) {
		for(int d=0; d<8; d++) {
			int nx= x+dx[d];
			int ny= y+dy[d];
			
			if(nx <0 || nx >=N || ny<0 || ny>= N || visited[nx][ny] == true) continue;
			if(map[nx][ny] == '0') {
				visited[nx][ny] = true;
				dfs2(nx, ny);
			}
			else {
				visited[nx][ny] = true;
				map[nx][ny] = (char)(-1 + '0');
			}
		}
	}
	static int dx[] = {1,-1,0,0, 1,-1,-1,1};
	static int dy[] = {0,0,1,-1, 1,-1,1,-1};
	private static void dfs(int x, int y) {
		int cnt=0;
		for(int d=0; d<8; d++) {
			int nx= x+dx[d];
			int ny= y+dy[d];
			
			if(nx <0 || nx >=N || ny<0 || ny>= N) continue;
			if(map[nx][ny] == '*') {
				cnt++;
			}
		}
		
		if(cnt == 0) {
			map[x][y] = '0'; //자기 자신과 8방향 0으로 체크하고 8방향 dfs드감
			for(int d=0; d<8; d++) {
				int nx= x+dx[d];
				int ny= y+dy[d];
				
				if(nx <0 || nx >=N || ny<0 || ny>= N || map[nx][ny] != '.') continue;
				dfs(nx, ny);
			}
		}
		else {
			map[x][y] = (char)(cnt + '0');
		}
	}
}
