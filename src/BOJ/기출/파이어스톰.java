package BOJ.기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이어스톰 {

	static int map[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int rcLength = 1;
		for (int i = 0; i < N; i++) {
			rcLength *= 2;
		}
		map = new int[rcLength][rcLength];
		int nextMap[][] = new int[rcLength][rcLength];

		for (int i = 0; i < rcLength; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < rcLength; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < Q; k++) {
			int L = Integer.parseInt(st.nextToken());
			int fireLength = 1;
			for (int i = 0; i < L; i++) {
				fireLength *= 2;
			}

			int curR = 0;
			int curC = 0;
			
			// 90도 회전
			while (true) {
				if (curC+fireLength > rcLength) {
					curC =0;
					curR += fireLength;
				}
				if (curR+fireLength > rcLength) {
					break;
				}
				
				int a=curR;
				for(int j=curC; j<curC+fireLength; j++) {
					int b=curC;
					for(int i=curR+fireLength-1; i>=curR; i--) {
						nextMap[a][b] = map[i][j];
						b++;
					}
					b=curC;
					a++;
				}
				curC += fireLength;
			}
			
			for(int i=0; i<rcLength; i++) {
				map[i] = nextMap[i].clone();
			}
			
			// 인접한 얼음이 2개이하면 1씩 감소
			for(int i=0; i<rcLength; i++) {
				for(int j=0; j<rcLength; j++) {
					if(nextMap[i][j] != 0) {
						int cnt = 0;
						for(int d=0; d<4; d++) {
							int nr = i+dx[d];
							int nc = j+dy[d];
							if(nr < 0 || nr >= rcLength || nc <0 || nc>=rcLength) {
								continue;
							}
							// map으로 비교하는 이유는 nextMap으로 비교할 시 밑에서 nextMap의 값을 바꾸기 때문에
							// 잘못된 비교를 하게 됩니다.
							if(map[nr][nc] == 0) {
								continue;
							}
							cnt++;
						}
						
						if(cnt <=2) {
							nextMap[i][j] -= 1;
						}
					}
				}
			}
			for(int i=0; i<rcLength; i++) {
				map[i] = nextMap[i].clone();
			}
			
		}
		
		
		int sum = 0;
		int maxIce = 0;
		check = new boolean[rcLength][rcLength];
		// 이제 살아있는 얼음들의 합이랑 블러드필해서 가장 큰 덩어리의 갯수 뽑아내기
		for(int i=0; i<rcLength; i++) {
			for(int j=0; j<rcLength; j++) {
				sum += map[i][j];
				if(map[i][j] !=0 && check[i][j] == false) {
					check[i][j] = true;
					ice=1;
					dfs(i, j, rcLength);
					maxIce = Math.max(maxIce, ice);
				}
			}
		}
		
		System.out.println(sum);
		System.out.println(maxIce);
		

	}
	static int ice=0;
	static boolean check[][];
	static void dfs(int i, int j, int rcLength) {
		for(int d=0; d<4; d++) {
			int nr = i+dx[d];
			int nc = j+dy[d];
			if(nr < 0 || nr >= rcLength || nc <0 || nc>=rcLength || map[nr][nc] ==0 || check[nr][nc] == true) {
				continue;
			}
			ice+=1;
			check[nr][nc] = true;
			dfs(nr, nc, rcLength);
		}
	}
	
}
