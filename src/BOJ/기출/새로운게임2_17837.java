package BOJ.기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 새로운게임2_17837 {

	static int N, K;
	static int map[][];
	static Piece[] piece;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		piece = new Piece[K+1];
		// 0 흰, 1 빨강, 2 파랑
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			piece[i] = new Piece(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
		}
		
		int count = 0;
		while(true) {
			count++;
			if(count > 1000) {
				System.out.println("-1");
				return;
			}
			for(int cur = 1; cur<=K; cur++) {
				int curX = piece[cur].x;
				int curY = piece[cur].y;
				int curOrder = piece[cur].order;
				
				int nextX = curX+dx[piece[cur].dir];
				int nextY = curY+dy[piece[cur].dir];
				if(nextX<1|| nextX>N || nextY <1 || nextY > N || map[nextX][nextY] == 2) { // 파랑이거나 벽이면 방향 반대로 바꿔줌
					if(piece[cur].dir == 1) piece[cur].dir = 2;
					else if(piece[cur].dir == 2) piece[cur].dir = 1;
					else if(piece[cur].dir == 3) piece[cur].dir = 4;
					else if(piece[cur].dir == 4) piece[cur].dir = 3;
					
					nextX = curX+dx[piece[cur].dir];
					nextY = curY+dy[piece[cur].dir];
					if(nextX<1|| nextX>N || nextY <1 || nextY > N || map[nextX][nextY] == 2) { //반대로 이동한 값이 파랑이거나 벽이면 컨티뉴
						continue;
					}
				}
				
				int curDir = piece[cur].dir;
				
				int curMaxOrder = 0;
				int nextMaxOrder = 0;
				for(int j=1; j<=K; j++) { // 다음 위치의 맥스 order 받아옴
					if(nextX == piece[j].x && nextY == piece[j].y) {
						nextMaxOrder = Math.max(nextMaxOrder, piece[j].order);
					}
					if(curX == piece[j].x && curY == piece[j].y) {
						curMaxOrder = Math.max(curMaxOrder, piece[j].order);
					}
				}
				
				// 가기전에 같은 좌표에 자기보다 높은 순서들 같이 이동
				for(int i=1; i<=K; i++) {
					if(curX == piece[i].x && curY == piece[i].y) { // 같은 좌표고
						if(curOrder <= piece[i].order) { // 현재보다 같거나 레벨높으면
							if(map[nextX][nextY] == 0) { // 흰이면 다같이 가면됨
								piece[i].x += dx[curDir];
								piece[i].y += dy[curDir];
								piece[i].order += nextMaxOrder - curOrder + 1;
							}
							else if(map[nextX][nextY] == 1) { // 빨강이면 순서바꿔야됨
								piece[i].x += dx[curDir];
								piece[i].y += dy[curDir];
								piece[i].order = Math.abs(piece[i].order - curMaxOrder) + 1 + nextMaxOrder;
							}
						}
					}
				}
	
				for(int i=1; i<=K; i++) {
					if(piece[i].order == 4) {
						System.out.println(count);
						return;
					}
				}
			}
		}
	}
	
	static int dx[] = {0, 0, 0, -1, 1};
	static int dy[] = {0, 1, -1, 0, 0};
	
	private static class Piece{
		int x;
		int y;
		int dir;
		int order;
		public Piece(int x, int y, int dir, int order) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.order = order;
		}
	}
}
