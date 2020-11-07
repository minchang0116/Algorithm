package SSAFY.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_키순서_5643 {

	static int map[][];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st;
			map = new int [N][N];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;  // 자기보다 크면 1
				map[b][a] = -1; // b입장에서 a는 자기보다 작으니깐 -1
				check(a,b);
			}
			
			
		}
	}
	private static void check(int x, int y) {
		for(int i=0; i<N; i++) {
			if(map[x][i] == 1) { // 자기보다 큰쪽으로 
				map[x][i] 
				check(r, i);
			}
			
			if(map[r][i] == -1) { // 자기보다 작은쪽으로
				down(r, i);
			}
		}
	}

}
