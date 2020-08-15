package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11057_오르막수 {
	static int DP[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		DP = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= 9; i++) {
			DP[i] = 1;
		}
		for (int i = 0; i < N-1; i++) { // 길이가 1이면 실행안함
			for(int k=8; k>=0; k--) {
				DP[k] = (DP[k]+DP[k+1])%10007; // 나머지 연산할 때 소괄호 체크 잘해야됨
			}
		}
		int result = 0;
		for (int i = 0; i <= 9; i++) {
			result = (result+ DP[i])%10007;
		}
		System.out.println(result);
	}
}
