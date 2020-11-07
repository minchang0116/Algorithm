package SSAFY.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 추억의2048 {
	static int N;
	static String s;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			s = st.nextToken();
			int temp[] = new int[N];
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int idx;
			switch(s) {
				case "up":
					for(int j=0; j<N; j++) {
						idx =0;
						for(int i=N-1; i>=0; i--) {
							temp[idx++] = map[i][j];
						}
						move(temp);
						idx=0;
						for(int i=N-1; i>=0; i--) {
							map[i][j] = temp[idx++];
						}
					}
					break;
				case "down":
					for(int j=0; j<N; j++) {
						idx =0;
						for(int i=0; i<N; i++) {
							temp[idx++] = map[i][j];
						}
						move(temp);
						idx=0;
						for(int i=0; i<N; i++) {
							map[i][j] = temp[idx++];
						}
					}
					break;
				case "left":
					for(int i=0; i<N; i++) {
						idx =0;
						for(int j=N-1; j>=0; j--) {
							temp[idx++] = map[i][j];
						}
						move(temp);
						idx=0;
						for(int j=N-1; j>=0; j--) {
							map[i][j] = temp[idx++];
						}
					}
					break;
				case "right":
					for(int i=0; i<N; i++) {
						idx =0;
						for(int j=0; j<N; j++) {
							temp[idx++] = map[i][j];
						}
						move(temp);
						idx=0;
						for(int j=0; j<N; j++) {
							map[i][j] = temp[idx++];
						}
					}
					break;
			}
			
			
			System.out.println("#"+t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
		}
		
		
	}
	private static void move(int[] temp) {
		boolean checked[] = new boolean[N];
		for(int i=N-2; i>= 0; i--) { // 배열 마지막에서 한칸 앞에서 시작해서 마지막꺼랑 비교
			for(int j=i; j<N-1; j++) {
				if(temp[j+1] == 0) {  // 현재보다 뒷칸이 0이면
					temp[j+1] = temp[j]; // 뒷칸으로 옮김
					temp[j] = 0;
				}
				else if(temp[j+1] == temp[j] && checked[j+1] == false) { // 뒷칸이 같고, 합쳐진적이 없으면
					temp[j+1] *=2; // 합쳐줌
					temp[j] =0;
					checked[j+1] = true;
				}
				else if(temp[j] != 0) { // 현재가 0이 아닌 숫자일때 뒷칸과 합쳐질수 없으면 뒷칸 고정
					checked[j+1] = true;
				}
			}
		}
	}
}
