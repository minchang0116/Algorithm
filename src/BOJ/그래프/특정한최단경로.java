package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {
	static class Node implements Comparable<Node>{
		int no;
		int weight;
		public Node(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int adj[][];
	static int N,M;
	static final int INF = 200000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[a][b] = w;
			adj[b][a] = w;
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int sum = 0;
		sum += dijkstra(1, v1);
		sum += dijkstra(v1, v2);
		sum += dijkstra(v2, N);
		int answer = sum;

		sum = 0;
		sum += dijkstra(1, v2);
		sum += dijkstra(v2, v1);
		sum += dijkstra(v1, N);
		answer = Math.min(answer, sum);
		
		if(answer >= INF) {
			System.out.println(-1);
		}
		else {
			System.out.println(answer);
		}
	}
	
	private static boolean isCheck(int sum) {
		if(sum ==Integer.MAX_VALUE) {
			return true;
		}
		return false;
	}

	static int dijkstra(int start, int end) {
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		
		int dist[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.no] == true) continue;
			visited[cur.no] = true;

			for(int i=1; i<=N; i++) {
				if(!visited[i] && adj[cur.no][i] != 0 && dist[i] > adj[cur.no][i] + cur.weight) {
					dist[i] = adj[cur.no][i] + cur.weight;
					pq.offer(new Node(i, adj[cur.no][i] + cur.weight));
				}
			}
		}
		return dist[end];
	}
}
