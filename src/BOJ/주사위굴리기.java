package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기 {
	
	static int dx[] = {0, 0, 0, -1, 1};
	static int dy[] = {0, 1, -1, 0, 0};
	static int dice[][];
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dice = new int[4][3];  // 1,1 윗면, 3,1 아랫면
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			if(x+dx[dir] <0 || x+dx[dir] >=N || y+dy[dir] <0|| y+dy[dir] >=M ) continue;
			x = x + dx[dir];
			y = y + dy[dir];
			rotation(dir);
			solve(x, y);
			System.out.println(dice[1][1]);
		}
		
	}
	private static void solve(int x, int y) {
		if(map[x][y] == 0 ) {
			map[x][y] = dice[3][1];
		}
		else {
			dice[3][1] = map[x][y];
			map[x][y] = 0;
		}
	}
	
	private static void rotation(int dir) {
		int temp = 0;
		switch(dir) {
		case 1: // 동쪽
			temp = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = dice[3][1];
			dice[3][1] = temp;
			break;
		case 2: // 서쪽
			temp = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = temp;
			break;
		case 3: // 북쪽
			temp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = temp;
			break;
		case 4: // 남쪽
			temp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = temp;
			break;
		}
	}
}
