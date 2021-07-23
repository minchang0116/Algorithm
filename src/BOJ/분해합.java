package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=1; i<N; i++) {
			int sum = i;
			int cur = i;
			while(cur > 0) {
				sum += cur%10;
				cur /= 10;
			}
			if(sum == N) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}
}
