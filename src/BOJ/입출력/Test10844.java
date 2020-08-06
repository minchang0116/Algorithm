package BOJ.입출력;

import java.util.Scanner;






public class Test10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[][] = new int[101][10];
		dp[1][0] = 0;
		dp[1][1] = 1;
		dp[1][2] = 1;
		dp[1][3] = 1;
		dp[1][4] = 1;
		dp[1][5] = 1;
		dp[1][6] = 1;
		dp[1][7] = 1;
		dp[1][8] = 1;
		dp[1][9] = 1;
		for(int i=2; i<=N; i++) {
			for(int j=0; j<10; j++) {
				if(j-1 < 0)
					dp[i][j] = dp[i-1][j+1];
				else if(j+1 > 9)
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			}
		}
		int sum=0;
		for(int i=0; i<=9; i++) {
			sum = (sum + dp[N][i]) % 1000000000;
		}
		
		System.out.println(sum);
	}
}
