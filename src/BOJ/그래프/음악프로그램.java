package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램 {
	
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int inDegree[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		int adj[][] = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			for(int j=0; j<len-1; j++) {
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1;
				from = to;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		countInDegree(adj, inDegree);
		pushQueue(q, visited, inDegree);
		
		int result[] = new int[N];
		int resultIdx = 0;
		while(!q.isEmpty()) {
			result[resultIdx] = q.poll();
			removeInDegree(result[resultIdx], adj, inDegree);
			pushQueue(q, visited, inDegree);
			resultIdx++;
		}
		
		if(resultIdx != N) {
			System.out.println(0);
		}
		else {
			for(int i=0; i<resultIdx; i++) {
				System.out.println(result[i]);
			}
		}
	}

	private static void removeInDegree(int cur, int[][] adj, int[] inDegree) {
		for(int i=1; i<=N; i++) {
			if(adj[cur][i] == 1) {
				inDegree[i]--;
			}
		}
	}

	private static void pushQueue(Queue<Integer> q, boolean[] visited, int[] inDegree) {
		for(int i= 1; i<=N; i++) {
			if(inDegree[i] == 0 && !visited[i]) {
				q.offer(i);
				visited[i] = true;
			}
		}
	}
	
	private static void countInDegree(int[][] adj, int[] inDegree) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(adj[i][j] == 1) {
					inDegree[j]++;
				}
			}
		}
	}
}
