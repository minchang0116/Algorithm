package BOJ.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1197_프림01 {
	
	static ArrayList<Edge> adjList[];
	static int V, E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
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
			adjList[to].add(new Edge(from, value));
		}
		
		makeMST();
		System.out.println(result);
	}
	
	static int result;
	private static void makeMST() {
		int minEdge[] = new int[V+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		boolean visited[] = new boolean[V+1];
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(new Vertex(1,0));
		
		int cnt = 0;
		while(true) {
			Vertex v = pq.poll();
			if(visited[v.no]== true) continue;
			result += v.value;
			visited[v.no] = true;
			
			if(++cnt == V) {
				return;
			}
			
			for(int i=0; i<adjList[v.no].size(); i++) {
				Edge temp = adjList[v.no].get(i);
				if(visited[temp.to] != true && minEdge[temp.to] > temp.value) {
					minEdge[temp.to] = temp.value;
					pq.add(new Vertex(temp.to, temp.value));
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
