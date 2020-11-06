package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 핀볼게임 {
	
	static int map[][];
	static int N;
	static Hole hole[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		hole = new Hole[11][2]; //웜홀 체크
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >=6 && map[i][j] <=10) {
					if(hole[map[i][j]][0] == null) {
						hole[map[i][j]][0] = new Hole(i,j);
					}
					else {
						hole[map[i][j]][1] = new Hole(i,j);
					}
				
				}
			}
		}
		
		// 핀볼의 최대 이동수
		// -1 블랙홀, 1~5 블록, 6~10 웜홀
		// 1은 아래로 가면 오른쪽, 왼쪽으로 가면 위쪽
		// 2는 왼쪽으로 가면 아래, 위로가면 오른쪽
		// 3은 위로가면 왼쪽, 오른쪽으로 가면 아래
		// 4는 아래로가면 왼쪽, 오른쪽으로 가면 위로
		// 5 는 반대로 튕김 // 벽도 반대
		
		
		max =0;
		// 출발위치와 진행방향을 임의로 설정가능
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) {
					solve(i, j);
				}
			}
		}
		System.out.println("#"+t+" "+max);
		}
		
	}
	
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int max;
	static void solve(int x, int y) {
		for(int d=0; d<4; d++) { // 첫 진행방향
			int nx = x;
			int ny = y;
			int dir = d; // 핀볼의 진행방향
			int point =0; // 점수
			while(true) {
				nx = nx + dx[dir];
				ny = ny + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) { // 벽이면 1점 오르고 돌아옴
					point++;
					dir = (dir + 2) % 4; //반대방향
					continue;
				}
				else if(map[nx][ny] >= 6 && map[nx][ny] <= 10) { // 웜홀이면
					int tempX = nx;
					int tempY = ny;
					if(hole[map[nx][ny]][0].x == nx && hole[map[nx][ny]][0].y == ny ) {
						nx = hole[map[tempX][tempY]][1].x;
						ny = hole[map[tempX][tempY]][1].y;
					}
					else {
						nx = hole[map[tempX][tempY]][0].x;
						ny = hole[map[tempX][tempY]][0].y;
					}
				}
				else if(map[nx][ny] <=5 && map[nx][ny] >=1) {
					if(map[nx][ny] == 1) {
						switch(dir) {
						case 0:
							dir = 1;
							break;
						case 3:
							dir = 2;
							break;
						default:
							dir = (dir + 2) % 4; //반대방향
						}
					
					}
					else if(map[nx][ny] == 2) {
						switch(dir) {
						case 3:
							dir = 0;
							break;
						case 2:
							dir = 1;
							break;
						default:
							dir = (dir + 2) % 4; //반대방향
						}
					}
					else if(map[nx][ny] == 3) {
						switch(dir) {
						case 2:
							dir = 3;
							break;
						case 1:
							dir = 0;
							break;
						default:
							dir = (dir + 2) % 4; //반대방향
						}
					}
					else if(map[nx][ny] == 4) {
						switch(dir) {
						case 0:
							dir = 3;
							break;
						case 1:
							dir = 2;
							break;
						default:
							dir = (dir + 2) % 4; //반대방향
						}
					}
					else if(map[nx][ny] == 5) {
						dir = (dir + 2) % 4; //반대방향
					}
					point++;
				}
				if(nx == x && ny == y || map[nx][ny] == -1) { // 종료조건
					max = Math.max(max, point);
					break;
				}
			}
		}
	}
	static class Hole{
		int x;
		int y;
		public Hole(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
