package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean visited[] = new boolean[N+1];
		int numbers[] = new int[N+1];
		permu(0,N, M, visited, numbers);
	}

	
	private static void permu(int idx, int N, int M, boolean[] visited, int[] numbers) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) {
				continue;
			}
			numbers[idx] = i;
			visited[i] = true;
			permu(idx+1, N, M, visited, numbers);
			visited[i] = false;
			
		}
	}
}
