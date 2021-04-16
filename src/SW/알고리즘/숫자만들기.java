package SW.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자만들기 {
	static int operator[];
	static int nums[];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		operator = new int[4];
		for(int test_case = 1; test_case<=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			nums = new int[N];
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for(int i=0; i<4; i++) {
				if(operator[i] != 0) {
					operator[i]--;
					dfs(nums[0], nums[1], i, 1);
					operator[i]++;
				}
			}
			System.out.println("#"+test_case + " " + (max-min));
		}
		
	}
	
	static int min;
	static int max;
	private static void dfs(int prev, int next, int i, int curIdx) {
		if(i == 0) { // +
			next = prev + next;
 		}
		else if(i == 1) { // -
			next = prev - next;
		}
		else if(i == 2) { // *
			next = prev * next;
		}
		else if(i == 3) { // /
			next = prev / next;
		}
		
		
		for(int k=0; k<4; k++) {
			if(operator[k] != 0) {
				operator[k]--;
				dfs(next, nums[curIdx+1], k, curIdx+1);
				operator[k]++;
			}
		}
		if(curIdx == N-1) {
			max = Math.max(next, max);
			min = Math.min(next, min);
			return;
		}
		
	}
}
