package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티 {
	static class Node implements Comparable<Node>{
		int num;
		int value;
		public Node(int num, int value) {
			this.num = num;
			this.value = value;
		}

		public int compareTo(Node o) {
			return Integer.compare(this.value, o.value);
		}
	}
	
	static int N,M,X;
	static ArrayList<Node> adj[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			adj[from].add(new Node(to, value));
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			int sum = dijkstra(i, X);
			sum += dijkstra(X, i);
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
	private static int dijkstra(int start, int end) {
		int dist[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.num] == true) continue;
			
			visited[cur.num] = true;
			for(Node next : adj[cur.num]) {
				if(!visited[next.num] && dist[next.num] > next.value + cur.value) {
					dist[next.num] = next.value + cur.value;
					pq.offer(new Node(next.num, dist[next.num]));
				}
			}
		}
		return dist[end];
		
	}
}
