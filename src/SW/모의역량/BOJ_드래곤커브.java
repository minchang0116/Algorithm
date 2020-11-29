package SW.모의역량;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_드래곤커브 {
	static int map[][];
	static int dx[] = {0,-1,0,1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		StringTokenizer st = null;
		for(int i=1; i<=N; i++) {
			st =new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			map[x][y] = i;
			map[x+dx[dir]][x+dy[dir]] = i;
			solve(x+dx[dir], x+dy[dir], dir, cnt); // 끝점
			solves(cnt,dir);
		}
	}
	private static void solves(int cnt, int dir) {
		
		
	}
	// 반시계로 90도 회전  회전 dir이  스택으로 관리
	private static void solve(int x, int y, int dir, int cnt) {
		
	}
}
