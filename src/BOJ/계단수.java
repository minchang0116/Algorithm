package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][][] = new int[N + 1][10][1 << 10];
		int MOD = 1000000000;
		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k < (1 << 10); k++) {
					if (j == 0) {
						dp[i][0][1 << 0 | k] = (dp[i][0][1 << 0 | k] + dp[i - 1][1][k]) % MOD;
					} else if (j == 9) {
						dp[i][9][1 << 9 | k] = (dp[i][9][1 << 9 | k] + dp[i - 1][8][k]) % MOD;
					} else {
						dp[i][j][1 << j | k] = (dp[i][j][1 << j | k] + dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD;
					}
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer = (answer + dp[N][i][(1 << 10) - 1]) % MOD;
		}
		System.out.println(answer);

	}
}
