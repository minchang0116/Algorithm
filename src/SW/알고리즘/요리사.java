package SW.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요리사 {
	static int map[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			for(int test_case = 1; test_case<=T; test_case++) {
				N = Integer.parseInt(br.readLine());
				map = new int[N][N];
				for(int i=0; i<N; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					for(int j=0; j<N; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				min = Integer.MAX_VALUE;
				check = new boolean[N];
				combination(0, 0);
				System.out.println("#"+test_case+ " "+ min);
				
				
			}
	}
	
	static int min;
	static boolean check[];
	static int numbers[];
	private static void combination(int k, int idx) {
		if(idx == N/2) {
			int a[] = new int[N/2];
			int b[] = new int[N/2];
			
			int aIdx = 0;
			int bIdx = 0;
			for(int i=0; i<N; i++) {
				if(check[i]== true) {
					a[aIdx++] = i;
				}
				else {
					b[bIdx++] = i;
				}
			}
			
			int sumA = 0;
			int sumB = 0;
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					sumA += map[a[i]][a[j]];
					sumB += map[b[i]][b[j]];
				}
			}
			min = Math.min(Math.abs(sumA-sumB), min);
			
				
		}
		for(int i=k; i<N; i++) {
			if(check[i] == false) {
				check[i] = true;
				combination(i+1, idx+1);
				check[i] = false;
			}
		}
	}
}
