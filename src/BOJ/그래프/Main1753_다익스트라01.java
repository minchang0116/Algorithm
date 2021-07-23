package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753_다익스트라01 {
	
	static ArrayList<Edge> adjList[];
	static int V, E,start;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V+1];
		for(int i=1; i<V+1; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			adjList[from].add(new Edge(to, value));
		}
		
		makeMST();
		for (int i = 1; i <= V; i++) {
			if (minEdge[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(minEdge[i]);
			}
		}
	}
	
	static int minEdge[];
	private static void makeMST() {
		minEdge = new int[V+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[start] = 0;
		boolean visited[] = new boolean[V+1];
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(new Vertex(start,0));
		int cnt =0;
		while(!pq.isEmpty()) {
			Vertex v = pq.poll();
			if(visited[v.no]== true) continue;
			visited[v.no] = true;
			
			for(int i=0; i<adjList[v.no].size(); i++) {
				Edge temp = adjList[v.no].get(i);
				if(visited[temp.to] != true && minEdge[temp.to] > minEdge[v.no] + temp.value) {
					minEdge[temp.to] = minEdge[v.no] + temp.value;
					pq.add(new Vertex(temp.to, minEdge[temp.to]));
				}
			}
		}
	}

	
	private static class Edge{
		int to;
		int value;
		public Edge(int to, int value) {
			this.to = to;
			this.value = value;
		}
	}
	
	private static class Vertex implements Comparable<Vertex>{
		int no;
		int value;
		public Vertex(int no, int value) {
			this.no = no;
			this.value = value;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.value, o.value);
		}
		
	}
}
