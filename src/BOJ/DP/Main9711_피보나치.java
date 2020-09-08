package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 틀린 이유 
 * 1) 20억 더하기 20억 오버플로우니깐 long형으로 받아서 나머지연산
 * 2) memorization 초기화 값이랑 연산했는데 0인 것이랑 비교가 되야됨
 * 3) 출력이 많으니깐 출력시 StringBuilder로
 */
public class Main9711_피보나치 {
	static int Q;
	static long memo[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			memo = new long[P+1];
			Arrays.fill(memo, -1);
			Q = Integer.parseInt(st.nextToken());
			long num = pibo(P);
			sb.append("Case #").append(t).append(": ").append(num).append("\n");
		}
		System.out.println(sb);
	}
	
	static long pibo(int n){
		if(n==1 || n==2) {
			return 1%Q;
		}
		if(memo[n] != -1) {
			return memo[n];
		}
		return memo[n] = (pibo(n-1) + pibo(n-2))%Q;
	}

}
