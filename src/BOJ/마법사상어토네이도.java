package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어토네이도 {
	static int N;
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		map = new int[N][N];
		StringTokenizer st;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		solve();
		System.out.println(answer);
	}
	private static void solve() {
		int nx = N/2;
		int ny = N/2;
		int dir = 0;
		int dirCnt = 0; // 2번 바뀔때마다 moveGoal이 1개씩 늘어남
		int moveGoalCnt = 1; // 좌하 1번 우상 2번 좌하 3번씩, 이동해야하는 횟수가 1씩 늘어남
		int moveCurCnt = 0;
		while(true) {
			if(nx == 0 && ny ==0) break;
			nx = nx+dx[dir];
			ny = ny+dy[dir];
			if(map[nx][ny] !=0 ) {
				moveSand(nx, ny, dir);
			}
			
			moveCurCnt++;
			if(moveGoalCnt == moveCurCnt) { // 이동해야할 거리를 채우면 방향을 바꾼다.
				moveCurCnt = 0;
				dir = (dir + 1) % 4;
				dirCnt++;
			}
			
			if(dirCnt == 2) { // 방향이 2번 바뀔때마다 이동해야할 거리는 1씩 증가한다.
				dirCnt = 0;
				moveGoalCnt++;
			}
		}
	}
	
	static int dx[] = {0, 1, 0, -1}; // 좌 하 우 상
	static int dy[] = {-1, 0, 1, 0};
	static int answer;
	private static void moveSand(int sx, int sy, int dir) {
		int sum = 0;
		// 일단 5%
		int nx = sx+dx[dir]*2;
		int ny = sy+dy[dir]*2;
		sum += isBoundResult(nx,ny,sx,sy,5);
		
		// 10%
		nx = sx+dx[dir];
		ny = sy+dy[dir];
		for(int d=1; d<=3; d+=2) {
			int nnx = nx+dx[(dir+d)%4];
			int nny = ny+dy[(dir+d)%4];
			sum += isBoundResult(nnx, nny, sx, sy, 10); 
		}
		
		// 7% 2%
		nx = sx;
		ny = sy;
		for(int d=1; d<=3; d+=2) {
			for(int i=1; i<=2; i++) {
				int nnx = nx+dx[(dir+d)%4]*i;
				int nny = ny+dy[(dir+d)%4]*i;
				if(i == 1)
					sum += isBoundResult(nnx,nny, sx, sy, 7);
				else
					sum += isBoundResult(nnx,nny, sx, sy, 2);
			}
		}
		
		// 1%
		nx = sx - dx[dir];
		ny = sy - dy[dir];
		for(int d=1; d<=3; d+=2) {
			int nnx = nx+dx[(dir+d)%4];
			int nny = ny+dy[(dir+d)%4];
			sum += isBoundResult(nnx, nny, sx, sy, 1); 
		}
		
		nx = sx + dx[dir];
		ny = sy + dy[dir];
		if(isBound(nx, ny)){
			map[nx][ny] += map[sx][sy] - sum;
		}
		else {
			answer += map[sx][sy] - sum;
		}
		
		map[sx][sy] = 0;
	}
	
	private static int isBoundResult(int nx, int ny, int sx, int sy, int per) {
		if(isBound(nx, ny)) {
			map[nx][ny] += map[sx][sy] * per / 100;
		}
		else {
			answer += map[sx][sy] * per / 100;
		}
		return map[sx][sy] * per / 100;
	}
	
	private static boolean isBound(int nx, int ny) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
			return false;
		}
		return true;
	}
}
