package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 벌꿀채취2 {

	static int N, M, C;
	static int map[][];
	static boolean check[][];
	static int answer, maxSum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			check = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			solve();
			System.out.println("#" + test_case + " " + answer);
		}
	}

	private static void solve() {
		int window[] = new int[M];
		numbers = new int[M];
		Integer value[] = new Integer[N];
		for(int i=0; i<N; i++) {
			max = 0;
			for(int j=0; j<N; j++) {
				if(j+M <= N) {
					for(int k=j; k<j+M; k++) {
						window[k-j] = map[i][k];
					}
					combi(0,0,window);
				}
			}
			value[i] = max;
		}
		Arrays.sort(value, Collections.reverseOrder());
		answer += value[0];
		answer += value[1];
	}

	static int numbers[];
	static int max;
	private static void combi(int cnt, int idx, int[] window) {
		int sumHoneyCnt =0; // 벌꿀 양
		int sumHoneyValue = 0;
		for(int i=0; i<cnt; i++) {
			sumHoneyCnt += window[numbers[i]];
			sumHoneyValue += window[numbers[i]] * window[numbers[i]];
		}
		if(sumHoneyCnt<=C) {
			if(max < sumHoneyValue) {
				max = sumHoneyValue;
				
			}
		}
		if(cnt == M) return;
		for(int i=idx; i<M; i++) {
			numbers[cnt] = i;
			combi(cnt+1, i+1, window);
		}
	}


}
