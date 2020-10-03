package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무선충전 {
	
	static int dx[] = {0, 0, 1, 0, -1};
	static int dy[] = {0, -1, 0, 1, 0};
	static int A, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			int moveA[] = new int[M+1];
			int moveB[] = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			AP list[] = new AP[A]; 
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				list[i] = new AP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int nx = 1;
			int ny = 1;
			
			int nnx = 10;
			int nny = 10;
			
			result = 0;
			for(int i=0; i<=M; i++) {
				visited = new int[A];
				nx = nx +dx[moveA[i]];
				ny = ny +dy[moveA[i]];
				
				nnx = nnx +dx[moveB[i]];
				nny = nny +dy[moveB[i]];
				
				int a = 0;
				int b = 0;
				for(int j=0; j<A; j++) {
					if(list[j].C >= Math.abs(list[j].x - nx) +  Math.abs(list[j].y - ny)) {
						visited[j] = 1;
						a++;
					}
					if(list[j].C >= Math.abs(list[j].x - nnx) +  Math.abs(list[j].y - nny)) {
						visited[j] += 2;
						b++;
					}
				}
				
				int max = 0;
				// A만 충전 가능할 때 : A만 비교해서 최대값 누적
				if(b == 0) {
					for(int j=0; j<A; j++) {
						if(visited[j] == 1) {
							max = Math.max(max, list[j].P);
						}
					}
				}
				// B만 충전 가능할 때 : B만 비교해서 최대값 누적
				else if(a == 0) {
					for(int j=0; j<A; j++) {
						if(visited[j] == 2) {
							max = Math.max(max, list[j].P);
						}
					}
				}
				// 둘다 충전 가능할 때 : AB 조합해서 최대값 누적
				else if(a != 0 && b!= 0) {
					for(int k = 0; k<A; k++) {
						int sum=0;
						if(visited[k] == 1 || visited[k] == 3 ) {
							sum += list[k].P;
							max = Math.max(max, sum);
						}
						for(int l = 0; l<A; l++) {
							if(visited[l] == 2 ||visited[l] == 3 && l != k ) {
								max = Math.max(max, sum + list[l].P);
							}
						}
					}
				}
				result += max;
			}
			System.out.println("#"+t+" "+result);
			
		}
	}
	
	
	static int result;
	static int visited[];



	private static class AP{
		int x;
		int y;
		int C;
		int P;
		public AP(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}
	}
}
