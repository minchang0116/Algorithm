package BOJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nQueen {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0;
		for(int j=1; j<=N; j++) {
			int arr[] = new int[N+1];
			arr[1] = j;
			dfs(2, arr);
		}
		
		System.out.println(answer);
	}

	static int answer;
	private static void dfs(int i, int[] arr) {
		if(i == N+1) {
			answer++;
		}
		
		outer: for(int j=1; j<=N; j++) {
			for(int k=1; k<i; k++) {
				if(arr[k] == j || arr[k]+(i-k) == j || arr[k]-(i-k)==j ) {
					continue outer;
				}
			}
			arr[i] = j;
			dfs(i+1, arr);
		}
	}
}
