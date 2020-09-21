package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2578_빙고 {
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][5];
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				outer: for(int k=0; k<5; k++) {
					for(int l=0; l<5; l++) {
						if(map[k][l] == temp) {
							map[k][l]=0;
							if(check()) {
								System.out.println((i*5)+j+1);
								return;
							}
							break outer;
						}
					}
				}
			}

		}
		
		
	}
	private static boolean check() {
		int bingo=0;
		// 가로 빙고 체크
		outer: for(int i=0; i<5; i++) {
			if(map[i][0] == 0) {
				for(int j=1; j<5; j++) {
					if(map[i][j] != 0) continue outer;	// 0이 아닌 것이 나오면 다음 행 체크
				}
				bingo++;
			}
		}
		
		// 세로 빙고 체크
		outer: for (int j = 0; j < 5; j++) {
			if (map[0][j] == 0) {
				for (int i = 1; i < 5; i++) {
					if (map[i][j] != 0) continue outer; // 0이 아닌 것이 나오면 다음 열 체크
				}
				bingo++;
			}
		}
		
		// 대각선 빙고 체크
		outer: if(map[0][0] == 0) {
			for(int i=0; i<5; i++) {
				if (map[i][i] != 0) break outer;
			}
			bingo++;
		}
		
		// 대각선 빙고 체크
		outer: if(map[0][4] == 0) {
			for(int i=0; i<5; i++) {
				if (map[i][4-i] != 0) break outer;
			}
			bingo++;
		}
		
		if(bingo >= 3) {
			return true;
		}
		return false;
	}
}
