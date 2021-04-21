package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보호필름2 {
	static int answer;
	static int D, W, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int film[][] = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;
			dfs(film);
			System.out.println("#" + test_case + " " + answer);

		}
	}




	private static void dfs(int[][] film) {
		
		// A
		dfs()
		// B
		dfs()
		// NOT
		dfs()
		
		
	}




	private static boolean filmCheck(int[][] film) {
		for (int i = 0; i < W; i++) { // 가로
			int cnt = 1;
			int maxCnt = 1;
			for (int j = 0; j < D - 1; j++) { // 두께
				if (film[j][i] == film[j + 1][i]) {
					cnt++;
					maxCnt = Math.max(maxCnt, cnt);
				} else {
					cnt = 1;
				}
			}
			if (maxCnt < K) { // 합격 기준에 못미치면
				return false;
			}
		}
		return true;
	}
}
