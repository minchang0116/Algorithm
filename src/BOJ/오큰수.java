package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<int []> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer[] = new int[N];
		stack.push(new int[] {Integer.parseInt(st.nextToken()), 0});
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()){
				if(stack.peek()[0] < cur) {
					answer[stack.pop()[1]] = cur;
				}
				else {
					break;
				}
			}
			stack.push(new int[] {cur, i});
		}
		while(!stack.isEmpty()) {
			answer[stack.pop()[1]] = -1;
		}
		
		for(int num : answer) {
			sb.append(num).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
