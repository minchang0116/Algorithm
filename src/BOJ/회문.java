package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문 {
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			answer = 2;
			solve(0, sb.length()-1, sb, 0);
			System.out.println(answer);
		}
	}
	private static void solve(int left, int right, StringBuilder sb, int flag) {
		while(true) {
			if(left >= right) {
				break;
			}
			
			if(sb.charAt(left) == sb.charAt(right)) {
				left++;
				right--;
			}
			else {
				if(flag == 0) {
					solve(left+1, right, sb, 1);
					solve(left, right-1, sb, 1);
				}
				return;
			}
		}
		
		if(flag == 1) {
			answer =1;
		}
		else {
			answer =0;
		}
	}
}
