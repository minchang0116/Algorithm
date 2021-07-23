package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	static class Node implements Comparable<Node>{
		int num;
		int weight;
		
		
		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	
	static int start, end, N, M;
	static List<Node> nodeList[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		nodeList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			nodeList[i] = new ArrayList<Node>();
		}
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			nodeList[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijkstra();
			
	}
	
	static void dijkstra() {
		boolean visited[] = new boolean[N+1];
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		
		Node cur;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(visited[cur.num]) continue;
			visited[cur.num] = true;
			
			for(Node next : nodeList[cur.num]) {
				if(!visited[next.num] && dist[next.num] > dist[cur.num] + next.weight) {
					dist[next.num] = dist[cur.num] + next.weight;
					pq.offer(new Node(next.num, dist[next.num]));
				}
			}
		}
		System.out.println(dist[end]);
	}
}
