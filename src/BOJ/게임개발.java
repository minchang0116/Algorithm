package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class 게임개발 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int inDegree[] = new int[N+1];
		int time[] = new int[N+1];
		ArrayList<Integer> adj[] = new ArrayList[N+1];
		int result[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=N; i++) {
			String val[] = br.readLine().split(" ");
			for(int j=0; j<val.length; j++) {
				int num = Integer.parseInt(val[j]);
				if(num == -1) break;
				if(j==0) {
					time[i] = num;
				}
				else {
					adj[num].add(i);
					inDegree[i]++;
				}
			}
			result[i] = time[i];
		}
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i=1; i<=N; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int next :adj[node]) {
				inDegree[next]--;
				result[next] = Math.max(result[next], result[node] + time[next]);
				if(inDegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(result[i]);
		}
	}
}
