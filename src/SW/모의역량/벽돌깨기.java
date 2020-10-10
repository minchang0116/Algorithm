package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벽돌깨기 {
	static int N, W, H;
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			numbers = new int[N];
			result = Integer.MAX_VALUE;
			permu(0);
			System.out.println("#"+t+" "+result);
			
		}
	}
	
	static int numbers[];
	static int tempMap[][];
	static int result;
	private static void permu(int cnt) {
		if(cnt == N) {
			tempMap = new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					tempMap[i][j] = map[i][j];
				}
			}
			
			
			for(int k=0; k<N; k++) {
				int j = numbers[k];
				for(int i=0; i<H; i++) {
					if(tempMap[i][j] != 0) {
						boom(i,j);
						move();
						break;
					}
				}
			}
			
			int sum=0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(tempMap[i][j] != 0) {
						sum++;
					}
				}
			}
			result = Math.min(result, sum);
			return;
		}
		
		for(int i=0; i<W; i++) {
			numbers[cnt] = i;
			permu(cnt+1);
		}
	}

	private static void move() {
		for(int j=0; j<W; j++) {
			for(int i=H-2; i>=0; i--) { // 맨밑에서 위에위에칸부터
				if(tempMap[i][j] != 0 && tempMap[i+1][j] == 0) {
					int ii = i;
					while(true) {
						ii++;
						if(ii==H || tempMap[ii][j] !=0) {
							ii--;
							break;
						}
					}
					
					tempMap[ii][j] =tempMap[i][j];
					tempMap[i][j] = 0;
				}
			}
		}
	}

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static void boom(int x, int y) {	// 0이면 안부름
		int range = tempMap[x][y]-1; // 1이면 1칸도 안감
		tempMap[x][y] = 0;
		if(range == 0) {
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nx = x;
			int ny = y;
			for(int i=0; i<range; i++) {	
				nx += dx[d];
				ny += dy[d];
				if(nx <0 || nx>= H || ny <0 || ny>=W ||tempMap[nx][ny] == 0) continue;
				boom(nx, ny);
			}
		}
	}
}
