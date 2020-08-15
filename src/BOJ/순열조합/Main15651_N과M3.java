package BOJ.순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15651_N과M3 {

	static int N, M;
	static int numbers[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		numbers = new int[M];
		dfs(0, 1);
		System.out.println(sb);

	}
	static StringBuilder sb ;
	static void dfs(int cnt, int idx) {
		if (cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = idx; i <= N; i++) {

				numbers[cnt] = i;
				dfs(cnt + 1, i);

			
		}
	}

}
