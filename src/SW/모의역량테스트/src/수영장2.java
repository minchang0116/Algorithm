package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장2 {
	static int day, month, month3, year,answer;
	static int plan[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			month3 = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			answer=Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.println("#"+test_case+" "+answer);
		}
	}

	private static void dfs(int idx, int sum) {
		if(idx >= 12) {
			answer = Math.min(answer, sum);
			return;
		}
		if (plan[idx] != 0) {
			dfs(idx+1, sum+day*plan[idx]); // 하루치
			dfs(idx+1, sum+month); // 한달
			dfs(idx+3, sum+month3); // 3달
			dfs(idx+12, sum+year); // 1년
		} else {
			dfs(idx + 1, sum);
		}
	}
}
