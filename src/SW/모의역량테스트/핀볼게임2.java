package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 핀볼게임2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int [N][N];
			int dx[] = {1,-1,0,0}; // 남 북 동 서
			int dy[] = {0,0,1,-1};
			
			int wormholeSize = 5; // 6 ~ 10 웜홀
			ArrayList<Point> wormhole[] = new ArrayList[wormholeSize];
			for(int i=0; i<wormholeSize; i++) {
				wormhole[i] = new ArrayList<Point>();
			}
			
			
			StringTokenizer st;
			for(int i=0; i< N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp >= 6 && temp <= 10) {
						wormhole[temp-6].add(new Point(i, j));
					}
					map[i][j] = temp;
				}
			}
			
			int maxScore = 0;
			
			// 핀볼 처음부터 끝까지 순회
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 0) { 
						// 4방향 남 북 동 서
						for(int d=0; d<4; d++) {
							int nx = i;
							int ny = j;
							int dir = d; // 현재 방향
							int score = 0;
							while(true) {
								nx += dx[dir];
								ny += dy[dir];
								if(nx < 0 || nx >= N || ny<0 ||ny>=N) {
									score+=1;
									if(dir < 2) {
										dir = (dir+1) %2;
									}
									else {
										dir = 2 + (dir+1)%2;
									}
									nx += dx[dir];
									ny += dy[dir];
								}
								
								if((nx == i && ny == j) || (map[nx][ny] == -1)) { 
									maxScore = Math.max(maxScore, score);
									break;
								}
								
								if(map[nx][ny] >= 1 && map[nx][ny] <=5) {
									score+=1;
									if(map[nx][ny] == 1){ 
										if(dir == 0) dir = 2; 
										else if(dir == 1) dir = 0;
										else if(dir == 2) dir = 3;
										else if(dir == 3) dir = 1;
									}
									else if(map[nx][ny] == 2) {
										if(dir == 0) dir = 1;
										else if(dir == 1) dir = 2;
										else if(dir == 2) dir = 3;
										else if(dir == 3) dir = 0;
									}
									else if(map[nx][ny] == 3) {
										if(dir == 0) dir = 1;
										else if(dir == 1) dir = 3;
										else if(dir == 2) dir = 0;
										else if(dir == 3) dir = 2;
									}
									else if(map[nx][ny] == 4) {
										if(dir == 0) dir = 3;
										else if(dir == 1) dir = 0;
										else if(dir == 2) dir = 1;
										else if(dir == 3) dir = 2;
									}
									else if(map[nx][ny] == 5) {
										if(dir == 0) dir = 1;
										else if(dir == 1) dir = 0;
										else if(dir == 2) dir = 3;
										else if(dir == 3) dir = 2;
									}
								}
								else if(map[nx][ny] >= 6 && map[nx][ny] <=10) {
									// 웜홀일때
									for(int k=0; k<2; k++) {
										Point hole = wormhole[map[nx][ny]-6].get(k);
										if(hole.x != nx || hole.y != ny) {
											nx = hole.x;
											ny = hole.y;
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+maxScore);
		}
	}

	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

