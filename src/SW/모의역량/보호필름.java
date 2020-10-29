package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보호필름 {
		static int D,W,K;
		static int map[][];
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			for(int t=1; t<=T; t++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				D = Integer.parseInt(st.nextToken());
				W = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				
				map = new int[D][W];
				for(int i=0; i<D; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j=0; j<W; j++){
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				
				// 0이 A고 1이 B이다
				result =Integer.MAX_VALUE;
				numbers= new int[D];
				combi(0, 0);
				System.out.println("#"+t+" "+ result);
				
			}
		}
		
		static int numbers[];
		static int result;
		static int tempMap[][];
		private static void combi(int cnt, int idx) {
			tempMap = new int[D][W];
			for(int i=0; i<D; i++) {
				tempMap[i] = map[i].clone();
			}
			paint(0, cnt);
			for(int i=idx; i<D; i++) {
				if(result <= cnt) continue;
				numbers[cnt] = i;
				combi(cnt+1, i+1);
			}
		}
		
		static void paint(int c, int cnt) {
			if(c == cnt) {
				if(check()) {
					result = Math.min(result, cnt);
				}
				return;
			}
			for(int j=0; j<W; j++) {
				tempMap[numbers[c]][j] = 0;
			}
			paint(c+1, cnt);
			for(int j=0; j<W; j++) {
				tempMap[numbers[c]][j] = 1;
			}
			paint(c+1, cnt);
		};
		
		public static boolean check() {
			outer: for(int j=0; j<W; j++) {
				int cnt=0;
				for(int i=0; i<D-1; i++) {
					if(K-1==0) {
						continue outer;
					}
					if(tempMap[i][j] == tempMap[i+1][j]) {
						cnt++;
						if(cnt == K-1) {
							continue outer;
						}
					}
					else {
						cnt=0;
					}
				}
				return false;
			}
			return true;
		}
}
