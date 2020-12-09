package BOJ.기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 괄호추가 {
	
	static int[] arr;
	static char[] ope;
	static int N, opeCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String temp = br.readLine();
		opeCnt = N/2;
		arr = new int[opeCnt+1];
		ope = new char[opeCnt];
		int idx=0;
		for(int i=0; i<N; i++) {
			arr[idx] = temp.charAt(i++)-'0';
			if(i<N)
				ope[idx++] = temp.charAt(i);
		}
		
		dfs(0, arr[0]);
		System.out.println(answer);
	}
	
	static int answer = Integer.MIN_VALUE;
	private static void dfs(int cur, int sum) {		
		if(cur >= opeCnt) {
			answer = Math.max(answer, sum);
			return;
		}
		
		switch(ope[cur]){
			case '+':
				dfs(cur+1, sum  + arr[cur+1]);
				break;
			case '-':
				dfs(cur+1, sum  - arr[cur+1]);
				break;
			case '*':
				dfs(cur+1, sum  * arr[cur+1]);
				break;
		}
		
		if(cur+1 >= opeCnt) return; // 뒤에꺼 없으면 그냥 종료
		
		if(ope[cur] == '-') {
			if(ope[cur+1] == '-') {
				dfs(cur+2, sum  - (arr[cur+1] - arr[cur+2]));
			}
			else if(ope[cur+1] == '+') {
				dfs(cur+2, sum  - (arr[cur+1] + arr[cur+2]));
			}
		}
		
		if(ope[cur] == '*') { // 현재 연산자가 곱하기일때 뒤에꺼 합해서 넘겨주는거 추가
			switch(ope[cur+1]){
			case '+':
				dfs(cur+2, sum  * (arr[cur+1] + arr[cur+2]));
				break;
			case '-':
				dfs(cur+2, sum  * (arr[cur+1] - arr[cur+2]));
				break;
			}
		}
	
		if(ope[cur+1] == '*') { // 다음 연산자가 곱하기일때 뒤에꺼 합해서 넘겨주는거 추가
			switch(ope[cur]){
			case '+':
				dfs(cur+2, sum  + (arr[cur+1] * arr[cur+2]));
				break;
			case '-':
				dfs(cur+2, sum  - (arr[cur+1] * arr[cur+2]));
				break;
			}
		}
		
	}
}
